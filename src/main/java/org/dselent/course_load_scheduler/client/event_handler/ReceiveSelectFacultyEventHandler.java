package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectFacultyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSelectFacultyEventHandler extends EventHandler
{
	  public void onReceiveSelectFaculty(ReceiveSelectFacultyEvent evt);
}