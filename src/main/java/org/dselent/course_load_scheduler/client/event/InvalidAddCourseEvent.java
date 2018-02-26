package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidAddCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidAddCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class InvalidAddCourseEvent extends GwtEvent<InvalidAddCourseEventHandler>
{
	public static Type<InvalidAddCourseEventHandler> TYPE = new Type<InvalidAddCourseEventHandler>();
	
	private InvalidAddCourseAction action;
	
	public InvalidAddCourseEvent(InvalidAddCourseAction action)
	{
		this.action = action;
	}
	
	public InvalidAddCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidAddCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidAddCourseEventHandler handler)
	{
		handler.onInvalidAddCourse(this);
	}
}
