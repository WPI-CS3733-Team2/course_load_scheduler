package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidAddSectionAction;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidAddSectionStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.DuplicateCRNException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;
import com.ibm.icu.impl.Row;


public class CreateModifyCoursePresenterImpl extends BasePresenterImpl implements CreateModifyCoursePresenter
{
	
	private CreateModifyCourseView view;
	private IndexPresenter parentPresenter;
	
	private List<Course> courses;
	private List<Section> currentSections;
	
	private final ListDataProvider<Section> dataProvider;
	private final SingleSelectionModel<Section> selectionModel;

	@Inject
	public CreateModifyCoursePresenterImpl(CreateModifyCourseView view, IndexPresenter parentPresenter)
	{
			this.view = view;
			this.parentPresenter = parentPresenter;
			view.setPresenter(this);
			
			this.courses = new ArrayList<Course>();
			this.currentSections = new ArrayList<Section>();
			
			dataProvider = new ListDataProvider<Section>(currentSections);
		    dataProvider.addDataDisplay(view.getSectionTable());

		    selectionModel = new SingleSelectionModel<Section>();
		    view.setSectionTableSelectionModel(selectionModel);
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidAddSectionEvent.TYPE, this);
		eventBusRegistration.put(InvalidAddSectionEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ModifyCourseEvent.TYPE, this);
		eventBusRegistration.put(ModifyCourseEvent.TYPE, registration);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public CreateModifyCourseView getView() {
		return view;
	}
	
	@Override
	public void onModifyCourse(ModifyCourseEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		
		Course course = evt.getAction().getCourse();
		
		view.setCourseNameTextBoxText(course.getCourseName());
		view.setCourseNumberTextBoxText(course.getCourseNumber());
	}
	
	@Override
	public void addSection() {
		List<Section> sections = dataProvider.getList();
		Section section = new Section();
		
		String sectionName = view.getSectionNameTextBox().getText();
		String crn = view.getCrnTextBox().getText();
		String type = view.getTypeTextBox().getText();
		String expectedPop = view.getPopTextBox().getText();
		String freq = view.getFreqTextBox().getText();
		
		List<String> invalidReasonList = new ArrayList<>();
		
		try {
			checkEmptyString(sectionName);
			checkEmptyString(crn);
			checkEmptyString(type);
			checkEmptyString(expectedPop);
			checkEmptyString(freq);
			checkDuplicateCrn(Integer.parseInt(crn), sections);
		}
		catch(EmptyStringException e) {
			invalidReasonList.add(InvalidAddSectionStrings.EMPTY_SECTION_FIELD);
		}
		catch (DuplicateCRNException e) {
			invalidReasonList.add(InvalidAddSectionStrings.DUPLICATE_CRN);
		}
		
		if(invalidReasonList.size() == 0)
		{

			section.setSectionName(sectionName);
			section.setCrn(Integer.parseInt(crn));
			section.setType(type);
			section.setExpectedPopulation(Integer.parseInt(expectedPop));
			section.setFrequency(Integer.parseInt(freq));
			
			clearSectionForm();
			currentSections.add(section);
		    dataProvider.setList(currentSections);
		    dataProvider.refresh();
		
		}
		else
		{
			InvalidAddSectionAction iasa = new InvalidAddSectionAction(invalidReasonList);
			InvalidAddSectionEvent iase = new InvalidAddSectionEvent(iasa);
			eventBus.fireEvent(iase);
		}
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	private void checkDuplicateCrn(int crn, List<Section> sections) throws DuplicateCRNException
	{
		for(int i = 0; i < sections.size(); i++) {
			if(crn == sections.get(i).getCrn()) {
				throw new DuplicateCRNException();
			}
		}
	}
	
	@Override
	public void onInvalidAddSection(InvalidAddSectionEvent evt)
	{
		parentPresenter.hideLoadScreen();
		
		InvalidAddSectionAction iasa = evt.getAction();
		view.showErrorMessages(iasa.toString());
	}
	
	@Override
	public void removeSection() {
		currentSections.remove(currentSections.size()-1);
		Section selected = selectionModel.getSelectedObject();
        if (selected != null) {
            dataProvider.getList().remove(selected);
            dataProvider.refresh();
        }
        while(selectionModel.getSelectedSet().size() > 0) {
            selectionModel.setSelected(selectionModel.getSelectedObject(), false);
        }
	}
	
	@Override
	public void createModifyCourseSubmit() {
		Course course = new Course();
		course.setCourseName(view.getCourseNameTextBox().getText());
		course.setCourseNumber(view.getCourseNumberTextBox().getText());
		course.setSections(dataProvider.getList());
		
		//TODO: Send to database
		
		clearForm();
	}
	
	@Override
	public void clearForm() {
		view.setCourseNameTextBoxText("");
		view.setCourseNumberTextBoxText("");
		clearSectionForm();
		dataProvider.getList().clear();
	}
	
	@Override
	public void clearSectionForm() {
		view.setSectionNameTextBoxText("");
		view.setCrnTextBoxText("");
		view.setTypeTextBoxText("");
		view.setPopTextBoxText("");
		view.setFreqTextBoxText("");
	}
		
}
