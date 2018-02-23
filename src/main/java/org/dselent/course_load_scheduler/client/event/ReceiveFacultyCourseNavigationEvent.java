package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveFacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveFacultyCourseNavigationEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveFacultyCourseNavigationEvent extends DisplayEvent<ReceiveFacultyCourseNavigationAction, ReceiveFacultyCourseNavigationEventHandler>
{
	public static Type<ReceiveFacultyCourseNavigationEventHandler> TYPE = new Type<ReceiveFacultyCourseNavigationEventHandler>();
	
	public ReceiveFacultyCourseNavigationEvent(ReceiveFacultyCourseNavigationAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveFacultyCourseNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveFacultyCourseNavigationEventHandler handler)
	{
		handler.onReceiveFacultyCourseNavigation(this);
	}
}