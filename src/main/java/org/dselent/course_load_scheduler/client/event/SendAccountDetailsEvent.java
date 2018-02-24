package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAccountDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAccountDetailsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;


public class SendAccountDetailsEvent extends DisplayEvent<SendAccountDetailsAction, SendAccountDetailsEventHandler>
{
	public static Type<SendAccountDetailsEventHandler> TYPE = new Type<SendAccountDetailsEventHandler>();
	
	public SendAccountDetailsEvent(SendAccountDetailsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendAccountDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendAccountDetailsEventHandler handler)
	{
		handler.onSendAccountDetails(this);
	}
}
