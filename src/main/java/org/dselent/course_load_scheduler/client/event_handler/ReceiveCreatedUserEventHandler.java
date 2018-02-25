package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveCreatedUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveCreatedUserEventHandler extends EventHandler{
	public void onReceiveCreatedUser(ReceiveCreatedUserEvent evt);
}
