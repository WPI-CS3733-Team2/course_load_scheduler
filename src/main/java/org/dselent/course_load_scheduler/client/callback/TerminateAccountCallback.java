package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveTerminatedAccountAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveTerminatedAccountEvent;
import org.dselent.course_load_scheduler.client.translator.impl.TerminateAccountActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class TerminateAccountCallback extends Callback<JSONValue>{
	public TerminateAccountCallback(SimpleEventBus eventBus)
	 {
		super(eventBus);
	 }
	
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		TerminateAccountActionTranslatorImpl terminateAccountActionTranslator = new TerminateAccountActionTranslatorImpl();
		ReceiveTerminatedAccountAction action = terminateAccountActionTranslator.translateToAction(json);
	
		ReceiveTerminatedAccountEvent event = new ReceiveTerminatedAccountEvent(action);
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

		//Not sure if we need an invalid event for this.
		InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		InvalidLoginEvent ile = new InvalidLoginEvent(ila);
		eventBus.fireEvent(ile);
	}
}
