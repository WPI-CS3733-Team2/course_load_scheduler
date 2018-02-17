package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.RequestCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.RequestCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class RequestCourseEvent extends GwtEvent<RequestCourseEventHandler>
{
	public static Type<RequestCourseEventHandler> TYPE = new Type<RequestCourseEventHandler>();
	
	private RequestCourseAction action;
	
	public RequestCourseEvent(RequestCourseAction action)
	{
		this.action = action;
	}
	
	public RequestCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<RequestCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(RequestCourseEventHandler handler)
	{
		handler.onRequestCourse(this);
	}
}
