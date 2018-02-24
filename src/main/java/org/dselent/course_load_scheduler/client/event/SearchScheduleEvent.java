package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SearchScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.ViewScheduleNavigationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class SearchScheduleEvent extends DisplayEvent<SearchScheduleAction, ViewScheduleNavigationEventHandler>{
	public static Type<ViewScheduleNavigationEventHandler> TYPE = new Type<ViewScheduleNavigationEventHandler>();

	public SearchScheduleEvent(SearchScheduleAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<ViewScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ViewScheduleNavigationEventHandler handler)
	{
		handler.onSearchSchedule(this);
	}
}
