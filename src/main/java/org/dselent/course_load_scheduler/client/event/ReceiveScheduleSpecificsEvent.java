package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveScheduleSpecificsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveScheduleSpecificsEvent extends DisplayEvent<ReceiveScheduleSpecificsAction, ReceiveScheduleSpecificsEventHandler>
{
	public static Type<ReceiveScheduleSpecificsEventHandler> TYPE = new Type<ReceiveScheduleSpecificsEventHandler>();
	
	public ReceiveScheduleSpecificsEvent(ReceiveScheduleSpecificsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveScheduleSpecificsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveScheduleSpecificsEventHandler handler)
	{
		handler.onReceiveScheduleSpecifics(this);
	}
}