package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveTerminatedAccountEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveTerminatedAccountEventHandler extends EventHandler{
	public void onReceiveTerminatedAccount(ReceiveTerminatedAccountEvent evt);
}
