package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.InvalidAction;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreatedUserEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.translator.impl.CreateUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.LoginActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class CreateUserCallback extends Callback<JSONValue>{
	
	public CreateUserCallback(SimpleEventBus eventBus)
	 {
		super(eventBus);
	 }
	
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		CreateUserActionTranslatorImpl createUserActionTranslator = new CreateUserActionTranslatorImpl();
		ReceiveCreatedUserAction action = createUserActionTranslator.translateToAction(json);
	
		//NOTE: Rework ReceiveCreatedUserEvent so that it doesn't have a container.
		ReceiveCreatedUserEvent event = new ReceiveCreatedUserEvent(action);
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
		//InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		//InvalidLoginEvent ile = new InvalidLoginEvent(ila);

		InvalidAction ia = new InvalidAction(sb.toString());
		InvalidEvent ie = new InvalidEvent(ia);
		eventBus.fireEvent(ie);
	}

}
