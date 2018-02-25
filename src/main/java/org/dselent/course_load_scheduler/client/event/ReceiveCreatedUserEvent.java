package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event_handler.FacultyCourseEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveCreatedUserEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveLoginEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveCreatedUserEvent extends GwtEvent<ReceiveCreatedUserEventHandler>{
	public static Type<ReceiveCreatedUserEventHandler> TYPE = new Type<ReceiveCreatedUserEventHandler>();
	
	private ReceiveCreatedUserAction action;
	
	/*public ReceiveCreatedUserEvent(ReceiveCreatedUserAction action, HasWidgets container)
	{
		super(action, container);
	}*/
	
	public ReceiveCreatedUserEvent(ReceiveCreatedUserAction action)
	{
		this.action = action;
	}
	
	public ReceiveCreatedUserAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<ReceiveCreatedUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveCreatedUserEventHandler handler)
	{
		handler.onReceiveCreatedUser(this);
	}
}
