package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidChangePasswordEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class InvalidChangePasswordEvent extends GwtEvent<InvalidChangePasswordEventHandler>
{
	public static Type<InvalidChangePasswordEventHandler> TYPE = new Type<InvalidChangePasswordEventHandler>();
	
	private InvalidChangePasswordAction action;
	
	public InvalidChangePasswordEvent(InvalidChangePasswordAction action)
	{
		this.action = action;
	}
	
	public InvalidChangePasswordAction getAction() {
		return action;
	}

	@Override
	public Type<InvalidChangePasswordEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidChangePasswordEventHandler handler) {
		handler.onInvalidChangePassword(this);
		
	}
	
	
}
