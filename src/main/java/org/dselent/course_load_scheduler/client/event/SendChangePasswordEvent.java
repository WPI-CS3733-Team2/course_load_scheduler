package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.event_handler.SendChangePasswordEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class SendChangePasswordEvent extends GwtEvent<SendChangePasswordEventHandler>
{
	public static Type<SendChangePasswordEventHandler> TYPE = new Type<SendChangePasswordEventHandler>();
	
	private SendChangePasswordAction action;
	
	public SendChangePasswordEvent(SendChangePasswordAction action) {
		this.action = action;
	}
	
	public SendChangePasswordAction getAction() {
		return action;
	}

	@Override
	public Type<SendChangePasswordEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SendChangePasswordEventHandler handler) {
		handler.onSendChangePassword(this);
	}

}
