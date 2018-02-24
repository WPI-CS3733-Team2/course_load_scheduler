package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.LoadPendingRequestListEvent;

import com.google.gwt.event.shared.EventHandler;

public interface LoadPendingRequestListEventHandler extends EventHandler
{
	public void onLoadPendingRequestList(LoadPendingRequestListEvent evt);
}
