package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCalendarsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveFacultyCourseEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveFacultyCourseEvent extends DisplayEvent<ReceiveCalendarsAction, ReceiveFacultyCourseEventHandler>
{
	public static Type<ReceiveFacultyCourseEventHandler> TYPE = new Type<ReceiveFacultyCourseEventHandler>();
	
	public ReceiveFacultyCourseEvent(ReceiveCalendarsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveFacultyCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveFacultyCourseEventHandler handler) {
		handler.onReceiveFacultyCourse(this);
	}
}