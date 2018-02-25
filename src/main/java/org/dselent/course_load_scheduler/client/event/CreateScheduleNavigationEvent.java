package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleNavigationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class CreateScheduleNavigationEvent extends DisplayEvent<CreateScheduleNavigationAction, CreateScheduleNavigationEventHandler>{
	public static Type<CreateScheduleNavigationEventHandler> TYPE = new Type<CreateScheduleNavigationEventHandler>();
	
	public CreateScheduleNavigationEvent(CreateScheduleNavigationAction action, HasWidgets container)
	{
		super(action,container);
	}
	
	
	@Override
	public Type<CreateScheduleNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(CreateScheduleNavigationEventHandler handler)
	{
		handler.onCreateScheduleNavigation(this);
	}
}
