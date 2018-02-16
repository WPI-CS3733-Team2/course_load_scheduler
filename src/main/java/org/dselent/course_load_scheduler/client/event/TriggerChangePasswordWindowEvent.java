package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.TriggerChangePasswordWindowAction;
import org.dselent.course_load_scheduler.client.event_handler.TriggerChangePasswordWindowEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TriggerChangePasswordWindowEvent extends GwtEvent<TriggerChangePasswordWindowEventHandler>{
	
	public static Type<TriggerChangePasswordWindowEventHandler> TYPE = new Type<TriggerChangePasswordWindowEventHandler>();
	
	private TriggerChangePasswordWindowAction action;
	
	public TriggerChangePasswordWindowEvent(TriggerChangePasswordWindowAction action)
	{
		this.action = action;
	}

	public TriggerChangePasswordWindowAction getAction() {
		return action;
	}
	
	@Override
	public Type<TriggerChangePasswordWindowEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TriggerChangePasswordWindowEventHandler handler) {
		handler.onTriggerChangePasswordWindow(this);
	}

}
