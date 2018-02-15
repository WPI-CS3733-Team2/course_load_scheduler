package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SearchUserEventHandler extends EventHandler{
	public void onSearchUser(SearchUserEvent evt);
}
