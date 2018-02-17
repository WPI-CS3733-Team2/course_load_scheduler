package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UserDetailsPageAction;
import org.dselent.course_load_scheduler.client.event_handler.UserDetailsPageEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class UserDetailsPageEvent extends GwtEvent<UserDetailsPageEventHandler>{
	
	public static Type<UserDetailsPageEventHandler> TYPE = new Type<UserDetailsPageEventHandler>();
	
	private UserDetailsPageAction action;
	
	public UserDetailsPageEvent(UserDetailsPageAction action)
	{
		this.action = action;
	}
	
	public UserDetailsPageAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<UserDetailsPageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(UserDetailsPageEventHandler handler)
	{
		handler.onUserDetailsPage(this);
	}
}
