package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectFacultyAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSelectFacultyEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSelectFacultyEvent extends DisplayEvent<ReceiveSelectFacultyAction, ReceiveSelectFacultyEventHandler>
{
	public static Type<ReceiveSelectFacultyEventHandler> TYPE = new Type<ReceiveSelectFacultyEventHandler>();
	
	public ReceiveSelectFacultyEvent(ReceiveSelectFacultyAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveSelectFacultyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveSelectFacultyEventHandler handler)
	{
		handler.onReceiveSelectFaculty(this);
	}
}