package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveViewScheduleNavigationEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveViewScheduleNavigationEvent extends DisplayEvent<ReceiveViewScheduleNavigationAction, ReceiveViewScheduleNavigationEventHandler>
{
	public static Type<ReceiveViewScheduleNavigationEventHandler> TYPE = new Type<ReceiveViewScheduleNavigationEventHandler>();
	
	public ReceiveViewScheduleNavigationEvent(ReceiveViewScheduleNavigationAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveViewScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveViewScheduleNavigationEventHandler handler)
	{
		handler.onReceiveViewScheduleNavigation(this);
	}
}