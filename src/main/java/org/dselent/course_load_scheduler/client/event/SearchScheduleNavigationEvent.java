package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SearchScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.SearchScheduleNavigationEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SearchScheduleNavigationEvent extends GwtEvent<SearchScheduleNavigationEventHandler>{
	public static Type<SearchScheduleNavigationEventHandler> TYPE = new Type<SearchScheduleNavigationEventHandler>();
	
	private SearchScheduleNavigationAction action;
	
	public SearchScheduleNavigationEvent(SearchScheduleNavigationAction action)
	{
		this.action = action;
	}
	
	public SearchScheduleNavigationAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SearchScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SearchScheduleNavigationEventHandler handler)
	{
		handler.onSearchScheduleNavigation(this);
	}
}
