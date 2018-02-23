package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.ScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLoginKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveScheduleSpecificsKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendLoginKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendScheduleSpecificsKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ScheduleSpecificsTranslatorImpl implements ActionTranslator<ScheduleSpecificsAction, ReceiveLoginAction>
{
	@Override
	public JSONObject translateToJson(ScheduleSpecificsAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendScheduleSpecificsKeys.ID), action.getSchedule().getId().toString());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveScheduleSpecificsAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.ID));
		String userName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.USER_NAME));
		String firstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.FIRST_NAME));
		String lastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.LAST_NAME));
		String email = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.EMAIL));
		Integer userStateId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.USER_STATE_ID));
		Long createdAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.CREATED_AT));
		Long updatedAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.UPDATED_AT));
		List<Object> coursesAssigned = JSONHelper.getArrayValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.COURSESASSIGNED));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUserStateId(userStateId);
		user.setCreatedAt(new Date(createdAt));
		user.setUpdatedAt(new Date(updatedAt));
		
		List<Course> courseList = new ArrayList<Course>();
		
		// possibly use builder pattern if it is a lot of data
		ReceiveScheduleSpecificsAction action = new ReceiveScheduleSpecificsAction(user, courseList);	
	
		return action;
	}


}
