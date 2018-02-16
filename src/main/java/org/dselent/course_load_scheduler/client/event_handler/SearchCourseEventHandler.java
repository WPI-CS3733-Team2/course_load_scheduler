package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SearchCourseEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SearchCourseEventHandler extends EventHandler{
	public void onSearchCourse(SearchCourseEvent evt);
}
