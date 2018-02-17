package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SearchScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SearchScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class SearchScheduleEvent extends GwtEvent<SearchScheduleEventHandler>
{
	public static Type<SearchScheduleEventHandler> TYPE = new Type<SearchScheduleEventHandler>();
	
	private SearchScheduleAction action;
	
	public SearchScheduleEvent(SearchScheduleAction action)
	{
		this.action = action;
	}
	
	public SearchScheduleAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SearchScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SearchScheduleEventHandler handler)
	{
		handler.onSearchSchedule(this);
	}
}
