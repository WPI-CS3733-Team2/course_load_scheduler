package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.ScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleEvent;
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
	private List<Schedule> schedulesList = new ArrayList();

	@Inject
	public ScheduleListPresenterImpl(IndexPresenter parentPresenter, ScheduleListView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);

	}

	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public List<Schedule> getSchedules(){
		return schedulesList;
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(SearchScheduleEvent.TYPE, this);
		eventBusRegistration.put(SearchScheduleEvent.TYPE, registration);

		registration = eventBus.addHandler(CreateScheduleEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveViewScheduleNavigationEvent.TYPE, this);
		eventBusRegistration.put(ReceiveViewScheduleNavigationEvent.TYPE, registration);
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
	
	public void viewSpecifics(Schedule schedule) {
		ScheduleSpecificsAction ssa = new ScheduleSpecificsAction(schedule);
		ScheduleSpecificsEvent sse = new ScheduleSpecificsEvent(ssa);
		eventBus.fireEvent(sse);
	}
	
	@Override
	public void onSearchSchedule(SearchScheduleEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
	@Override
	public void onCreateSchedule(CreateScheduleEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
	@Override
	public void onReceiveViewScheduleNavigation(ReceiveViewScheduleNavigationEvent evt) {
		schedulesList = evt.getAction().getModels();
		this.fillTable(schedulesList);
		this.go(parentPresenter.getView().getViewRootPanel());
	}
}
