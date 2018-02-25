package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.event_handler.ReceiveChangePasswordEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ReceiveChangePasswordEvent extends GwtEvent<ReceiveChangePasswordEventHandler>
{
	public static Type<ReceiveChangePasswordEventHandler> TYPE = new Type<ReceiveChangePasswordEventHandler>();
	
	public ReceiveChangePasswordEvent()
	{
		super();
	}

	@Override
	public Type<ReceiveChangePasswordEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveChangePasswordEventHandler handler)
	{
		handler.onReceiveChangePassword(this);
	}
}
