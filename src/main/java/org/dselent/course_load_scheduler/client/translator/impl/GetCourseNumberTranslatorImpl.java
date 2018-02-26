package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.GetCourseNumberAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCourseNumberAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class GetCourseNumberTranslatorImpl implements ActionTranslator<GetCourseNumberAction, ReceiveCourseNumberAction>
{
	@Override
	public JSONObject translateToJson(GetCourseNumberAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		return jsonObject;
	}
	
	@Override
	public ReceiveCourseNumberAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		List<String> courseNumbers = new ArrayList<>();
		
		JSONValue jsonObject = json.get("success");
		
		for(int i = 0; i < jsonObject.isArray().size(); i++) {
			String courseNumber = jsonObject.isArray().get(i).toString();
			courseNumber = courseNumber.substring(1, courseNumber.length()-1);

			courseNumbers.add(courseNumber);
		}
		
		// possibly use builder pattern if it is a lot of data
		ReceiveCourseNumberAction action = new ReceiveCourseNumberAction(courseNumbers);	
	
		return action;
		
	}


}
