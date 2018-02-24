package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveChangeRequestStateEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveChangeRequestStateEventHandler extends EventHandler{
	public void onReceiveChangeRequestState(ReceiveChangeRequestStateEvent evt);
}
