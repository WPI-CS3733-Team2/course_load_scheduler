package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class CreateScheduleEvent extends DisplayEvent<CreateScheduleAction, CreateScheduleEventHandler>{
	public static Type<CreateScheduleEventHandler> TYPE = new Type<CreateScheduleEventHandler>();
	
	private CreateScheduleAction action;
	
	public CreateScheduleEvent(CreateScheduleAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<CreateScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(CreateScheduleEventHandler handler)
	{
		handler.onCreateSchedule(this);
	}
}
