package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.CreateScheduleAction;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ConfirmScheduleView;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;

import com.google.gwt.event.shared.HandlerRegistration;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ConfirmSchedulePresenterImpl extends BasePresenterImpl implements ConfirmSchedulePresenter{
	private IndexPresenter parentPresenter;
	private ConfirmScheduleView view;
	private boolean scheduleCreationInProgress;
	private List<Course> courses = new ArrayList<Course>();
	private Integer facultyId = 0;
	private List<Integer> sectionIds = new ArrayList<Integer>();
	
	@Inject
	public ConfirmSchedulePresenterImpl(IndexPresenter parentPresenter, ConfirmScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		scheduleCreationInProgress = false;
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
		
		registration = eventBus.addHandler(CreateScheduleEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ConfirmSchedulePageEvent.TYPE, this);
		eventBusRegistration.put(ConfirmSchedulePageEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public ConfirmScheduleView getView()
	{
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
	
	//Creates schedule
	//Uses data provided in previous pages
	@Override
	public void createSchedule() {
		if(!scheduleCreationInProgress)
		{
			scheduleCreationInProgress = true;
			view.getConfirmScheduleButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			String scheduleName = view.getScheduleNameBox().getText();
			
			boolean validScheduleName = true;
			
			try
			{
				checkEmptyString(scheduleName);
			}
			catch(EmptyStringException e)
			{
				validScheduleName = false;
			}

			
			if(validScheduleName)
			{
				createScheduleEventFire(facultyId, scheduleName, sectionIds);
			}
			else
			{
				parentPresenter.hideLoadScreen();
				view.getConfirmScheduleButton().setEnabled(true);
				scheduleCreationInProgress = false;
				
				//Might want to customize this so it tells you the specific field that was left empty.
				view.showErrorMessages("Schedule name cannot be left empty.");
			}
		}
		parentPresenter.hideLoadScreen();
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	private void createScheduleEventFire(Integer facultyId, String scheduleName, List<Integer> sectionIds) {
		CreateScheduleAction csa = new CreateScheduleAction(facultyId, scheduleName, sectionIds);
		CreateScheduleEvent cse = new CreateScheduleEvent(csa, parentPresenter.getView().getViewRootPanel());
		eventBus.fireEvent(cse);
	}
	
	//Navigate to this page
	//Displays schedule information
	@Override
	public void onConfirmSchedulePage(ConfirmSchedulePageEvent evt) {
		courses.clear();
		sectionIds.clear();
		facultyId = evt.getAction().getFacultyId();
		User user = evt.getAction().getUser();
		String faculty = "Faculty: " + user.getFirstName() + " " + user.getLastName() + "\n";
		List<Course> courses = evt.getAction().getCourses();
		String courseList = "Courses: ";
		List<String> presentableCourseNames = new ArrayList<String>();
		for(Course course : courses) {
			List<Section> sectionList = course.getSections();
			for(Section section : sectionList) {
				sectionIds.add(section.getId());
				Calendar calendar = section.getCalendar();
				String courseDetails = course.getCourseName() + " " + course.getCourseNumber() + " " + calendar.getSemester() + " " + section.getSectionName();
				presentableCourseNames.add(courseDetails);
			}
		}
		String informationString = faculty +  courseList + presentableCourseNames.toString();
		view.getCourseInformationBox().setText(informationString);
		this.go(parentPresenter.getView().getViewRootPanel());
	}
}
