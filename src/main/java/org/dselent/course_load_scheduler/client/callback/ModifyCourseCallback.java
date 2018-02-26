package org.dselent.course_load_scheduler.client.callback;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class ModifyCourseCallback extends DisplayCallback<JSONValue>
{
	public ModifyCourseCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		
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
		Window.alert("Unable to connect to the database");
		
		/*InvalidAddCourseAction sca = new InvalidAddCourseAction(list);
		InvalidAddCourseEvent sce = new InvalidAddCourseEvent(sca);
		eventBus.fireEvent(sce);*/
	}
	
}