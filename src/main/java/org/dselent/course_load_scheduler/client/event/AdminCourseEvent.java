package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
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
	
	private ViewCourseAction action;
	
	public AdminCourseEvent(ViewCourseAction action)
	{
		this.action = action;
	}
	
	public ViewCourseAction getAction()
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
