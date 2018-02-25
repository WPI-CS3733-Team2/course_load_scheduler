package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveTerminatedAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveTerminatedAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ReceiveTerminatedAccountEvent extends GwtEvent<ReceiveTerminatedAccountEventHandler>{
	public static Type<ReceiveTerminatedAccountEventHandler> TYPE = new Type<ReceiveTerminatedAccountEventHandler>();
	
	private ReceiveTerminatedAccountAction action;
	
	/*public ReceiveCreatedUserEvent(ReceiveCreatedUserAction action, HasWidgets container)
	{
		super(action, container);
	}*/
	
	public ReceiveTerminatedAccountEvent(ReceiveTerminatedAccountAction action)
	{
		this.action = action;
	}
	
	public ReceiveTerminatedAccountAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<ReceiveTerminatedAccountEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveTerminatedAccountEventHandler handler)
	{
		handler.onReceiveTerminatedAccount(this);
	}
}
