package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.UserDetailsPageEvent;

import com.google.gwt.event.shared.EventHandler;

public interface UserDetailsPageEventHandler extends EventHandler{
	public void onUserDetailsPage(UserDetailsPageEvent evt);
}
