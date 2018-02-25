package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveCreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SelectCoursesTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SelectCoursesCallback extends DisplayCallback<JSONValue>
{
	
	public SelectCoursesCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		SelectCoursesTranslatorImpl selectCoursesTranslator = new SelectCoursesTranslatorImpl();
		ReceiveCreateScheduleNavigationAction action = selectCoursesTranslator.translateToAction(json);
	
		ReceiveCreateScheduleNavigationEvent event = new ReceiveCreateScheduleNavigationEvent(action, getContainer());
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


		Window.alert("Failure to get unassigned course sections information:" + sb);
	}
	
}