package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveUserSearchResultsAction;
import org.dselent.course_load_scheduler.client.action.InvalidAction;
import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreatedUserEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveUserSearchResultsEvent;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEvent;
import org.dselent.course_load_scheduler.client.translator.impl.CreateUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SearchUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SearchUserCallback extends Callback<JSONValue>{
	public SearchUserCallback(SimpleEventBus eventBus)
	 {
		super(eventBus);
	 }
	
	@Override
	public void onSuccess(JSONValue result)
	{
		System.out.println("onSuccess");
		JSONObject json = JSONHelper.getObjectValue(result);
		System.out.println(json.toString());
		SearchUserActionTranslatorImpl searchUserActionTranslator = new SearchUserActionTranslatorImpl();
		ReceiveUserSearchResultsAction action = searchUserActionTranslator.translateToAction(json);
	
		ReceiveUserSearchResultsEvent event = new ReceiveUserSearchResultsEvent(action);
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
		InvalidAction ia = new InvalidAction(caught.getMessage());
		InvalidEvent ie = new InvalidEvent(ia);
		eventBus.fireEvent(ie);
	}
}
