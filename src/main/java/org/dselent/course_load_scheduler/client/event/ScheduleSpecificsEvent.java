package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.event_handler.ScheduleSpecificsEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class ScheduleSpecificsEvent extends GwtEvent<ScheduleSpecificsEventHandler>
{
	public static Type<ScheduleSpecificsEventHandler> TYPE = new Type<ScheduleSpecificsEventHandler>();
	
	private ScheduleSpecificsAction action;
	
	public ScheduleSpecificsEvent(ScheduleSpecificsAction action)
	{
		this.action = action;
	}
	
	public ScheduleSpecificsAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ScheduleSpecificsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ScheduleSpecificsEventHandler handler)
	{
		handler.onScheduleSpecifics(this);
	}
}
