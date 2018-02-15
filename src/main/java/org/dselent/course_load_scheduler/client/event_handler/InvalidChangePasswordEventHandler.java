package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidChangePasswordEventHandler extends EventHandler{

	public void onInvalidChangePassword(InvalidChangePasswordEvent evt);

}
