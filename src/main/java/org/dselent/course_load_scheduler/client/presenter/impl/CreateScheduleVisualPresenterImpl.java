package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dselent.course_load_scheduler.client.action.ConfirmSchedulePageAction;
import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectFacultyAction;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleVisualPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleVisualView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class CreateScheduleVisualPresenterImpl extends BasePresenterImpl implements CreateScheduleVisualPresenter
{ 
	private IndexPresenter parentPresenter;
	private CreateScheduleVisualView view;
	private List<Calendar> calendars = new ArrayList<Calendar>();
	private List<Course> courses;

	@Inject
	public CreateScheduleVisualPresenterImpl(IndexPresenter parentPresenter, CreateScheduleVisualView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		
		Calendar calendar1 = new Calendar();
		calendar1.setId(1);
		calendar1.setYear(2018);
		calendar1.setSemester("A");
		calendar1.setDays("MR");
		calendar1.setStart_time("9:00");
		calendar1.setEnd_time("10:50");
		calendars.add(calendar1);
		this.fillCalendar(calendar1, "Some Course You're Assigned");
		
		Calendar calendar2 = new Calendar();
		calendar2.setId(1);
		calendar2.setYear(2018);
		calendar2.setSemester("B");
		calendar2.setDays("WTF");
		calendar2.setStart_time("9:00");
		calendar2.setEnd_time("10:50");
		calendars.add(calendar2);
		
		Calendar calendar3 = new Calendar();
		calendar3.setId(1);
		calendar3.setYear(2018);
		calendar3.setSemester("C");
		calendar3.setDays("R");
		calendar3.setStart_time("9:00");
		calendar3.setEnd_time("10:50");
		calendars.add(calendar3);
	
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
		
		registration = eventBus.addHandler(CreateScheduleSelectCoursesEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleSelectCoursesEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public CreateScheduleVisualView getView()
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
	
	public void fillCalendar(Calendar calendar, String courseDetails) {
		view.clearGrid();
		
		String startTime = calendar.getStart_time();
		String endTime = calendar.getEnd_time();
		String days = calendar.getDays();
		
		int endRow = 1;

		Map<String, Integer> startMap = new HashMap<String,Integer>();
		startMap.put("8:00", 1);
		startMap.put("9:00", 2);
		startMap.put("10:00", 3);
		startMap.put("11:00", 4);
		startMap.put("12:00", 5);
		startMap.put("1:00", 6);
		startMap.put("2:00", 7);
		startMap.put("3:00", 8);
		startMap.put("4:00", 9);
		startMap.put("5:00", 10);
		startMap.put("6:00", 11);
		
		Map<String, Integer> tabMap = new HashMap<String,Integer>();
		tabMap.put("A", 0);
		tabMap.put("B", 1);
		tabMap.put("C", 2);
		tabMap.put("D", 3);
		tabMap.put("F", 4);
		tabMap.put("S", 5);
		
		if (endTime.contains("8:")) {
			if(startTime.contentEquals("8:00")) {
				endRow = 1;
			}
			if(startTime.contentEquals("6:00")) {
				endRow = 13;
			}
		}
		if (endTime.contains("9:")) {
			endRow = 2;
		}
		if (endTime.contains("10:")) {
			endRow = 3;
		}
		if (endTime.contains("11:")) {
			endRow = 4;
		}
		if (endTime.contains("12:")) {
			endRow = 5;
		}
		if (endTime.startsWith("1:")) {
			endRow = 6;
		}
		if (endTime.startsWith("2:")) {
			endRow = 7;
		}
		if (endTime.contains("3:")) {
			endRow = 8;
		}
		if (endTime.contains("4:")) {
			endRow = 9;
		}
		if (endTime.contains("5:")) {
			endRow = 10;
		}
		if (endTime.contains("6:")) {
			endRow = 11;
		}
		if (endTime.contains("7:")) {
			endRow = 12;
		}
		
		for (int col: daysToCols(days))
			for (int row = Integer.parseInt(startMap.get(startTime).toString()); row <= endRow; row++)
				view.getScheduleGrid().setText(row, col, courseDetails);
	}
	
	public List<Integer> daysToCols(String days) {
		List<Integer> columns = new ArrayList<Integer>();
		
		if (days.contains("M")) {
			columns.add(1);
		}
		if (days.contains("T")) {
			columns.add(2);
		}
		if (days.contains("W")) {
			columns.add(3);
		}
		if (days.contains("R")) {
			columns.add(4);
		}
		if (days.contains("F")) {
			columns.add(5);
		}
		return columns;
	}
	
	@Override
	public void updateGrid() {
		view.clearGrid();
		
		int tabIndex = view.getCalendarTabs().getSelectedTab();
		List<Calendar> thisSemester = new ArrayList<Calendar>();
		
		Map<String, Integer> tabMap = new HashMap<String,Integer>();
		tabMap.put("A", 0);
		tabMap.put("B", 1);
		tabMap.put("C", 2);
		tabMap.put("D", 3);
		tabMap.put("F", 4);
		tabMap.put("S", 5);
		
		for (Calendar cal : calendars) {
			if (tabMap.get(cal.getSemester()) == tabIndex) {
				thisSemester.add(cal);
			}
		}
		for (Calendar cal : thisSemester) {
			fillCalendar(cal, "This will be filled from the database");
		}
	}
	
	public void fireCreateScheduleSelectFaculty() {
		CreateScheduleSelectFacultyAction cssfa = new CreateScheduleSelectFacultyAction(courses);
		CreateScheduleSelectFacultyEvent cssfe = new CreateScheduleSelectFacultyEvent(cssfa);
		eventBus.fireEvent(cssfe);
	}
	
	@Override
	public void onCreateScheduleSelectCourses(CreateScheduleSelectCoursesEvent evt) {
		//List<Course> courseList = evt.getAction().getCourses();
		courses = evt.getAction().getCourses();
		//will get calendars from sections from courses
		this.go(parentPresenter.getView().getViewRootPanel());
	}
}
