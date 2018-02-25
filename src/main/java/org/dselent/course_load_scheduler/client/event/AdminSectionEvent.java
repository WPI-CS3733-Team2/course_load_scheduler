package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.AdminSectionEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AdminSectionEvent extends DisplayEvent<ViewSectionAction, AdminSectionEventHandler>
{
	public static Type<AdminSectionEventHandler> TYPE = new Type<AdminSectionEventHandler>();
	
	public AdminSectionEvent(ViewSectionAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<AdminSectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(AdminSectionEventHandler handler)
	{
		handler.onAdminSection(this);
	}
}
