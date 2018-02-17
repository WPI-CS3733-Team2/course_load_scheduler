package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ConfirmSchedulePageEventHandler extends EventHandler{
	public void onConfirmSchedulePage(ConfirmSchedulePageEvent evt);
}
