package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.SearchUserAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidLoginEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SearchUserEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SearchUserEvent extends GwtEvent<SearchUserEventHandler>{
	
	public static Type<SearchUserEventHandler> TYPE = new Type<SearchUserEventHandler>();

	private SearchUserAction action;
	
	public SearchUserEvent(SearchUserAction action)
	{
		this.action = action;
	}
	
	@Override
	public Type<SearchUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SearchUserEventHandler handler)
	{
		handler.onSearchUser(this);
	}
}
