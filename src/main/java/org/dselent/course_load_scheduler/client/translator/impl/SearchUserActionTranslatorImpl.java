package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.SearchUserAction;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendRegisterKeys;
import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreatedUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveUserSearchResultsAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserSearchResultsKeys;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SearchUserActionTranslatorImpl implements ActionTranslator<SearchUserAction,ReceiveUserSearchResultsAction>{
	
	@Override
	public JSONObject translateToJson(SearchUserAction action) {
		JSONObject jsonObject = new JSONObject();
		
		/*JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.WPI_ID), "");
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.USER_NAME), "");
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.FIRST_NAME), "");
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.LAST_NAME), "");
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.EMAIL), "");*/
		switch(action.getSearchBy()) {
		case 0:
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.WPI_ID), action.getQuery());
			break;
		case 1:
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.USER_NAME), action.getQuery());
			break;
		case 2:
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.FIRST_NAME), action.getQuery());
			break;
		case 3:
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.LAST_NAME), action.getQuery());
			break;
		case 4:
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.EMAIL), action.getQuery());
			break;
		}		
		
		return jsonObject;
	}
	
	@Override
	public ReceiveUserSearchResultsAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		//JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		List<User> userList = new ArrayList<User>();
		//Iterate through json array
		for(int i = 0;i<jsonObject.isArray().size();i++) {
			
			Integer id = JSONHelper.getIntValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_ID));
			String wpiIdString = JSONHelper.getStringValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_WPI_ID));
			String userName = JSONHelper.getStringValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_USER_NAME));
			String firstName = JSONHelper.getStringValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_FIRST_NAME));
			String lastName = JSONHelper.getStringValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_LAST_NAME));
			String email = JSONHelper.getStringValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_EMAIL));
			//String userState = JSONHelper.getStringValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USERS_ACCOUNT_STATE));
			Integer roleId = JSONHelper.getIntValue(jsonObject.isArray().get(i).isObject(), JSONHelper.convertKeyName(ReceiveUserSearchResultsKeys.USER_ROLES_ID));
			/*System.out.println("Role ID: " + roleId.toString());*/
			// TODO look into time conversion more
			// put into JSONHelper?
			
			Integer wpiId = Integer.parseInt(wpiIdString);
			
			User user = new User();
			user.setId(id);
			user.setWpiId(wpiId);
			user.setUserName(userName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			//user.setUserState(userState);
			user.setUserState("1");
			//user.setDeleted(deleted); //Commented out while the response returns null.
			user.setRoleId(roleId);
			//Temporary
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			
			userList.add(user);
		}
		
		ReceiveUserSearchResultsAction action = new ReceiveUserSearchResultsAction(userList);
		return action;
	}
}
