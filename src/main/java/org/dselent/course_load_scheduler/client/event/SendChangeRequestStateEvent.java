package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.event_handler.SendChangeRequestStateEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendChangeRequestStateEvent extends DisplayEvent<SendChangeRequestStateAction, SendChangeRequestStateEventHandler>
{
	public static Type<SendChangeRequestStateEventHandler> TYPE = new Type<SendChangeRequestStateEventHandler>();
	
	public SendChangeRequestStateEvent(SendChangeRequestStateAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendChangeRequestStateEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendChangeRequestStateEventHandler handler)
	{
		handler.onSendChangeRequestState(this);
	}
}
