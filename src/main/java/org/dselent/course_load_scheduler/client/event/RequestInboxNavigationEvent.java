package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.RequestInboxNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.RequestInboxNavigationEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class RequestInboxNavigationEvent extends GwtEvent<RequestInboxNavigationEventHandler>{
	public static Type<RequestInboxNavigationEventHandler> TYPE = new Type<RequestInboxNavigationEventHandler>();
	
	private RequestInboxNavigationAction action;
	
	public RequestInboxNavigationEvent(RequestInboxNavigationAction action)
	{
		this.action = action;
	}
	
	public RequestInboxNavigationAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<RequestInboxNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(RequestInboxNavigationEventHandler handler)
	{
		handler.onRequestInboxNavigation(this);
	}
}
