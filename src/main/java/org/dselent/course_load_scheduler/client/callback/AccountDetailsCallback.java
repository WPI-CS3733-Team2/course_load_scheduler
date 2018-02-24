package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidAccountDetailsAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event.InvalidAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.translator.impl.LoginActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class AccountDetailsCallback extends DisplayCallback<JSONValue>
{
	public AccountDetailsCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		try
		{
			JSONObject json = JSONHelper.getObjectValue(result);
			LoginActionTranslatorImpl loginActionTranslator = new LoginActionTranslatorImpl();
			ReceiveLoginAction action = loginActionTranslator.translateToAction(json);
			
			// update global user information
			GlobalData globalData = Injector.INSTANCE.getGlobalData();
			globalData.setUserInfo(action.getUserInfo());
	
			ReceiveLoginEvent event = new ReceiveLoginEvent(action, getContainer());
			eventBus.fireEvent(event);
		}
		catch(Throwable caught)
		{
			Window.alert(caught.getMessage());
		}
	}
  
	@Override
	public void onFailure(Throwable caught)
	{
		StringBuilder sb = new StringBuilder();

		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}

		InvalidAccountDetailsAction iada = new InvalidAccountDetailsAction(sb.toString());
		InvalidAccountDetailsEvent iade = new InvalidAccountDetailsEvent(iada);
		eventBus.fireEvent(iade);
	}
	
}