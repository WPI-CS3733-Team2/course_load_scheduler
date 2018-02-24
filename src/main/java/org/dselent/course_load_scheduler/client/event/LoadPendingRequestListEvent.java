package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.LoadPendingRequestListAction;
import org.dselent.course_load_scheduler.client.event_handler.LoadPendingRequestListEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HasWidgets;

public class LoadPendingRequestListEvent extends DisplayEvent<LoadPendingRequestListAction, LoadPendingRequestListEventHandler>
{
	public static Type<LoadPendingRequestListEventHandler> TYPE = new Type<LoadPendingRequestListEventHandler>();
	
	public LoadPendingRequestListEvent(LoadPendingRequestListAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<LoadPendingRequestListEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LoadPendingRequestListEventHandler handler) {
		handler.onLoadPendingRequestList(this);
		
	}
}
