package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLoginKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendLoginKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendRegisterKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class CreateUserActionTranslatorImpl implements ActionTranslator<CreateUserAction,ReceiveCreatedUserAction>{
	
	@Override
	public JSONObject translateToJson(CreateUserAction action) {
		JSONObject jsonObject = new JSONObject();
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.WPI_ID), Integer.toString(action.getWpiId()));
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.USER_NAME), action.getUserName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.FIRST_NAME), action.getFirstName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.LAST_NAME), action.getLastName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.EMAIL), action.getEmail());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.PASSWORD), "password");
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.ROLE_ID), action.getUserRole());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.RANK), 1);
		return jsonObject;
	}
	
	@Override
	public ReceiveCreatedUserAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		ReceiveCreatedUserAction action = new ReceiveCreatedUserAction();
		
		return action;
	}

}
