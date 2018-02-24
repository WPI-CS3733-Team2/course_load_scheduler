package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveFacultyCourseNavigationEventHandler extends EventHandler
{
	  public void onReceiveFacultyCourseNavigation(ReceiveFacultyCourseNavigationEvent evt);
}