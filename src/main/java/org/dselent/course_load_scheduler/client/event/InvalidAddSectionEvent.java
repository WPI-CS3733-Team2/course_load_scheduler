package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidAddModifyCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidAddSectionEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class InvalidAddSectionEvent extends GwtEvent<InvalidAddSectionEventHandler>
{
	public static Type<InvalidAddSectionEventHandler> TYPE = new Type<InvalidAddSectionEventHandler>();
	
	private InvalidAddModifyCourseAction action;
	
	public InvalidAddSectionEvent(InvalidAddModifyCourseAction action)
	{
		this.action = action;
	}
	
	public InvalidAddModifyCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidAddSectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidAddSectionEventHandler handler)
	{
		handler.onInvalidAddSection(this);
	}
}
