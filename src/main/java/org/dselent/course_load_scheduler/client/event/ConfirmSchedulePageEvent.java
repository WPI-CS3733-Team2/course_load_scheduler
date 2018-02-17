package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ConfirmSchedulePageAction;
import org.dselent.course_load_scheduler.client.event_handler.ConfirmSchedulePageEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class ConfirmSchedulePageEvent extends GwtEvent<ConfirmSchedulePageEventHandler>{
	public static Type<ConfirmSchedulePageEventHandler> TYPE = new Type<ConfirmSchedulePageEventHandler>();
	
	private ConfirmSchedulePageAction action;
	
	public ConfirmSchedulePageEvent(ConfirmSchedulePageAction action)
	{
		this.action = action;
	}
	
	public ConfirmSchedulePageAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ConfirmSchedulePageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ConfirmSchedulePageEventHandler handler)
	{
		handler.onConfirmSchedulePage(this);
	}
}
