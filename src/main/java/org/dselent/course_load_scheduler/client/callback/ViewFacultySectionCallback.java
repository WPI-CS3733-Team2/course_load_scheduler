package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ViewCalendarAction;
import org.dselent.course_load_scheduler.client.event.FacultyCalendarEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SectionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class ViewFacultySectionCallback extends DisplayCallback<JSONValue>
{
	public ViewFacultySectionCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		SectionTranslatorImpl facultyCourseTranslator = new SectionTranslatorImpl();
		ViewCalendarAction action = facultyCourseTranslator.translateToAction(json);
		
		FacultyCalendarEvent event = new FacultyCalendarEvent(action, getContainer());
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

		/*InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		InvalidLoginEvent ile = new InvalidLoginEvent(ila);
		eventBus.fireEvent(ile);*/
	}
	
}