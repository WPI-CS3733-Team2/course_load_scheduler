package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UserCreatePageAction;
import org.dselent.course_load_scheduler.client.event_handler.UserCreatePageEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class UserCreatePageEvent extends GwtEvent<UserCreatePageEventHandler>{
public static Type<UserCreatePageEventHandler> TYPE = new Type<UserCreatePageEventHandler>();
	
	private UserCreatePageAction action;
	
	public UserCreatePageEvent(UserCreatePageAction action)
	{
		this.action = action;
	}
	
	public UserCreatePageAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<UserCreatePageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(UserCreatePageEventHandler handler)
	{
		handler.onUserCreatePage(this);
	}
}
