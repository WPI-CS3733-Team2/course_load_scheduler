package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidAddModifyCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidSubmitCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class InvalidSubmitCourseEvent extends GwtEvent<InvalidSubmitCourseEventHandler>
{
	public static Type<InvalidSubmitCourseEventHandler> TYPE = new Type<InvalidSubmitCourseEventHandler>();
	
	private InvalidAddModifyCourseAction action;
	
	public InvalidSubmitCourseEvent(InvalidAddModifyCourseAction action)
	{
		this.action = action;
	}
	
	public InvalidAddModifyCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidSubmitCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidSubmitCourseEventHandler handler)
	{
		handler.onInvalidSubmitCourse(this);
	}
}
