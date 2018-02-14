package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ScheduleSpecificsPresenterImpl extends BasePresenterImpl implements ScheduleSpecificsPresenter
{
	private IndexPresenter parentPresenter;
	private ScheduleSpecificsView view;

	@Inject
	public ScheduleSpecificsPresenterImpl(IndexPresenter parentPresenter, ScheduleSpecificsView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		this.insertText();
		this.insertDropDown();
		this.fillCalendar("MR", "6:00", "8:50", "Test Text");
	}
	
	public void insertText() {
		view.getReport().setValue("text box test text blah blah blah");
	}
	
	public void insertDropDown() {
		view.getNavDropDown().insertItem("View Schedule", 1);
		view.getNavDropDown().insertItem("Search Schedule", 2);
		view.getNavDropDown().insertItem("Create Schedule", 3);
		view.getNavDropDown().insertItem("Modify Schedule", 4);
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
		
		//registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		//eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
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
	
	public void fillCalendar(String days, String startTime, String endTime, String courseDetails) {
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
	
}
