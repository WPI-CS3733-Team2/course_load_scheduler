package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.Action;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

// should have base event without an action
// have an ActionEvent with an action
// have a DisplayEvent with HasWidets
// have a DisplayAction event with both an action and HasWidgets
// ^ use with bridge pattern?
public abstract class BaseEvent<A extends Action, E extends EventHandler> extends GwtEvent<E>
{
	private A action;
	
	public BaseEvent(A action)
	{
		this.action = action;
	}

	public A getAction()
	{
		return action;
	}
	
}