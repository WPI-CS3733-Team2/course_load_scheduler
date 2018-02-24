package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.ScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.callback.ScheduleSpecificsCallback;
import org.dselent.course_load_scheduler.client.event.ScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.ScheduleSpecificsService;
import org.dselent.course_load_scheduler.client.translator.impl.ScheduleSpecificsTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.ViewScheduleNavigationActionTranslatorImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class ScheduleSpecificsServiceImpl extends BaseServiceImpl implements ScheduleSpecificsService
{
	public ScheduleSpecificsServiceImpl()
	{
		
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(ScheduleSpecificsEvent.TYPE, this);
		eventBusRegistration.put(ScheduleSpecificsEvent.TYPE, registration);
	}
	
	@Override
	public void onScheduleSpecifics(ScheduleSpecificsEvent evt) {
		ScheduleSpecificsAction action = evt.getAction();
		
		ScheduleSpecificsTranslatorImpl scheduleSpecificsTranslator = new ScheduleSpecificsTranslatorImpl();
		JSONObject json = scheduleSpecificsTranslator.translateToJson(action);
		ScheduleSpecificsCallback scheduleSpecificsNavigationCallback = new ScheduleSpecificsCallback(eventBus, evt.getContainer(), action.getSchedule());
	
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SCHEDULE_SPECIFICS, scheduleSpecificsNavigationCallback, json);
		request.send();
	}
	
}
