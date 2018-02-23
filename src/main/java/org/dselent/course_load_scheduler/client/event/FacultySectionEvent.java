package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.FacultySectionEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class FacultySectionEvent extends DisplayEvent<ViewSectionAction, FacultySectionEventHandler>
{
	public static Type<FacultySectionEventHandler> TYPE = new Type<FacultySectionEventHandler>();
	
	public FacultySectionEvent(ViewSectionAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<FacultySectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(FacultySectionEventHandler handler)
	{
		handler.onFacultySection(this);
	}
}
