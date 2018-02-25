package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveUserSearchResultsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveUserSearchResultsEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SearchUserEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ReceiveUserSearchResultsEvent extends GwtEvent<ReceiveUserSearchResultsEventHandler>{
	public static Type<ReceiveUserSearchResultsEventHandler> TYPE = new Type<ReceiveUserSearchResultsEventHandler>();

	private ReceiveUserSearchResultsAction action;
	
	public ReceiveUserSearchResultsEvent(ReceiveUserSearchResultsAction action)
	{
		this.action = action;
		//super(action,container);
	}
	
	public ReceiveUserSearchResultsAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<ReceiveUserSearchResultsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveUserSearchResultsEventHandler handler)
	{
		handler.onReceiveUserSearchResults(this);
	}
}
