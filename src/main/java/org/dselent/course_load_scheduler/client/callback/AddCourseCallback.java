package org.dselent.course_load_scheduler.client.callback;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidAddCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidSearchCourseAction;
import org.dselent.course_load_scheduler.client.action.ReceiveAddCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSearchCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAddCourseEvent;
import org.dselent.course_load_scheduler.client.translator.impl.AddCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class AddCourseCallback extends DisplayCallback<JSONValue>
{
	public AddCourseCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		AddCourseTranslatorImpl addCourseTranslator = new AddCourseTranslatorImpl();
		ReceiveAddCourseAction action = addCourseTranslator.translateToAction(json);
		
		ReceiveAddCourseEvent event = new ReceiveAddCourseEvent(action, getContainer());
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