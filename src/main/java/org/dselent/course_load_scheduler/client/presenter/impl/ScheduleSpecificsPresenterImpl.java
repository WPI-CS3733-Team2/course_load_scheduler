package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dselent.course_load_scheduler.client.action.ReceiveScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.action.ScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.event.ReceiveScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.event.ScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.utils.Pair;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ScheduleSpecificsPresenterImpl extends BasePresenterImpl implements ScheduleSpecificsPresenter
{
	private IndexPresenter parentPresenter;
	private ScheduleSpecificsView view;
	private Schedule schedule = new Schedule();
	private List<Pair<Calendar, String>> calendarCoursePairs = new ArrayList<Pair<Calendar, String>>();

	@Inject
	public ScheduleSpecificsPresenterImpl(IndexPresenter parentPresenter, ScheduleSpecificsView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
	}
	
	public void insertText(String scheduleName, String facultyName) {
		String presenterString = "Schedule Name: " + scheduleName + " Assigned Faculty: " + facultyName;
		view.getReport().setValue(presenterString);
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
		
		registration = eventBus.addHandler(ReceiveScheduleSpecificsEvent.TYPE, this);
		eventBusRegistration.put(ReceiveScheduleSpecificsEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public ScheduleSpecificsView getView()
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
				view.getCalendarGrid().setText(row, col, courseDetails);
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
		
		Map<String, Integer> tabMap = new HashMap<String,Integer>();
		tabMap.put("A", 0);
		tabMap.put("B", 1);
		tabMap.put("C", 2);
		tabMap.put("D", 3);
		tabMap.put("F", 4);
		tabMap.put("S", 5);
		
		for (Pair<Calendar, String> calStr : calendarCoursePairs) {
			Calendar cal = calStr.getValue1();
			String str = calStr.getValue2();
			if (tabMap.get(cal.getSemester()) == tabIndex) {
				fillCalendar(cal, str);
			}
		}
	}
	
	@Override
	public void onReceiveScheduleSpecifics(ReceiveScheduleSpecificsEvent evt)
	{
		calendarCoursePairs.clear();
		ReceiveScheduleSpecificsAction ssa = evt.getAction();
		User user = ssa.getUser();
		String facultyName = user.getFirstName() + " " + user.getLastName();
		schedule = ssa.getSchedule();
		List<Course> courseList = ssa.getModels();
		this.insertText(schedule.getScheduleName(), facultyName);
		GWT.log("HELLLLLLLLLLLLLLLLLLLLLLLLLLOOOOOOOOOOOOOOOOOOOOOOOOOO");
		for(Course course : courseList) {
			List<Section> sectionList = course.getSections();
			for(Section section : sectionList) {
				Calendar calendar = section.getCalendar();
				String courseDetails = course.getCourseName() + " " + calendar.getSemester() + " " + section.getSectionName();
				Pair<Calendar, String> calendarCourse = new Pair<Calendar, String>(calendar, courseDetails);
				calendarCoursePairs.add(calendarCourse);
				GWT.log("CALENDAR COURSE PAIR ADDED: " + calendarCourse.toString());
			}
		}
		GWT.log(calendarCoursePairs.toString());
		this.updateGrid();
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
}
