package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.SearchSpecificCourseEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateScheduleNavigationEventHandler extends EventHandler
{
	public void onCreateScheduleNavigation(CreateScheduleNavigationEvent evt);
	public void onSearchSpecificCourse(SearchSpecificCourseEvent evt);
}
