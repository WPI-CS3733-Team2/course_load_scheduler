package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
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

public class SendLoginCallback extends DisplayCallback<JSONValue>
{
	public SendLoginCallback(SimpleEventBus eventBus, HasWidgets container)
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
			
			// inject global data object to be populated with the user info from the login
			GlobalData globalData = Injector.INSTANCE.getGlobalData();
			globalData.setUserInfo(action.getUserInfo());
	
			ReceiveLoginEvent event = new ReceiveLoginEvent(action, getContainer());
			eventBus.fireEvent(event);
		}
		catch(Throwable caught)
		{
			// succeeded then had an exception
			// this is more likely due to programmer error
			
			Window.alert(caught.getMessage());
		}
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

		InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		InvalidLoginEvent ile = new InvalidLoginEvent(ila);
		eventBus.fireEvent(ile);
	}
	
}