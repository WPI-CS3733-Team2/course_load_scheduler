package org.dselent.course_load_scheduler.client.callback;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidAddCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddCourseEvent;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class AddSectionsCallback extends DisplayCallback<JSONValue>
{
	public AddSectionsCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		/*JSONObject json = JSONHelper.getObjectValue(result);
		AddCourseTranslatorImpl addCourseTranslator = new AddCourseTranslatorImpl();
		ReceiveAddCourseAction action = addCourseTranslator.translateToAction(json);
		*/
		ViewCourseAction action = new ViewCourseAction();
		AdminCourseEvent event = new AdminCourseEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
  
	@Override
	public void onFailure(Throwable caught)
	{
		// TODO
		// give better exception information
		// these stack traces are not helpful
	
		StringBuilder sb = new StringBuilder();

		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}
		List<String> list = new ArrayList<>();
		list.add(sb.toString());
		
		InvalidAddCourseAction sca = new InvalidAddCourseAction(list);
		InvalidAddCourseEvent sce = new InvalidAddCourseEvent(sca);
		eventBus.fireEvent(sce);
	}
	
}