package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;

import com.google.gwt.event.shared.EventHandler;

public interface TriggerChangePasswordWindowEventHandler extends EventHandler
{
	public void onTriggerChangePasswordWindow(TriggerChangePasswordWindowEvent evt);
}
