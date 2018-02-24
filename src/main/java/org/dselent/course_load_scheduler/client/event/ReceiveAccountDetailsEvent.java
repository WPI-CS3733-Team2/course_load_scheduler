package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveAccountDetailsEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveAccountDetailsEvent extends DisplayEvent<ReceiveAccountDetailsAction, ReceiveAccountDetailsEventHandler>
{
	public static Type<ReceiveAccountDetailsEventHandler> TYPE = new Type<ReceiveAccountDetailsEventHandler>();
	
	public ReceiveAccountDetailsEvent(ReceiveAccountDetailsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ReceiveAccountDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ReceiveAccountDetailsEventHandler handler)
	{
		handler.onReceiveAccountDetails(this);
	}
}
