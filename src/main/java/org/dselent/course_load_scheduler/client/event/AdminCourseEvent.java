package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.AdminCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.AdminCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AdminCourseEvent extends GwtEvent<AdminCourseEventHandler>
{
	public static Type<AdminCourseEventHandler> TYPE = new Type<AdminCourseEventHandler>();
	
	private AdminCourseAction action;
	
	public AdminCourseEvent(AdminCourseAction action)
	{
		this.action = action;
	}
	
	public AdminCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<AdminCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(AdminCourseEventHandler handler)
	{
		handler.onAdminCourse(this);
	}
}
