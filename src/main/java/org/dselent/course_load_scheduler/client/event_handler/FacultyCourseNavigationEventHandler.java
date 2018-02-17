package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface FacultyCourseNavigationEventHandler extends EventHandler
{
	public void onFacultyCourseNavigation(FacultyCourseNavigationEvent evt);
}
