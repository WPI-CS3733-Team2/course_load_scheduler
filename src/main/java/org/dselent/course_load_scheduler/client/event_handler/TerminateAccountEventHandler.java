package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;

import com.google.gwt.event.shared.EventHandler;

public interface TerminateAccountEventHandler extends EventHandler{
	public void onTerminateAccount(TerminateAccountEvent evt);
}
