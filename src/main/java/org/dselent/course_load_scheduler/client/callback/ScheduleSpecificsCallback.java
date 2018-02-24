package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.translator.impl.ScheduleSpecificsTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class ScheduleSpecificsCallback extends DisplayCallback<JSONValue>
{
	private Schedule schedule;
	
	public ScheduleSpecificsCallback(SimpleEventBus eventBus, HasWidgets container, Schedule schedule)
	 {
		super(eventBus, container);
		this.schedule = schedule;
	 }
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		ScheduleSpecificsTranslatorImpl scheduleSpecificsTranslator = new ScheduleSpecificsTranslatorImpl();
		ReceiveScheduleSpecificsAction action = scheduleSpecificsTranslator.translateToAction(json);
		action.setSchedule(schedule);
	
		ReceiveScheduleSpecificsEvent event = new ReceiveScheduleSpecificsEvent(action, getContainer());
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

		InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		InvalidLoginEvent ile = new InvalidLoginEvent(ila);
		eventBus.fireEvent(ile);
	}
	
}