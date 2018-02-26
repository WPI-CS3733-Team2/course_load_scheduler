package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveCreateRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveCreateRequestEventHandler extends EventHandler
{
	public void onReceiveCreateRequest(ReceiveCreateRequestEvent evt);
}
