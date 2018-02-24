package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.InvalidEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidEventHandler extends EventHandler{
	public void onInvalid(InvalidEvent evt);
}
