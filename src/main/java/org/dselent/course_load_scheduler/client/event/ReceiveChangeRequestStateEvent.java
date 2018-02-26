package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveChangeRequestStateEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveChangeRequestStateEvent extends DisplayEvent<ReceiveChangeRequestStateAction, ReceiveChangeRequestStateEventHandler>
{
	public static Type<ReceiveChangeRequestStateEventHandler> TYPE = new Type<ReceiveChangeRequestStateEventHandler>();
	
	public ReceiveChangeRequestStateEvent(ReceiveChangeRequestStateAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveChangeRequestStateEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveChangeRequestStateEventHandler handler)
	{
		handler.onReceiveChangeRequestState(this);
	}
}
