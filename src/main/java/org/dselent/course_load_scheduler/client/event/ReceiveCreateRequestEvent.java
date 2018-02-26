package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCreateRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveCreateRequestEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveCreateRequestEvent extends DisplayEvent<ReceiveCreateRequestAction, ReceiveCreateRequestEventHandler>{

	public static Type<ReceiveCreateRequestEventHandler> TYPE = new Type<ReceiveCreateRequestEventHandler>();

	
	public ReceiveCreateRequestEvent(ReceiveCreateRequestAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<ReceiveCreateRequestEventHandler> getAssociatedType() 
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveCreateRequestEventHandler handler) 
	{
		handler.onReceiveCreateRequest(this);
		
	}

}
