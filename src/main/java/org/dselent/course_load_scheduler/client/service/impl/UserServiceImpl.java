package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.event.ReceiveCreatedUserEvent;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.callback.SendLoginCallback;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.callback.CreateUserCallback;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.action.SearchUserAction;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.callback.SearchUserCallback;
import org.dselent.course_load_scheduler.client.action.TerminateAccountAction;
import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;
import org.dselent.course_load_scheduler.client.callback.TerminateAccountCallback;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.UserService;
import org.dselent.course_load_scheduler.client.translator.impl.LoginActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CreateUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SearchUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.TerminateAccountActionTranslatorImpl;


import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasWidgets;

public class UserServiceImpl extends BaseServiceImpl implements UserService
{
	public UserServiceImpl()
	{
		
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(SendLoginEvent.TYPE, this);
		eventBusRegistration.put(SendLoginEvent.TYPE, registration);
		
		registration = eventBus.addHandler(CreateUserEvent.TYPE, this);
		eventBusRegistration.put(CreateUserEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SearchUserEvent.TYPE, this);
		eventBusRegistration.put(SearchUserEvent.TYPE, registration);
		
		registration = eventBus.addHandler(TerminateAccountEvent.TYPE, this);
		eventBusRegistration.put(TerminateAccountEvent.TYPE, registration);
	}
	
	@Override
	public void onSendLogin(SendLoginEvent evt)
	{
		SendLoginAction action = evt.getAction();
		LoginActionTranslatorImpl loginActionTranslator = new LoginActionTranslatorImpl();
		JSONObject json = loginActionTranslator.translateToJson(action);
		SendLoginCallback loginCallback = new SendLoginCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.LOGIN, loginCallback, json);
		request.send();
	}
	
	@Override
	public void onCreateUser(CreateUserEvent evt) {
		System.out.println("Control; if this shows up, I know printing is working.");
		//Not only is this accessed, but the create user presenter's response to an invalid login event
		// works fine.
		/*StringBuilder sb = new StringBuilder();
		InvalidLoginAction ila = new InvalidLoginAction(sb.toString());
		InvalidLoginEvent ile = new InvalidLoginEvent(ila);
		eventBus.fireEvent(ile);*/
		//NOTE: Having a container complicates things, apparently.
		CreateUserAction action = evt.getAction();
		System.out.println(action.toString());
		CreateUserActionTranslatorImpl createUserActionTranslator = new CreateUserActionTranslatorImpl();
		JSONObject json = createUserActionTranslator.translateToJson(action);
		CreateUserCallback createUserCallback = new CreateUserCallback(eventBus);
		//CreateUserCallback createUserCallback = new CreateUserCallback(eventBus,evt.getContainer());	
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.REGISTER, createUserCallback, json);
		System.out.println("Request: " + request.toString());
		request.send();
	}
	
	@Override
	public void onSearchUser(SearchUserEvent evt) {
		SearchUserAction action = evt.getAction();
		SearchUserActionTranslatorImpl searchUserActionTranslator = new SearchUserActionTranslatorImpl();
		JSONObject json = searchUserActionTranslator.translateToJson(action);
		SearchUserCallback searchUserCallback = new SearchUserCallback(eventBus);
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.USERSEARCH, searchUserCallback, json);
		request.send();
	}
	
	@Override
	public void onTerminateAccount(TerminateAccountEvent evt) {
		TerminateAccountAction action = evt.getAction();
		TerminateAccountActionTranslatorImpl terminateAccountActionTranslator = new TerminateAccountActionTranslatorImpl();
		JSONObject json = terminateAccountActionTranslator.translateToJson(action);
		TerminateAccountCallback terminateAccountCallback = new TerminateAccountCallback(eventBus);
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.DELETEUSER, terminateAccountCallback, json);
		request.send();
	}
	
	
}
