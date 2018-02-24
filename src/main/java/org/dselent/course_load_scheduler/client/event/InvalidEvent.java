package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InvalidEvent extends GwtEvent<InvalidEventHandler>{
	public static Type<InvalidEventHandler> TYPE = new Type<InvalidEventHandler>();
	
	private InvalidAction action;
	
	public InvalidEvent(InvalidAction action)
	{
		this.action = action;
	}
	
	/*public CreateUserEvent(CreateUserAction action, HasWidgets container)
	{
		super(action, container);
	}*/
	
	public InvalidAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<InvalidEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidEventHandler handler)
	{
		handler.onInvalid(this);
	}
}
