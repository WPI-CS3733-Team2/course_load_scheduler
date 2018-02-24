package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveScheduleSpecificsEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveScheduleSpecificsEventHandler extends EventHandler
{
	  public void onReceiveScheduleSpecifics(ReceiveScheduleSpecificsEvent evt);
}