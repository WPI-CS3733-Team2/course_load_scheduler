package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ViewCalendarAction;
import org.dselent.course_load_scheduler.client.event.AdminCalendarEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SectionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class ViewAdminSectionCallback extends DisplayCallback<JSONValue>
{
	public ViewAdminSectionCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		SectionTranslatorImpl facultyCourseTranslator = new SectionTranslatorImpl();
		ViewCalendarAction action = facultyCourseTranslator.translateToAction(json);
		
		AdminCalendarEvent event = new AdminCalendarEvent(action, getContainer());
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

		System.out.println("Something went wrong with Faculty Courses ;-;");
		/*InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		InvalidLoginEvent ile = new InvalidLoginEvent(ila);
		eventBus.fireEvent(ile);*/
	}
	
}