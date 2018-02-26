package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ModifyCourseEventHandler extends EventHandler{
	public void onModifyCourse(ModifyCourseEvent evt);
}
