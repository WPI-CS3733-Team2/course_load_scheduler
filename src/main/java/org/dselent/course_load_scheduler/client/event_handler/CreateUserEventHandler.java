package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateUserEventHandler extends EventHandler{
	public void onCreateUser(CreateUserEvent evt);
}
