package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.LoadPendingRequestListAction;
import org.dselent.course_load_scheduler.client.action.SendChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.callback.LoadPendingRequestListCallback;
import org.dselent.course_load_scheduler.client.callback.SendChangeRequestStateCallback;
import org.dselent.course_load_scheduler.client.event.LoadPendingRequestListEvent;
import org.dselent.course_load_scheduler.client.event.SendChangeRequestStateEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.RequestService;
import org.dselent.course_load_scheduler.client.translator.impl.LoadPendingRequestListActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendChangeRequestStateActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class RequestServiceImpl extends BaseServiceImpl implements RequestService
{
	public RequestServiceImpl() {}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(LoadPendingRequestListEvent.TYPE, this);
		eventBusRegistration.put(LoadPendingRequestListEvent.TYPE, registration);
		registration = eventBus.addHandler(SendChangeRequestStateEvent.TYPE, this);
		eventBusRegistration.put(SendChangeRequestStateEvent.TYPE, registration);
		
	}
	
	@Override
	public void onLoadPendingRequestList(LoadPendingRequestListEvent evt) {
		LoadPendingRequestListAction action = evt.getAction();
		LoadPendingRequestListActionTranslatorImpl lprlat = new LoadPendingRequestListActionTranslatorImpl();
		JSONObject json = lprlat.translateToJson(action);
		LoadPendingRequestListCallback pendingRequestListCallback = new LoadPendingRequestListCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.LOAD_PENDING_REQUEST_LIST, pendingRequestListCallback, json);
		request.send();
	}
	
	@Override
	public void onSendChangeRequestState(SendChangeRequestStateEvent evt) {
		SendChangeRequestStateAction action = evt.getAction();
		SendChangeRequestStateActionTranslatorImpl scrsat = new SendChangeRequestStateActionTranslatorImpl();
		JSONObject json = scrsat.translateToJson(action);
		SendChangeRequestStateCallback changeRequestStateCallback = new SendChangeRequestStateCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.CHANGE_REQUEST_STATE, changeRequestStateCallback, json);
		request.send();
	}
}
