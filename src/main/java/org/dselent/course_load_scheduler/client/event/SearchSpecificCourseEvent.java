package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SearchSpecificCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleNavigationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class SearchSpecificCourseEvent extends DisplayEvent<SearchSpecificCourseAction, CreateScheduleNavigationEventHandler>{
	public static Type<CreateScheduleNavigationEventHandler> TYPE = new Type<CreateScheduleNavigationEventHandler>();

	public SearchSpecificCourseEvent(SearchSpecificCourseAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<CreateScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(CreateScheduleNavigationEventHandler handler)
	{
		handler.onSearchSpecificCourse(this);
	}
}
