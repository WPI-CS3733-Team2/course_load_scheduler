package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UserSearchPageAction;
import org.dselent.course_load_scheduler.client.event_handler.UserSearchPageEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class UserSearchPageEvent extends GwtEvent<UserSearchPageEventHandler>{
	
	public static Type<UserSearchPageEventHandler> TYPE = new Type<UserSearchPageEventHandler>();
	
	private UserSearchPageAction action;
	
	public UserSearchPageEvent(UserSearchPageAction action)
	{
		this.action = action;
	}
	
	public UserSearchPageAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<UserSearchPageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(UserSearchPageEventHandler handler)
	{
		handler.onUserSearchPage(this);
	}
	
}
