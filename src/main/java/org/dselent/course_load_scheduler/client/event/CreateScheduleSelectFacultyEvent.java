package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectFacultyAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleSelectFacultyEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class CreateScheduleSelectFacultyEvent extends GwtEvent<CreateScheduleSelectFacultyEventHandler>{
	public static Type<CreateScheduleSelectFacultyEventHandler> TYPE = new Type<CreateScheduleSelectFacultyEventHandler>();
	
	private CreateScheduleSelectFacultyAction action;
	
	public CreateScheduleSelectFacultyEvent(CreateScheduleSelectFacultyAction action)
	{
		this.action = action;
	}
	
	public CreateScheduleSelectFacultyAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<CreateScheduleSelectFacultyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(CreateScheduleSelectFacultyEventHandler handler)
	{
		handler.onCreateScheduleSelectFaculty(this);
	}
}
