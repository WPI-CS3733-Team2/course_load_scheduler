package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewCalendarAction;
import org.dselent.course_load_scheduler.client.event_handler.AdminCalendarEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AdminCalendarEvent extends DisplayEvent<ViewCalendarAction, AdminCalendarEventHandler>
{
	public static Type<AdminCalendarEventHandler> TYPE = new Type<AdminCalendarEventHandler>();
	
	public AdminCalendarEvent(ViewCalendarAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<AdminCalendarEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(AdminCalendarEventHandler handler)
	{
		handler.onAdminCalendar(this);
	}
}
