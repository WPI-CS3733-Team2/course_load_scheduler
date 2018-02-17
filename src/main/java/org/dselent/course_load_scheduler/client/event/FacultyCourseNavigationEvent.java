package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.FacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.FacultyCourseNavigationEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class FacultyCourseNavigationEvent extends GwtEvent<FacultyCourseNavigationEventHandler>{
	public static Type<FacultyCourseNavigationEventHandler> TYPE = new Type<FacultyCourseNavigationEventHandler>();
	
	private FacultyCourseNavigationAction action;
	
	public FacultyCourseNavigationEvent(FacultyCourseNavigationAction action)
	{
		this.action = action;
	}
	
	public FacultyCourseNavigationAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<FacultyCourseNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(FacultyCourseNavigationEventHandler handler)
	{
		handler.onFacultyCourseNavigation(this);
	}
}
