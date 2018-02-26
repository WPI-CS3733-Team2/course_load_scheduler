package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendCreateRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendCreateRequestEventHandler extends EventHandler
{
	public void onSendCreateRequest(SendCreateRequestEvent evt);
}
