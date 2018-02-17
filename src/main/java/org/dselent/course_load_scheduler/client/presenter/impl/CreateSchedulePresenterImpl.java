package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectCoursesAction;
import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class CreateSchedulePresenterImpl extends BasePresenterImpl implements CreateSchedulePresenter
{
	private IndexPresenter parentPresenter;
	private CreateScheduleView view;
	
	@Inject
	public CreateSchedulePresenterImpl(IndexPresenter parentPresenter, CreateScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		List<String> names = Arrays.asList("Course1", "Course2", "Course3");
		view.addCourses(names);
	}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind(){
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(CreateScheduleNavigationEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleNavigationEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());	
	}

	@Override
	public CreateScheduleView getView() {
		return view;
	}
	
	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	public void goToNextPage(List<String> courseNames){
		List<Course> courseList = new ArrayList<Course>();
		//pull from database instead of this
		for(String name: courseNames) {
			Course course = new Course();
			course.setCourseName(name);
			course.setCourseNumber("3733");
			List<Section> sectionList = new ArrayList<Section>();
			Section section = new Section();
			section.setSectionName("Test Section");
			section.setCrn(45678);
			section.setType("Lecture");
			section.setExpectedPopulation(50);
			section.setFrequency(2);
			sectionList.add(section);
			sectionList.add(section);
			course.setSections(sectionList);
			courseList.add(course);
		}
		fireCreateScheduleSelectCourses(courseList);
	}
	
	public void fireCreateScheduleSelectCourses(List<Course> courseList) {
		CreateScheduleSelectCoursesAction cssca = new CreateScheduleSelectCoursesAction(courseList);
		CreateScheduleSelectCoursesEvent cssce = new CreateScheduleSelectCoursesEvent(cssca);
		eventBus.fireEvent(cssce);
	}
	
	@Override
	public void onCreateScheduleNavigation(CreateScheduleNavigationEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
	}

}
