package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.RequestInboxNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface RequestInboxNavigationEventHandler extends EventHandler
{
	public void onRequestInboxNavigation(RequestInboxNavigationEvent evt);
}
