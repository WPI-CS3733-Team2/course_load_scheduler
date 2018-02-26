package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.AddSectionsAction;
import org.dselent.course_load_scheduler.client.event_handler.AddSectionsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class AddSectionsEvent extends DisplayEvent<AddSectionsAction, AddSectionsEventHandler>
{
	public static Type<AddSectionsEventHandler> TYPE = new Type<AddSectionsEventHandler>();
	
	public AddSectionsEvent(AddSectionsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	/*
	 * 
	 */
	@Override
	public Type<AddSectionsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(AddSectionsEventHandler handler)
	{
		handler.onAddSections(this);
	}
}

