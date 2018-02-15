package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateScheduleEventHandler extends EventHandler
{
	public void onCreateSchedule(CreateScheduleEvent evt);
}
