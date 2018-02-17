package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.UserCreatePageEvent;

import com.google.gwt.event.shared.EventHandler;

public interface UserCreatePageEventHandler extends EventHandler{
	public void onUserCreatePage(UserCreatePageEvent evt);
}
