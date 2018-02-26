package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCalendarsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveAdminCourseEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveAdminCourseEvent extends DisplayEvent<ReceiveCalendarsAction, ReceiveAdminCourseEventHandler>
{
	public static Type<ReceiveAdminCourseEventHandler> TYPE = new Type<ReceiveAdminCourseEventHandler>();
	
	public ReceiveAdminCourseEvent(ReceiveCalendarsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveAdminCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveAdminCourseEventHandler handler) {
		handler.onReceiveAdminCourse(this);
	}
}