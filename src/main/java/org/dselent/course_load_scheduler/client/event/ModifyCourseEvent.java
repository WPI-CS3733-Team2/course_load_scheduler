package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.ModifyCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class ModifyCourseEvent extends DisplayEvent<ModifyCourseAction, ModifyCourseEventHandler>
{
	public static Type<ModifyCourseEventHandler> TYPE = new Type<ModifyCourseEventHandler>();
	
	public ModifyCourseEvent(ModifyCourseAction action, HasWidgets container)
	{
		super(action, container);
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

