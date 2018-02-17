package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidRequestCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidSubmitRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class InvalidSubmitRequestEvent extends GwtEvent<InvalidSubmitRequestEventHandler>
{
	public static Type<InvalidSubmitRequestEventHandler> TYPE = new Type<InvalidSubmitRequestEventHandler>();
	
	private InvalidRequestCourseAction action;
	
	public InvalidSubmitRequestEvent(InvalidRequestCourseAction action)
	{
		this.action = action;
	}
	
	public InvalidRequestCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidSubmitRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidSubmitRequestEventHandler handler)
	{
		handler.onInvalidSubmitRequest(this);
	}
}
