package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateUserEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class CreateUserEvent extends GwtEvent<CreateUserEventHandler>{
	public static Type<CreateUserEventHandler> TYPE = new Type<CreateUserEventHandler>();
	
	private CreateUserAction action;
	
	public CreateUserEvent(CreateUserAction action)
	{
		this.action = action;
	}
	
	public CreateUserAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<CreateUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(CreateUserEventHandler handler)
	{
		handler.onCreateUser(this);
	}
}
