package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleSelectCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class CreateScheduleSelectCoursesEvent extends GwtEvent<CreateScheduleSelectCoursesEventHandler>{
	public static Type<CreateScheduleSelectCoursesEventHandler> TYPE = new Type<CreateScheduleSelectCoursesEventHandler>();
	
	private CreateScheduleSelectCoursesAction action;
	
	public CreateScheduleSelectCoursesEvent(CreateScheduleSelectCoursesAction action)
	{
		this.action = action;
	}
	
	public CreateScheduleSelectCoursesAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<CreateScheduleSelectCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(CreateScheduleSelectCoursesEventHandler handler)
	{
		handler.onCreateScheduleSelectCourses(this);
	}
}
