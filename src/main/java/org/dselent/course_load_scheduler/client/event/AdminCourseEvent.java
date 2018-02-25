package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.AdminCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AdminCourseEvent extends DisplayEvent<ViewCourseAction, AdminCourseEventHandler>
{
	public static Type<AdminCourseEventHandler> TYPE = new Type<AdminCourseEventHandler>();
	
	public AdminCourseEvent(ViewCourseAction action, HasWidgets container)
	{
		super(action, container);
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
