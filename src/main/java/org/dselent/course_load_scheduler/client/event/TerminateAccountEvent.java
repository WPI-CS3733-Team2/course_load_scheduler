package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.action.TerminateAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateUserEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendLoginEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.TerminateAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HasWidgets;

public class TerminateAccountEvent extends GwtEvent<TerminateAccountEventHandler>{
	
public static Type<TerminateAccountEventHandler> TYPE = new Type<TerminateAccountEventHandler>();
	
	private TerminateAccountAction action;
	
	public TerminateAccountEvent(TerminateAccountAction action)
	{
		this.action = action;
		//super(action,container);
	}
	
	public TerminateAccountAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<TerminateAccountEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(TerminateAccountEventHandler handler)
	{
		handler.onTerminateAccount(this);
	}
	
}
