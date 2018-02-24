package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SearchScheduleAction;
import org.dselent.course_load_scheduler.client.action.SearchScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.ViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.callback.ViewScheduleNavigationCallback;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleEvent;
import org.dselent.course_load_scheduler.client.event.ViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.ScheduleListService;
import org.dselent.course_load_scheduler.client.translator.impl.ViewScheduleNavigationActionTranslatorImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class ScheduleListServiceImpl extends BaseServiceImpl implements ScheduleListService
{
	public ScheduleListServiceImpl()
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
		
		registration = eventBus.addHandler(SearchScheduleEvent.TYPE, this);
		eventBusRegistration.put(SearchScheduleEvent.TYPE, registration);

		registration = eventBus.addHandler(CreateScheduleEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ViewScheduleNavigationEvent.TYPE, this);
		eventBusRegistration.put(ViewScheduleNavigationEvent.TYPE, registration);
	}
	
	@Override
	public void onViewScheduleNavigation(ViewScheduleNavigationEvent evt) {
		ViewScheduleNavigationAction action = evt.getAction();
		ViewScheduleNavigationActionTranslatorImpl viewScheduleNavigationActionTranslator = new ViewScheduleNavigationActionTranslatorImpl();
		JSONObject json = viewScheduleNavigationActionTranslator.translateToJson(action);
		ViewScheduleNavigationCallback viewScheduleNavigationCallback = new ViewScheduleNavigationCallback(eventBus, evt.getContainer());
	
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SCHEDULE_SEARCH, viewScheduleNavigationCallback, json);
		request.send();
	}
	
	@Override
	public void onSearchSchedule(SearchScheduleEvent evt) { 
		SearchScheduleAction action = evt.getAction();
		ViewScheduleNavigationActionTranslatorImpl viewScheduleNavigationActionTranslator = new ViewScheduleNavigationActionTranslatorImpl();
		JSONObject json = viewScheduleNavigationActionTranslator.translateToJson(action);
		ViewScheduleNavigationCallback viewScheduleNavigationCallback = new ViewScheduleNavigationCallback(eventBus, evt.getContainer());
	
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SCHEDULE_SEARCH, viewScheduleNavigationCallback, json);
		request.send();
	}
	
	@Override
	public void onCreateSchedule(CreateScheduleEvent evt) {
	}

}
