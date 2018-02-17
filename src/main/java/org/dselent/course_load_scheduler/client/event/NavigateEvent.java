package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.event_handler.NavigateEventHandler;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.NavigateAction;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class NavigateEvent extends GwtEvent<NavigateEventHandler>{
	
	public static Type<NavigateEventHandler> TYPE = new Type<NavigateEventHandler>();
	
	private NavigateAction action;
	
	public NavigateEvent(NavigateAction action)
	{
		this.action = action;
	}
	
	public NavigateAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<NavigateEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(NavigateEventHandler handler)
	{
		handler.onNavigate(this);
	}
}
