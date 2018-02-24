package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.TerminateAccountAction;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendTerminateAccountKeys;
import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveTerminatedAccountAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class TerminateAccountActionTranslatorImpl implements ActionTranslator<TerminateAccountAction,ReceiveTerminatedAccountAction>{
	@Override
	public JSONObject translateToJson(TerminateAccountAction action) {
		JSONObject jsonObject = new JSONObject();
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendTerminateAccountKeys.ID), (action.getUserId()));
		return jsonObject;
	}
	
	@Override
	public ReceiveTerminatedAccountAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		//JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		ReceiveTerminatedAccountAction action = new ReceiveTerminatedAccountAction();
		
		return action;
	}
}
