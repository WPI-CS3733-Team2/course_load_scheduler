package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.event.ReceiveRequestsDetailsEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendRequestsDetailsActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendRequestsDetailsCallback extends DisplayCallback<JSONValue>{

	public SendRequestsDetailsCallback(SimpleEventBus eventBus, HasWidgets container) {
		super(eventBus, container);
	}

	@Override
	public void onSuccess(JSONValue result) {
		try {
			JSONObject json = JSONHelper.getObjectValue(result);
			SendRequestsDetailsActionTranslatorImpl srdat = new SendRequestsDetailsActionTranslatorImpl();
			ReceiveRequestsDetailsAction action = srdat.translateToAction(json);
			ReceiveRequestsDetailsEvent event = new ReceiveRequestsDetailsEvent(action, getContainer());
			eventBus.fireEvent(event);
		}
		catch (Throwable e){
			Window.alert("Code Error: " + e.toString());
		}
		
	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert("Fail in Callback class.");
	}
}
