package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.LoginNavigationAction;
import org.dselent.course_load_scheduler.client.event_handler.LoginNavigationEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class LoginNavigationEvent extends GwtEvent<LoginNavigationEventHandler>{
	public static Type<LoginNavigationEventHandler> TYPE = new Type<LoginNavigationEventHandler>();
	
	private LoginNavigationAction action;
	
	public LoginNavigationEvent(LoginNavigationAction action)
	{
		this.action = action;
	}
	
	/*public CreateUserEvent(CreateUserAction action, HasWidgets container)
	{
		super(action, container);
	}*/
	
	public LoginNavigationAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<LoginNavigationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(LoginNavigationEventHandler handler)
	{
		handler.onLoginNavigation(this);
	}
}
