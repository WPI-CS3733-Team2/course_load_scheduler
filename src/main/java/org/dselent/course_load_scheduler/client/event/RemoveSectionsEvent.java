package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.RemoveSectionsAction;
import org.dselent.course_load_scheduler.client.event_handler.RemoveSectionsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class RemoveSectionsEvent extends DisplayEvent<RemoveSectionsAction, RemoveSectionsEventHandler>
{
	public static Type<RemoveSectionsEventHandler> TYPE = new Type<RemoveSectionsEventHandler>();
	
	public RemoveSectionsEvent(RemoveSectionsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<RemoveSectionsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(RemoveSectionsEventHandler handler)
	{
		handler.onRemoveSections(this);
	}
}

