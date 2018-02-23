package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SearchScheduleEvent;
import org.dselent.course_load_scheduler.client.event.ViewScheduleNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ViewScheduleNavigationEventHandler extends EventHandler
{
	public void onViewScheduleNavigation(ViewScheduleNavigationEvent evt);
	public void onSearchSchedule(SearchScheduleEvent evt); 
}
