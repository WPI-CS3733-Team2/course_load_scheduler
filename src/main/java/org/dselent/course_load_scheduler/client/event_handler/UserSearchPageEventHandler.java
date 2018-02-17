package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;

import com.google.gwt.event.shared.EventHandler;

public interface UserSearchPageEventHandler extends EventHandler{
	public void onUserSearchPage(UserSearchPageEvent evt);
}
