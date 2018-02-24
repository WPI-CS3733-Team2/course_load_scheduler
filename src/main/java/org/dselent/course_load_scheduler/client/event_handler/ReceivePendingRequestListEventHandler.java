package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceivePendingRequestListEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceivePendingRequestListEventHandler extends EventHandler
{
	public void onReceivePendingRequestList(ReceivePendingRequestListEvent evt);
}
