package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendAccountDetailsEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendAccountDetailsEventHandler extends EventHandler
{
	  public void onSendAccountDetails(SendAccountDetailsEvent evt);
}
