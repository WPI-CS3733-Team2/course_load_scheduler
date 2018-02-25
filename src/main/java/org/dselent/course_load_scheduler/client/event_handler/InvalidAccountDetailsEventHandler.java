package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.InvalidAccountDetailsEvent;
import com.google.gwt.event.shared.EventHandler;


public interface InvalidAccountDetailsEventHandler extends EventHandler
{
	  public void onInvalidAccountDetails(InvalidAccountDetailsEvent evt);
}
