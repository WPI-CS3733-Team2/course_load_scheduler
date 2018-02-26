package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCourseNumberAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveCourseNumberEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class ReceiveCourseNumberEvent extends DisplayEvent<ReceiveCourseNumberAction, ReceiveCourseNumberEventHandler>
{
	public static Type<ReceiveCourseNumberEventHandler> TYPE = new Type<ReceiveCourseNumberEventHandler>();
	
	public ReceiveCourseNumberEvent(ReceiveCourseNumberAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ReceiveCourseNumberEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ReceiveCourseNumberEventHandler handler)
	{
		handler.onReceiveCourseNumber(this);
	}
}

