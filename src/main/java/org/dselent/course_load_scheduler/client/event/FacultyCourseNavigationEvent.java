package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.FacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.FacultyCourseNavigationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class FacultyCourseNavigationEvent extends DisplayEvent<FacultyCourseNavigationAction, FacultyCourseNavigationEventHandler>{
	public static Type<FacultyCourseNavigationEventHandler> TYPE = new Type<FacultyCourseNavigationEventHandler>();
	
	public FacultyCourseNavigationEvent(FacultyCourseNavigationAction action, HasWidgets container)
	{
		super(action,container);
	}
	
	@Override
	public Type<FacultyCourseNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(FacultyCourseNavigationEventHandler handler)
	{
		handler.onFacultyCourseNavigation(this);
	}
}
