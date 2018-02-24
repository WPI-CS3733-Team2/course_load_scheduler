package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountDetailsAction;
import org.dselent.course_load_scheduler.client.action.SendAccountDetailsAction;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveAccountDetailsKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendAccountDetailsKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class AccountDetailsActionTranslatorImpl implements ActionTranslator<SendAccountDetailsAction, ReceiveAccountDetailsAction>
{
	@Override
	public JSONObject translateToJson(SendAccountDetailsAction action)
	{
		JSONObject jsonObject = new JSONObject();
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendAccountDetailsKeys.USER_ID), action.getUserId());
		return jsonObject;
	}
	
	@Override
	public ReceiveAccountDetailsAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isObject();
		
		Integer usersId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_ID));
		String usersWpiId = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_WPI_ID));
		String usersUserName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_USER_NAME));
		String usersFirstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_FIRST_NAME));
		String usersLastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_LAST_NAME));
		String usersEmail = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_EMAIL));
		String usersAccountState = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_ACCOUNT_STATE));
		Long usersCreatedAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_CREATED_AT));
		Long usersUpdatedAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USERS_UPDATED_AT));
		
		Integer facultyId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.FACULTY_ID));
		
		Integer userRolesId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USER_ROLES_ID));
		String userRolesRoleName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveAccountDetailsKeys.USER_ROLES_ROLE_NAME));
				
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUsersId(usersId);
		userInfo.setUsersWpiId(usersWpiId);
		userInfo.setUsersUserName(usersUserName);
		userInfo.setUsersFirstName(usersFirstName);
		userInfo.setUsersLastName(usersLastName);
		userInfo.setUsersEmail(usersEmail);
		userInfo.setUsersAccountState(usersAccountState);
		userInfo.setUsersCreatedAt(new Date(usersCreatedAt));
		userInfo.setUsersUpdatedAt(new Date(usersUpdatedAt));
		userInfo.setFacultyId(facultyId);
		userInfo.setUserRolesId(userRolesId);
		userInfo.setUserRolesRoleName(userRolesRoleName);

		ReceiveAccountDetailsAction action = new ReceiveAccountDetailsAction(userInfo);	
	
		return action;
	}
}
