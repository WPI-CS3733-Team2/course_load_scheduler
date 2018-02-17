package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SearchScheduleNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SearchScheduleNavigationEventHandler extends EventHandler
{
	public void onSearchScheduleNavigation(SearchScheduleNavigationEvent evt);
}
