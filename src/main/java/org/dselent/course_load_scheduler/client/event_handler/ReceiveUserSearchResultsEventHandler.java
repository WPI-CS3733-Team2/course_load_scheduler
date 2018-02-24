package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveUserSearchResultsEvent;
import com.google.gwt.event.shared.EventHandler;

public interface ReceiveUserSearchResultsEventHandler extends EventHandler{
	public void onReceiveUserSearchResults(ReceiveUserSearchResultsEvent evt);
}
