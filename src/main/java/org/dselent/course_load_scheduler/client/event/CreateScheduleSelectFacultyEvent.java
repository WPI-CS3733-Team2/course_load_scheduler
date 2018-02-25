package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectFacultyAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateScheduleSelectFacultyEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class CreateScheduleSelectFacultyEvent extends DisplayEvent<CreateScheduleSelectFacultyAction, CreateScheduleSelectFacultyEventHandler>{
	public static Type<CreateScheduleSelectFacultyEventHandler> TYPE = new Type<CreateScheduleSelectFacultyEventHandler>();

	
	public CreateScheduleSelectFacultyEvent(CreateScheduleSelectFacultyAction action, HasWidgets container)
	{
		super(action,container);
	}
	
	
	@Override
	public Type<CreateScheduleSelectFacultyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(CreateScheduleSelectFacultyEventHandler handler)
	{
		handler.onCreateScheduleSelectFaculty(this);
	}
}
