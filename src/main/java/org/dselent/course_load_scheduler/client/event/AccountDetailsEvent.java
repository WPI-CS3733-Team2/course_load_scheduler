package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UserDetailsPageAction;
import org.dselent.course_load_scheduler.client.event_handler.AccountDetailsEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AccountDetailsEvent extends GwtEvent<AccountDetailsEventHandler>
{
	public static Type<AccountDetailsEventHandler> TYPE = new Type<AccountDetailsEventHandler>();
	
	private UserDetailsPageAction action;
	
	public AccountDetailsEvent(UserDetailsPageAction action)
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
	public Type<AccountDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(AccountDetailsEventHandler handler)
	{
		handler.onAccountDetails(this);
	}
}
