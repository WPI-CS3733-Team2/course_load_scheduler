package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveAccountDetailsEvent;
import com.google.gwt.event.shared.EventHandler;


public interface ReceiveAccountDetailsEventHandler extends EventHandler
{
	  public void onReceiveAccountDetails(ReceiveAccountDetailsEvent evt);
}
