package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.FacultyCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class FacultyCourseEvent extends DisplayEvent<ViewCourseAction, FacultyCourseEventHandler>
{
	public static Type<FacultyCourseEventHandler> TYPE = new Type<FacultyCourseEventHandler>();
	
	public FacultyCourseEvent(ViewCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<FacultyCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(FacultyCourseEventHandler handler)
	{
		handler.onFacultyCourse(this);
	}
}
