package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveRequestsDetailsEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveRequestsDetailsEvent extends DisplayEvent<ReceiveRequestsDetailsAction, ReceiveRequestsDetailsEventHandler>
{
	public static Type<ReceiveRequestsDetailsEventHandler> TYPE = new Type<ReceiveRequestsDetailsEventHandler>();
	
	public ReceiveRequestsDetailsEvent(ReceiveRequestsDetailsAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<ReceiveRequestsDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveRequestsDetailsEventHandler handler)
	{
		handler.onReceiveRequestsDetails(this);
	}
}
