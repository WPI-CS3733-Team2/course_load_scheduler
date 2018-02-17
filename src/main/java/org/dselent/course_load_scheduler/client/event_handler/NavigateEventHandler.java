package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.NavigateEvent;

import com.google.gwt.event.shared.EventHandler;

public interface NavigateEventHandler extends EventHandler{
	public void onNavigate(NavigateEvent evt);
}
