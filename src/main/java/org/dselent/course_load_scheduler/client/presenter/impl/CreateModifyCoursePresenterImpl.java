package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidAddModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidAddModifyCourseStrings;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitCourseEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.DuplicateCRNException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyArrayException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;


public class CreateModifyCoursePresenterImpl extends BasePresenterImpl implements CreateModifyCoursePresenter
{
	
	private CreateModifyCourseView view;
	private IndexPresenter parentPresenter;

	private List<Section> currentSections;
	
	private final ListDataProvider<Section> dataProvider;
	private final SingleSelectionModel<Section> selectionModel;

	@Inject
	public CreateModifyCoursePresenterImpl(CreateModifyCourseView view, IndexPresenter parentPresenter)
	{
			this.view = view;
			this.parentPresenter = parentPresenter;
			view.setPresenter(this);
			
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
		
		registration = eventBus.addHandler(InvalidSubmitCourseEvent.TYPE, this);
		eventBusRegistration.put(InvalidSubmitCourseEvent.TYPE, registration);
		
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
		if(course != null) {
			view.setCourseNameTextBoxText(course.getCourseName());
			view.setCourseNumberTextBoxText(course.getCourseNumber());
			//view.addRowsToSectionTable(course.getSections());
			currentSections = course.getSections();
			dataProvider.setList(currentSections);
			dataProvider.refresh();
		}
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
			invalidReasonList.add(InvalidAddModifyCourseStrings.EMPTY_SECTION_FIELD);
		}
		catch (DuplicateCRNException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.DUPLICATE_CRN);
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
			InvalidAddModifyCourseAction iasa = new InvalidAddModifyCourseAction(invalidReasonList);
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
	
	private void checkEmptyArray(List<?> list) throws EmptyArrayException
	{
		if(list.size() == 0)
		{
			throw new EmptyArrayException();
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
		InvalidAddModifyCourseAction iamca = evt.getAction();
		view.showErrorMessages(iamca.toString());
	}
	
	@Override
	public void removeSection() {
		Section selected = selectionModel.getSelectedObject();
        if (selected != null) {
        	currentSections.remove(selected);
            dataProvider.setList(currentSections);
            dataProvider.refresh();
        }
        while(selectionModel.getSelectedSet().size() > 0) {
            selectionModel.setSelected(selectionModel.getSelectedObject(), false);
        }
	}
	
	@Override
	public void createModifyCourseCancel() {
		clearForm();

		ViewCourseAction vca = new ViewCourseAction(new ArrayList<Course>());
		AdminCourseEvent ace = new AdminCourseEvent(vca);
		eventBus.fireEvent(ace);
	}
	
	@Override
	public void createModifyCourseSubmit() {
		Course course = new Course();
		
		String courseName = view.getCourseNameTextBox().getText();
		String courseNumber = view.getCourseNumberTextBox().getText();
		List<Section> sections = dataProvider.getList();
		
		List<String> invalidReasonList = new ArrayList<>();
		
		try {
			checkEmptyString(courseName);
			checkEmptyString(courseNumber);
			checkEmptyArray(sections);
		}
		catch (EmptyStringException | EmptyArrayException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.EMPTY_COURSE_FIELD);
		}
		
		if(invalidReasonList.size() == 0) {
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setSections(sections);
			
			//TODO: Send to database
			
			clearForm();
			
			ViewCourseAction vca = new ViewCourseAction(new ArrayList<Course>());
			AdminCourseEvent ace = new AdminCourseEvent(vca);
			eventBus.fireEvent(ace);
		}
		else {
			InvalidAddModifyCourseAction iamca = new InvalidAddModifyCourseAction(invalidReasonList);
			InvalidSubmitCourseEvent isce = new InvalidSubmitCourseEvent(iamca);
			eventBus.fireEvent(isce);
		}
	}
	
	@Override
	public void onInvalidSubmitCourse(InvalidSubmitCourseEvent evt) 
	{
		InvalidAddModifyCourseAction iamca = evt.getAction();
		view.showErrorMessages(iamca.toString());
	}
	
	@Override
	public void clearForm() {
		view.setCourseNameTextBoxText("");
		view.setCourseNumberTextBoxText("");
		clearSectionForm();
		currentSections.clear();
		dataProvider.getList().clear();
		dataProvider.refresh();
		/*CellTable<Section> sectionTable = view.getSectionTable();
		sectionTable.setRowData(dataProvider.getList());
		view.setSectionTable(sectionTable);*/
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
