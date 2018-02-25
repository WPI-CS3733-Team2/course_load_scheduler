package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event.ReceiveViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ViewScheduleNavigationActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class ViewScheduleNavigationCallback extends DisplayCallback<JSONValue>
{
	public ViewScheduleNavigationCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		ViewScheduleNavigationActionTranslatorImpl ViewScheduleNavigationActionTranslator = new ViewScheduleNavigationActionTranslatorImpl();
		ReceiveViewScheduleNavigationAction action = ViewScheduleNavigationActionTranslator.translateToAction(json);
	
		ReceiveViewScheduleNavigationEvent event = new ReceiveViewScheduleNavigationEvent(action, getContainer());
		eventBus.fireEvent(event);
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


		Window.alert("Failure to get list of schedule information:" + sb);
	}
	
}