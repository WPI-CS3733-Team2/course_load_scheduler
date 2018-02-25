package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.ReceiveAddCourseAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.send.jsonkeys.AddCourseKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class AddCourseTranslatorImpl implements ActionTranslator<AddCourseAction, ReceiveAddCourseAction>
{
	@Override
	public JSONObject translateToJson(AddCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		Course course = action.getCourse();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.NAME), course.getCourseName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.NUMBER), course.getCourseNumber());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.FREQUENCY), course.getFrequency());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveAddCourseAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonValue = json.get("success");
		JSONObject jsonObject = jsonValue.isArray().get(0).isObject();
		
		int id = JSONHelper.getIntValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.ID));
		String name = JSONHelper.getStringValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.NAME));
		String number = JSONHelper.getStringValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.NUMBER));
		int freq = JSONHelper.getIntValue(jsonObject, JSONHelper.convertKeyName(AddCourseKeys.FREQUENCY));
		
		Course course = new Course();
		course.setId(id);
		course.setCourseName(name);
		course.setCourseNumber(number);
		course.setFrequency(freq);
		
		// possibly use builder pattern if it is a lot of data
		ReceiveAddCourseAction action = new ReceiveAddCourseAction(course);	
	
		return action;
	}


}
