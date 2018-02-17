package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateScheduleSelectCoursesEventHandler extends EventHandler
{
	public void onCreateScheduleSelectCourses(CreateScheduleSelectCoursesEvent evt);
}
