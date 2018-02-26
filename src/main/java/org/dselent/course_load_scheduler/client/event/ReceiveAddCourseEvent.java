package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveAddCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveAddCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class ReceiveAddCourseEvent extends DisplayEvent<ReceiveAddCourseAction, ReceiveAddCourseEventHandler>
{
	public static Type<ReceiveAddCourseEventHandler> TYPE = new Type<ReceiveAddCourseEventHandler>();
	
	public ReceiveAddCourseEvent(ReceiveAddCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ReceiveAddCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ReceiveAddCourseEventHandler handler)
	{
		handler.onReceiveAddCourse(this);
	}
}

