package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendChangeRequestStateEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendChangeRequestStateEventHandler extends EventHandler{
	public void onSendChangeRequestState(SendChangeRequestStateEvent evt);
}
