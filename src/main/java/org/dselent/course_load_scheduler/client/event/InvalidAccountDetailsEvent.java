package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidAccountDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidAccountDetailsEventHandler;


public class InvalidAccountDetailsEvent extends BaseEvent<InvalidAccountDetailsAction, InvalidAccountDetailsEventHandler>
{
	public static Type<InvalidAccountDetailsEventHandler> TYPE = new Type<InvalidAccountDetailsEventHandler>();
	
	public InvalidAccountDetailsEvent(InvalidAccountDetailsAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidAccountDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidAccountDetailsEventHandler handler)
	{
		handler.onInvalidAccountDetails(this);
	}
}
