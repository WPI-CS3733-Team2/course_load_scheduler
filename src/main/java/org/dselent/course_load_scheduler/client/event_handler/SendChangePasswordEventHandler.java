package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendChangePasswordEventHandler extends EventHandler{
	public void onSendChangePassword(SendChangePasswordEvent evt);
}
