package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.AddCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AddCourseEvent extends DisplayEvent<AddCourseAction, AddCourseEventHandler>
{
	public static Type<AddCourseEventHandler> TYPE = new Type<AddCourseEventHandler>();
	
	public AddCourseEvent(AddCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<AddCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(AddCourseEventHandler handler)
	{
		handler.onAddCourse(this);
	}
}

