package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateScheduleNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveCreateScheduleNavigationEventHandler extends EventHandler
{
	  public void onReceiveCreateScheduleNavigation(ReceiveCreateScheduleNavigationEvent evt);
}