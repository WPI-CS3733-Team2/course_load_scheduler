package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendRequestsDetailsEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRequestsDetailsEventHandler extends EventHandler
{
	public void onSendRequestsDetails(SendRequestsDetailsEvent evt);
}
