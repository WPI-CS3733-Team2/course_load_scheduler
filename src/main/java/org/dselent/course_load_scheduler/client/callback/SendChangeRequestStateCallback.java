package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event.ReceiveChangeRequestStateEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.translator.impl.LoginActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendChangeRequestStateActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendChangeRequestStateCallback extends DisplayCallback<JSONValue>
{
	public SendChangeRequestStateCallback(SimpleEventBus eventBus, HasWidgets container)
	 {
		super(eventBus, container);
	 }

	
	@Override
	public void onSuccess(JSONValue result) {
		JSONObject json = JSONHelper.getObjectValue(result);
		SendChangeRequestStateActionTranslatorImpl sendChangeRequestStateActionTranslator = new SendChangeRequestStateActionTranslatorImpl();
		ReceiveChangeRequestStateAction action = sendChangeRequestStateActionTranslator.translateToAction(json);
	
		ReceiveChangeRequestStateEvent event = new ReceiveChangeRequestStateEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
	@Override
	public void onFailure(Throwable caught) {
		// temp hard coding...
		Window.alert("unable to change request state.");
	}
	
	
}
