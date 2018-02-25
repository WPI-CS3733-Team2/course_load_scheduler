package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendChangePasswordKeys;
import org.dselent.course_load_scheduler.client.translator.SendActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class ChangePasswordActionTranslatorImpl implements SendActionTranslator<SendChangePasswordAction>
{
	@Override
	public JSONObject translateToJson(SendChangePasswordAction action)
	{
		JSONObject jsonObject = new JSONObject();
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendChangePasswordKeys.ID), action.getUserId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendChangePasswordKeys.OLD_PASSWORD), action.getCurrentPassword());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendChangePasswordKeys.NEW_PASSWORD), action.getNewPassword());
		return jsonObject;
	}

}
