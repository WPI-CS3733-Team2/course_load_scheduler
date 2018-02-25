package org.dselent.course_load_scheduler.client.callback;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectFacultyAction;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.translator.impl.SelectFacultyTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SelectFacultyCallback extends DisplayCallback<JSONValue>
{
	private List<Course> courseList = new ArrayList<Course>();
	
	public SelectFacultyCallback(SimpleEventBus eventBus, HasWidgets container, List<Course> courseList)
	 {
		super(eventBus, container);
		this.courseList = courseList;
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		SelectFacultyTranslatorImpl selectFacultyTranslator = new SelectFacultyTranslatorImpl();
		ReceiveSelectFacultyAction action = selectFacultyTranslator.translateToAction(json);
		action.setCourseList(courseList);
	
		ReceiveSelectFacultyEvent event = new ReceiveSelectFacultyEvent(action, getContainer());
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


		Window.alert("Failure to get unassigned faculty information:" + sb);
	}
	
}