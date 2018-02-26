package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.GetCourseNumberAction;
import org.dselent.course_load_scheduler.client.event_handler.GetCourseNumberEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class GetCourseNumberEvent extends DisplayEvent<GetCourseNumberAction, GetCourseNumberEventHandler>
{
	public static Type<GetCourseNumberEventHandler> TYPE = new Type<GetCourseNumberEventHandler>();
	
	public GetCourseNumberEvent(GetCourseNumberAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<GetCourseNumberEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(GetCourseNumberEventHandler handler)
	{
		handler.onGetCourseNumber(this);
	}
}

