package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCreateRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCreateRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendCreateRequestEvent extends DisplayEvent<SendCreateRequestAction, SendCreateRequestEventHandler>
{
	public static Type<SendCreateRequestEventHandler> TYPE = new Type<SendCreateRequestEventHandler>();

	public SendCreateRequestEvent(SendCreateRequestAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendCreateRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendCreateRequestEventHandler handler)
	{
		handler.onSendCreateRequest(this);
	}
}
