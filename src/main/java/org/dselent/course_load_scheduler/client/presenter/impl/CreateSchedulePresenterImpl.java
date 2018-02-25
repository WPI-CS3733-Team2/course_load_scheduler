package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectCoursesAction;
import org.dselent.course_load_scheduler.client.action.SearchSpecificCourseAction;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.SearchSpecificCourseEvent;
import org.dselent.course_load_scheduler.client.model.Calendar;
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
	private List<Course> courses = new ArrayList<Course>();
	private List <Section> sections = new ArrayList<Section>();
	
	@Inject
	public CreateSchedulePresenterImpl(IndexPresenter parentPresenter, CreateScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
	}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind(){
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(ReceiveCreateScheduleNavigationEvent.TYPE, this);
		eventBusRegistration.put(ReceiveCreateScheduleNavigationEvent.TYPE, registration);
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
	
	public void goToNextPage(List<Integer> indexes){
		List<Course> checkedCourses = new ArrayList<Course>();
		for (Integer num : indexes) {
			Section section = sections.get(num);
			for (Course course : courses) {
				if (course.getSections().contains(section)) {
					checkedCourses.add(course);
				}
			}
		}
		
		fireCreateScheduleSelectCourses(checkedCourses);
	}
	
	public void fillAvailableCourses(List<Course> courseList) {
		List<String> presentableCourseNames = new ArrayList<String>();
		for(Course course : courseList) {
			List<Section> sectionList = course.getSections();
			for(Section section : sectionList) {
				Calendar calendar = section.getCalendar();
				String courseDetails = course.getCourseName() + " " + course.getCourseNumber() + " " + calendar.getSemester() + " " + section.getSectionName();
				presentableCourseNames.add(courseDetails);
			}
		}
		view.addCourses(presentableCourseNames);
	}
	
	
	public void fireCreateScheduleSelectCourses(List<Course> courseList) {
		CreateScheduleSelectCoursesAction cssca = new CreateScheduleSelectCoursesAction(courseList);
		CreateScheduleSelectCoursesEvent cssce = new CreateScheduleSelectCoursesEvent(cssca);
		eventBus.fireEvent(cssce);
	}
	
	public void results() {
		view.getCoursesVerticalPanel().clear();
		final String searchTerm = view.getSearchTextBox().getText().trim();
		SearchSpecificCourseAction ssca = new SearchSpecificCourseAction(searchTerm);
		SearchSpecificCourseEvent ssce = new SearchSpecificCourseEvent(ssca, parentPresenter.getView().getViewRootPanel());
		eventBus.fireEvent(ssce);
	}	
	
	@Override
	public void onReceiveCreateScheduleNavigation(ReceiveCreateScheduleNavigationEvent evt) {
		courses.clear();
		sections.clear();
		view.getCoursesVerticalPanel().clear();
		courses = evt.getAction().getModels();
		for (Course course: courses) {
			for (Section section: course.getSections()) {
				sections.add(section);
			}
		}
		fillAvailableCourses(courses);
		this.go(parentPresenter.getView().getViewRootPanel());
	}

}
