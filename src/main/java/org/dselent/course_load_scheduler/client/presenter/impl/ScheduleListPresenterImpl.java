package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleListView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ScheduleListPresenterImpl extends BasePresenterImpl implements ScheduleListPresenter
{
	private IndexPresenter parentPresenter;
	private ScheduleListView view;

	@Inject
	public ScheduleListPresenterImpl(IndexPresenter parentPresenter, ScheduleListView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		this.insertDropDown();
		Schedule schedule = new Schedule();
		schedule.setId(1);
		schedule.setFacultyId(1);
		schedule.setScheduleName("Schedule Test");
		List<Schedule> schedules = Arrays.asList(schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule, schedule);
		
		this.fillTable(schedules);
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
	public ScheduleListView getView()
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
	
	public void fillTable(List<Schedule> schedules) {
		view.getScheduleTable().setRowData(schedules);
	}
	
}
