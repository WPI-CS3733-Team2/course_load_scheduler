package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateModifyCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateModifyCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class CreateModifyCourseEvent extends GwtEvent<CreateModifyCourseEventHandler>
{
	public static Type<CreateModifyCourseEventHandler> TYPE = new Type<CreateModifyCourseEventHandler>();
	
	private CreateModifyCourseAction action;
	
	public CreateModifyCourseEvent(CreateModifyCourseAction action)
	{
		this.action = action;
	}
	
	public CreateModifyCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<CreateModifyCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(CreateModifyCourseEventHandler handler)
	{
		handler.onCreateModifyCourse(this);
	}
}
