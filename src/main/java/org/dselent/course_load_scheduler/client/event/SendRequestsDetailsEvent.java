package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestsDetailsEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendRequestsDetailsEvent extends DisplayEvent<SendRequestsDetailsAction, SendRequestsDetailsEventHandler>
{
	public static Type<SendRequestsDetailsEventHandler> TYPE = new Type<SendRequestsDetailsEventHandler>();

	public SendRequestsDetailsEvent(SendRequestsDetailsAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendRequestsDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRequestsDetailsEventHandler handler)
	{
		handler.onSendRequestsDetails(this);
	}
}
