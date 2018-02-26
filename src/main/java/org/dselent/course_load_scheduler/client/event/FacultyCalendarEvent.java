package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewCalendarAction;
import org.dselent.course_load_scheduler.client.event_handler.FacultyCalendarEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class FacultyCalendarEvent extends DisplayEvent<ViewCalendarAction, FacultyCalendarEventHandler>
{
	public static Type<FacultyCalendarEventHandler> TYPE = new Type<FacultyCalendarEventHandler>();
	
	public FacultyCalendarEvent(ViewCalendarAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<FacultyCalendarEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(FacultyCalendarEventHandler handler)
	{
		handler.onFacultyCalendar(this);
	}
}
