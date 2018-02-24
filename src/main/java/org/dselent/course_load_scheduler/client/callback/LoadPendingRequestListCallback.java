package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceivePendingRequestListAction;
import org.dselent.course_load_scheduler.client.event.ReceivePendingRequestListEvent;
import org.dselent.course_load_scheduler.client.translator.impl.LoadPendingRequestListActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class LoadPendingRequestListCallback extends DisplayCallback<JSONValue>{

	public LoadPendingRequestListCallback(SimpleEventBus eventBus, HasWidgets container) {
		super(eventBus, container);
	}

	@Override
	public void onSuccess(JSONValue result)
	{
		try {
			JSONObject json = JSONHelper.getObjectValue(result);
			LoadPendingRequestListActionTranslatorImpl lprati = new LoadPendingRequestListActionTranslatorImpl();
			ReceivePendingRequestListAction action = lprati.translateToAction(json);
			ReceivePendingRequestListEvent event = new ReceivePendingRequestListEvent(action, getContainer());
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
