package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveCreateRequestAction;
import org.dselent.course_load_scheduler.client.action.SendCreateRequestAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendChangeRequestStateKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendCreateRequestKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class SendCreateRequestActionTranslatorImpl implements ActionTranslator<SendCreateRequestAction, ReceiveCreateRequestAction>
{

	@Override
	public JSONObject translateToJson(SendCreateRequestAction action) {
		JSONObject jsonObject = new JSONObject();
		Request request = action.getRequest();
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendCreateRequestKeys.FACULTY_ID), request.getFacultyId());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendCreateRequestKeys.REQUEST_TYPE), request.getType());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendCreateRequestKeys.COURSE_ID), request.getCourse());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendCreateRequestKeys.SECTION_ID), request.getSection());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendCreateRequestKeys.DATA), request.getData());
		return jsonObject;
	}

	@Override
	public ReceiveCreateRequestAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONValue requestValue = jsonObject.isArray().get(0).isArray().get(0);
		Integer rowsAffected = Integer.parseInt(requestValue.toString());

		ReceiveCreateRequestAction action = new ReceiveCreateRequestAction(rowsAffected);
		return action;
	}

}
