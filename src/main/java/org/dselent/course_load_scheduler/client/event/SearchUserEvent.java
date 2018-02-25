package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.SearchUserAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateUserEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SearchUserEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendLoginEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HasWidgets;

public class SearchUserEvent extends GwtEvent<SearchUserEventHandler>{
	
	public static Type<SearchUserEventHandler> TYPE = new Type<SearchUserEventHandler>();

	private SearchUserAction action;
	
	public SearchUserEvent(SearchUserAction action)
	{
		this.action = action;
		//super(action,container);
	}
	
	public SearchUserAction getAction()
	{
		return action;
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
