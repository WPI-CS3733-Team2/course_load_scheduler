package org.dselent.course_load_scheduler.client.translator.impl;


import org.dselent.course_load_scheduler.client.action.ReceiveChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.action.SendChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendChangeRequestStateKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendChangeRequestStateActionTranslatorImpl implements ActionTranslator<SendChangeRequestStateAction, ReceiveChangeRequestStateAction>
{
	@Override
	public JSONObject translateToJson(SendChangeRequestStateAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendChangeRequestStateKeys.REQUEST_ID), action.getRequestId());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendChangeRequestStateKeys.REQUEST_STATE), action.getRequestState());

		return jsonObject;
	}

	@Override
	public ReceiveChangeRequestStateAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONValue requestValue = jsonObject.isArray().get(0);
		Integer rowsAffected = Integer.parseInt(requestValue.toString());

		ReceiveChangeRequestStateAction action = new ReceiveChangeRequestStateAction(rowsAffected);
		return action;
	}

}
