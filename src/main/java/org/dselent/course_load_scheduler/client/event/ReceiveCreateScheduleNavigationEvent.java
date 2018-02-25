package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveCreateScheduleNavigationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveCreateScheduleNavigationEvent extends DisplayEvent<ReceiveCreateScheduleNavigationAction, ReceiveCreateScheduleNavigationEventHandler>
{
	public static Type<ReceiveCreateScheduleNavigationEventHandler> TYPE = new Type<ReceiveCreateScheduleNavigationEventHandler>();
	
	public ReceiveCreateScheduleNavigationEvent(ReceiveCreateScheduleNavigationAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveCreateScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveCreateScheduleNavigationEventHandler handler)
	{
		handler.onReceiveCreateScheduleNavigation(this);
	}
}