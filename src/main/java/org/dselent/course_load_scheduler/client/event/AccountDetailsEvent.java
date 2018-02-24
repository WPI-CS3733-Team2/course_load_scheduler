package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UserDetailsPageAction;
import org.dselent.course_load_scheduler.client.event_handler.AccountDetailsEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AccountDetailsEvent extends DisplayEvent<UserDetailsPageAction, AccountDetailsEventHandler>
{
	public static Type<AccountDetailsEventHandler> TYPE = new Type<AccountDetailsEventHandler>();
	
	public AccountDetailsEvent(HasWidgets container)
	{
		super(null, container);
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
