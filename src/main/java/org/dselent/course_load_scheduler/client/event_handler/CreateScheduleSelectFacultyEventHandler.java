package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectFacultyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateScheduleSelectFacultyEventHandler extends EventHandler
{
	public void onCreateScheduleSelectFaculty(CreateScheduleSelectFacultyEvent evt);
}
