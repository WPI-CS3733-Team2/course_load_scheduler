package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dselent.course_load_scheduler.client.action.ScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.event.ScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ScheduleSpecificsPresenterImpl extends BasePresenterImpl implements ScheduleSpecificsPresenter
{
	private IndexPresenter parentPresenter;
	private ScheduleSpecificsView view;
	private Schedule schedule = new Schedule();
	private List<Calendar> calendars = new ArrayList<Calendar>();

	@Inject
	public ScheduleSpecificsPresenterImpl(IndexPresenter parentPresenter, ScheduleSpecificsView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		this.insertText();
		Calendar calendar1 = new Calendar();
		calendar1.setId(1);
		calendar1.setYear(2018);
		calendar1.setSemester("A");
		calendar1.setDays("MR");
		calendar1.setStart_time("9:00");
		calendar1.setEnd_time("10:50");
		calendars.add(calendar1);
		
		Calendar calendar2 = new Calendar();
		calendar2.setId(1);
		calendar2.setYear(2018);
		calendar2.setSemester("C");
		calendar2.setDays("WTF");
		calendar2.setStart_time("9:00");
		calendar2.setEnd_time("10:50");
		calendars.add(calendar2);
		
		Calendar calendar3 = new Calendar();
		calendar3.setId(1);
		calendar3.setYear(2018);
		calendar3.setSemester("B");
		calendar3.setDays("R");
		calendar3.setStart_time("9:00");
		calendar3.setEnd_time("10:50");
		calendars.add(calendar3);
	
	}
	
	public void insertText() {
		view.getReport().setValue("Schedule Name : *from database* \r\n \r\n Courses: *from database* \r\n \r\n Assigned Faculty: *from database*");
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
		
		registration = eventBus.addHandler(ScheduleSpecificsEvent.TYPE, this);
		eventBusRegistration.put(ScheduleSpecificsEvent.TYPE, registration);
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
	
	@Override
	public void onScheduleSpecifics(ScheduleSpecificsEvent evt)
	{
		ScheduleSpecificsAction ssa = evt.getAction();
		schedule = ssa.getSchedule();
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
}
