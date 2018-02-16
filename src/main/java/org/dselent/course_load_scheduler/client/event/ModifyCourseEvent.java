package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.ModifyCourseEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.ModifyCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class ModifyCourseEvent extends GwtEvent<ModifyCourseEventHandler>
{
	public static Type<ModifyCourseEventHandler> TYPE = new Type<ModifyCourseEventHandler>();
	
	private ModifyCourseAction action;
	
	public ModifyCourseEvent(ModifyCourseAction action)
	{
		this.action = action;
	}
	
	public ModifyCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ModifyCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ModifyCourseEventHandler handler)
	{
		handler.onModifyCourse(this);
	}
}
