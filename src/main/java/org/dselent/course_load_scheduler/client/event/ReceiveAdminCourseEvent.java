package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSectionsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveAdminCourseEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveAdminCourseEvent extends DisplayEvent<ReceiveSectionsAction, ReceiveAdminCourseEventHandler>
{
	public static Type<ReceiveAdminCourseEventHandler> TYPE = new Type<ReceiveAdminCourseEventHandler>();
	
	public ReceiveAdminCourseEvent(ReceiveSectionsAction action, HasWidgets container)
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