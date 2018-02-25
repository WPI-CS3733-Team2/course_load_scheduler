package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectFacultyAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSelectFacultyAction;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUnassignedUserKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendGenericKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;
import org.dselent.course_load_scheduler.client.utils.Pair;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SelectFacultyTranslatorImpl implements ActionTranslator<CreateScheduleSelectFacultyAction, ReceiveSelectFacultyAction>
{
	@Override
	public JSONObject translateToJson(CreateScheduleSelectFacultyAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendGenericKeys.TEST), "");
		
		return jsonObject;
	}
	
	@Override
	public ReceiveSelectFacultyAction translateToAction(JSONObject json)
	{		

		List<Pair<User, Integer>> userFacultyPairs = new ArrayList<Pair<User, Integer>>();
		
		JSONValue jsonObject = json.get("success");
		JSONArray pairsList = jsonObject.isArray();
		for (int i = 0; i < pairsList.size(); i++) {
			JSONObject object = pairsList.get(i).isObject(); 
			JSONObject userObject = object.get("value1").isObject();
			
			Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveUnassignedUserKeys.ID));
			String userName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUnassignedUserKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUnassignedUserKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUnassignedUserKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUnassignedUserKeys.EMAIL));
			Integer userStateId = Integer.parseInt(JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUnassignedUserKeys.ACCOUNT_STATE)).replace("\"", ""));
	
			User user = new User();
			user.setId(id);
			user.setUserName(userName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setUserStateId(userStateId);
			user.setCreatedAt(new Date (0));
			user.setUpdatedAt(new Date(0));
			
			Integer facultyId = Integer.parseInt(object.get("value2").toString());
			
			Pair<User, Integer> pair = new Pair<User, Integer>(user, facultyId);
			userFacultyPairs.add(pair);
		}
		
		ReceiveSelectFacultyAction action = new ReceiveSelectFacultyAction(userFacultyPairs); 	
	
		return action; 
	}


}
