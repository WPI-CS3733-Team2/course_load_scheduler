package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveViewScheduleNavigationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveViewScheduleNavigationEventHandler extends EventHandler
{
	  public void onReceiveViewScheduleNavigation(ReceiveViewScheduleNavigationEvent evt);
}