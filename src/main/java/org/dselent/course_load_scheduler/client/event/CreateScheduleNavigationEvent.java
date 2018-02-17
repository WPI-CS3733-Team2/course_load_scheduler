package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleNavigationEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class CreateScheduleNavigationEvent extends GwtEvent<CreateScheduleNavigationEventHandler>{
	public static Type<CreateScheduleNavigationEventHandler> TYPE = new Type<CreateScheduleNavigationEventHandler>();
	
	private CreateScheduleNavigationAction action;
	
	public CreateScheduleNavigationEvent(CreateScheduleNavigationAction action)
	{
		this.action = action;
	}
	
	public CreateScheduleNavigationAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<CreateScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(CreateScheduleNavigationEventHandler handler)
	{
		handler.onCreateScheduleNavigation(this);
	}
}
