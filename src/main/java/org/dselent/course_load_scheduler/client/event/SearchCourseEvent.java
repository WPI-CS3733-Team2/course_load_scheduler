package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SearchCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.SearchCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SearchCourseEvent extends GwtEvent<SearchCourseEventHandler>{
	public static Type<SearchCourseEventHandler> TYPE = new Type<SearchCourseEventHandler>();

	private SearchCourseAction action;
	
	public SearchCourseEvent(SearchCourseAction action)
	{
		this.action = action;
	}
	
	@Override
	public Type<SearchCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SearchCourseEventHandler handler)
	{
		handler.onSearchCourse(this);
	}
}
