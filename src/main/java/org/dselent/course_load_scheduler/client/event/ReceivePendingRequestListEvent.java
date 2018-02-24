package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceivePendingRequestListAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceivePendingRequestListEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceivePendingRequestListEvent extends DisplayEvent<ReceivePendingRequestListAction, ReceivePendingRequestListEventHandler>{
	
	public static Type<ReceivePendingRequestListEventHandler> TYPE = new Type<ReceivePendingRequestListEventHandler>();
	
	public ReceivePendingRequestListEvent(ReceivePendingRequestListAction action, HasWidgets container) {
		super(action, container);
	}

	@Override
	public Type<ReceivePendingRequestListEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReceivePendingRequestListEventHandler handler)
	{
		handler.onReceivePendingRequestList(this);
	}
}
