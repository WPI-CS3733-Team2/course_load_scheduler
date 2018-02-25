package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidSearchCourseEvent;
import com.google.gwt.event.shared.EventHandler;

public interface InvalidSearchCourseEventHandler extends EventHandler{
	public void onInvalidSearchCourse(InvalidSearchCourseEvent evt);
}
