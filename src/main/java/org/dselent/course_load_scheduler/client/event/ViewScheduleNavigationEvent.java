package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.ViewScheduleNavigationEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class ViewScheduleNavigationEvent extends GwtEvent<ViewScheduleNavigationEventHandler>{
	public static Type<ViewScheduleNavigationEventHandler> TYPE = new Type<ViewScheduleNavigationEventHandler>();
	
	private ViewScheduleNavigationAction action;
	
	public ViewScheduleNavigationEvent(ViewScheduleNavigationAction action)
	{
		this.action = action;
	}
	
	public ViewScheduleNavigationAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<ViewScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(ViewScheduleNavigationEventHandler handler)
	{
		handler.onViewScheduleNavigation(this);
	}
}
