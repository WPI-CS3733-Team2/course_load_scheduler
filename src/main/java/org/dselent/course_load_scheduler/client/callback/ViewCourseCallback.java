package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidSearchCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSearchCourseEvent;
import org.dselent.course_load_scheduler.client.translator.impl.FacultyCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class ViewCourseCallback extends DisplayCallback<JSONValue>
{
	public ViewCourseCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		FacultyCourseTranslatorImpl facultyCourseTranslator = new FacultyCourseTranslatorImpl();
		ViewSectionAction action = facultyCourseTranslator.translateToAction(json);
		
		FacultySectionEvent event = new FacultySectionEvent(action, getContainer());
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

		InvalidSearchCourseAction sca = new InvalidSearchCourseAction();
		InvalidSearchCourseEvent sce = new InvalidSearchCourseEvent(sca);
		eventBus.fireEvent(sce);
	}
	
}