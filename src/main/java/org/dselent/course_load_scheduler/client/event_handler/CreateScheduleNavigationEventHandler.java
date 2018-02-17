package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateScheduleNavigationEventHandler extends EventHandler
{
	public void onCreateScheduleNavigation(CreateScheduleNavigationEvent evt);
}
