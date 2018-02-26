package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.ReceiveModifyCourseAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.send.jsonkeys.ModifyCourseKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ModifyCourseTranslatorImpl implements ActionTranslator<ModifyCourseAction, ReceiveModifyCourseAction>
{
	@Override
	public JSONObject translateToJson(ModifyCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		Course course = action.getCourse();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(ModifyCourseKeys.ID), course.getId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(ModifyCourseKeys.NAME), course.getCourseName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(ModifyCourseKeys.NUMBER), course.getCourseNumber());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(ModifyCourseKeys.FREQUENCY), course.getFrequency());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveModifyCourseAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		int id = JSONHelper.getIntValue(json, "success");	
		
		// possibly use builder pattern if it is a lot of data
		ReceiveModifyCourseAction action = new ReceiveModifyCourseAction(id);	
	
		return action;
	}


}
