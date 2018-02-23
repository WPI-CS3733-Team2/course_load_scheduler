package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.ViewScheduleNavigationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ViewScheduleNavigationEvent extends DisplayEvent<ViewScheduleNavigationAction, ViewScheduleNavigationEventHandler>{
	public static Type<ViewScheduleNavigationEventHandler> TYPE = new Type<ViewScheduleNavigationEventHandler>();
	
	
	public ViewScheduleNavigationEvent(ViewScheduleNavigationAction action,  HasWidgets container)
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
		handler.onViewScheduleNavigation(this);
	}
}
