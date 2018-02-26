package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.LoginNavigationEvent;
import com.google.gwt.event.shared.EventHandler;

public interface LoginNavigationEventHandler extends EventHandler{
	public void onLoginNavigation(LoginNavigationEvent evt);
}
