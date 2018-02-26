package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateUserEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.ModifyCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ModifyCourseEvent extends GwtEvent<ModifyCourseEventHandler>{
	public static Type<ModifyCourseEventHandler> TYPE = new Type<ModifyCourseEventHandler>();
	
	private ModifyCourseAction action;
	
	public ModifyCourseEvent(ModifyCourseAction action)
	{
		this.action = action;
	}
	
	public ModifyCourseAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<ModifyCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ModifyCourseEventHandler handler)
	{
		handler.onModifyCourse(this);
	}
}
