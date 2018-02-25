package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import com.google.gwt.event.shared.EventHandler;


public interface ReceiveChangePasswordEventHandler extends EventHandler
{
	  public void onReceiveChangePassword(ReceiveChangePasswordEvent evt);
}
