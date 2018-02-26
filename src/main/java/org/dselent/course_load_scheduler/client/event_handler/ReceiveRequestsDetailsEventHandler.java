package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveRequestsDetailsEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveRequestsDetailsEventHandler extends EventHandler
{
	public void onReceiveRequestsDetails(ReceiveRequestsDetailsEvent evt);
}
