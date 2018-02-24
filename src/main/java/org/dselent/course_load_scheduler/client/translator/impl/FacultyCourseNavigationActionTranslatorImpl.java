package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.FacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.action.ReceiveFacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.model.FacultyCourse;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLoginKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendFacultyCourseNavigationKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class FacultyCourseNavigationActionTranslatorImpl implements ActionTranslator<FacultyCourseNavigationAction, ReceiveFacultyCourseNavigationAction>
{
	@Override
	public JSONObject translateToJson(FacultyCourseNavigationAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendFacultyCourseNavigationKeys.TEST), action.getTest());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveFacultyCourseNavigationAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		List<FacultyCourse> facultyCourseList = new ArrayList();
		
		JSONArray facultyCourseArray = jsonObject.isArray();
		for (int i = 0; i < facultyCourseArray.size(); i++) {
			JSONObject object = facultyCourseArray.get(i).isObject();
			String firstName = object.get("value1").toString().replace("\"", "");
			String lastName = object.get("value2").toString().replace("\"", "");
			String courseAssignment = object.get("value3").toString().replace("\"", "");
			FacultyCourse facultyCourse = new FacultyCourse();
			facultyCourse.setFirstName(firstName);
			facultyCourse.setLastName(lastName);
			facultyCourse.setCourseAssignment(courseAssignment);
			facultyCourseList.add(facultyCourse);
		}
		
		// possibly use builder pattern if it is a lot of data
		ReceiveFacultyCourseNavigationAction action = new ReceiveFacultyCourseNavigationAction(facultyCourseList);	
	
		return action;
	}


}
