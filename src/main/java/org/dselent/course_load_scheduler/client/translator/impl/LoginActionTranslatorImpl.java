package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLoginKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendLoginKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class LoginActionTranslatorImpl implements ActionTranslator<SendLoginAction, ReceiveLoginAction>
{
	@Override
	public JSONObject translateToJson(SendLoginAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendLoginKeys.USER_NAME), action.getUserName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendLoginKeys.PASSWORD), action.getPassword());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveLoginAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		Integer usersId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_ID));
		String usersWpiId = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_WPI_ID));
		String usersUserName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_USER_NAME));
		String usersFirstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_FIRST_NAME));
		String usersLastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_LAST_NAME));
		String usersEmail = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_EMAIL));
		String usersAccountState = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_ACCOUNT_STATE));
		Long usersCreatedAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_CREATED_AT));
		Long usersUpdatedAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USERS_UPDATED_AT));
		
		Integer facultyId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.FACULTY_ID));
		
		Integer userRolesId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USER_ROLES_ID));
		String userRolesRoleName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USER_ROLES_ROLE_NAME));
				
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

		ReceiveLoginAction action = new ReceiveLoginAction(userInfo);	
	
		return action;
	}
}
