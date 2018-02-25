package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class ChangePasswordCallback extends Callback<JSONValue>
{
	public ChangePasswordCallback(SimpleEventBus eventBus)
	{
		super(eventBus);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		try
		{	
			ReceiveChangePasswordEvent event = new ReceiveChangePasswordEvent();
			eventBus.fireEvent(event);
		}
		catch(Throwable caught)
		{
			Window.alert(caught.getMessage());
		}
	}
  
	@Override
	public void onFailure(Throwable caught)
	{
		StringBuilder sb = new StringBuilder();

		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}
		
		InvalidChangePasswordAction icpa = new InvalidChangePasswordAction(caught.getMessage()/*sb.toString()*/);
		InvalidChangePasswordEvent icpe = new InvalidChangePasswordEvent(icpa);
		eventBus.fireEvent(icpe);
	}
	
}