package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidSearchCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidSearchCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidSearchCourseEvent extends GwtEvent<InvalidSearchCourseEventHandler>{
	public static Type<InvalidSearchCourseEventHandler> TYPE = new Type<InvalidSearchCourseEventHandler>();

	private InvalidSearchCourseAction action;
	
	public InvalidSearchCourseEvent(InvalidSearchCourseAction action)
	{
		this.action = action;
	}
	
	@Override
	public Type<InvalidSearchCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidSearchCourseEventHandler handler)
	{
		handler.onInvalidSearchCourse(this);
	}
}
