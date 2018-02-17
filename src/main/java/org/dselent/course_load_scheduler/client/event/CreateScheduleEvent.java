package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class CreateScheduleEvent extends GwtEvent<CreateScheduleEventHandler>{
	public static Type<CreateScheduleEventHandler> TYPE = new Type<CreateScheduleEventHandler>();
	
	private CreateScheduleAction action;
	
	public CreateScheduleEvent(CreateScheduleAction action)
	{
		this.action = action;
	}
	
	public CreateScheduleAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<CreateScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(CreateScheduleEventHandler handler)
	{
		handler.onCreateSchedule(this);
	}
}
