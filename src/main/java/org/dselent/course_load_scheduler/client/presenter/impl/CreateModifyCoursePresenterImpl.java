package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;
import com.ibm.icu.impl.Row;


public class CreateModifyCoursePresenterImpl extends BasePresenterImpl implements CreateModifyCoursePresenter
{
	
	private CreateModifyCourseView view;
	
	private List<Course> courses;
	private List<Section> currentSections;
	
	private final ListDataProvider<Section> dataProvider;
	private final SingleSelectionModel<Section> selectionModel;

	@Inject
	public CreateModifyCoursePresenterImpl(CreateModifyCourseView view)
	{
			this.view = view;
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
	
	public void onModifyCourse(ModifyCourseEvent evt) {
		Course course = evt.getAction().getCourse();
		
		view.setCourseNameTextBoxText(course.getCourseName());
		view.setCourseNumberTextBoxText(course.getCourseNumber());
	}
	
	@Override
	public void addSection() {
		List<Section> sections = new ArrayList<>();
		Section section = new Section();
		section.setSectionName(view.getSectionNameTextBox().getText());
		section.setCrn(Integer.parseInt(view.getCrnTextBox().getText()));
		section.setType(view.getTypeTextBox().getText());
		section.setExpectedPopulation(Integer.parseInt(view.getPopTextBox().getText()));
		section.setFrequency(Integer.parseInt(view.getFreqTextBox().getText()));
		sections.add(section);
		currentSections.add(section);
	    dataProvider.setList(currentSections);
	    dataProvider.refresh();
	}
	
	@Override
	public void removeSection() {
		currentSections.remove(currentSections.size()-1);
		Section selected = selectionModel.getSelectedObject();
        if (selected != null) {
            dataProvider.getList().remove(selected);
            dataProvider.refresh();
        }
	}
	
	@Override
	public void createModifyCourseSubmit() {
		List<Section> sections = new ArrayList<>();
		Section section = new Section();
		
		
		Course course = new Course();
		course.setCourseName(view.getCourseNameTextBox().getText());
		course.setCourseNumber(view.getCourseNumberTextBox().getText());
		course.setSections(sections);
		
		//TODO: Send to database
	}
	
	@Override
	public void clearForm() {
		view.setCourseNameTextBoxText("");
		view.setCourseNumberTextBoxText("");
		view.setCrnTextBoxText("");
		view.setSectionNameTextBoxText("");
		view.setTypeTextBoxText("");
		view.setPopTextBoxText("");
		view.setFreqTextBoxText("");
		dataProvider.getList().clear();
	}
		
}
