package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveCreateRequestAction;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateRequestEvent;
import org.dselent.course_load_scheduler.client.exceptions.InvalidJsonException;
import org.dselent.course_load_scheduler.client.translator.impl.SendCreateRequestActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendCreateRequestCallback extends DisplayCallback<JSONValue>{

	public SendCreateRequestCallback(SimpleEventBus eventBus, HasWidgets container) {
		super(eventBus, container);
	}

	@Override
	public void onSuccess(JSONValue result) {
		try {
			JSONObject json = JSONHelper.getObjectValue(result);
			SendCreateRequestActionTranslatorImpl scrat = new SendCreateRequestActionTranslatorImpl();
			ReceiveCreateRequestAction action = scrat.translateToAction(json);
			ReceiveCreateRequestEvent event = new ReceiveCreateRequestEvent(action, getContainer());
			eventBus.fireEvent(event);
		}
		catch (Throwable e)
		{
			Window.alert("Code Error: " + e.toString());
		}
		
	}
	
	@Override
	public void onFailure(Throwable caught){
		try {
			throw new InvalidJsonException("Fail in Callback class.");
		} catch (InvalidJsonException e) {
			e.printStackTrace();
		}
	}
}
