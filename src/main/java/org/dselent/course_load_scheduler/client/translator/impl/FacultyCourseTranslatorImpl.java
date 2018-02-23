package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.ViewCourseKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class FacultyCourseTranslatorImpl implements ActionTranslator<ViewCourseAction, ViewSectionAction>
{
	@Override
	public JSONObject translateToJson(ViewCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		
		if(action.getCourseName() != null && action.getCourseName() != "") {
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(ViewCourseKeys.NAME), action.getCourseName());
		}
		if(action.getCourseNumber() != null && action.getCourseNumber() != "") {
			JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(ViewCourseKeys.NUMBER), action.getCourseNumber());
		}
		if(action.getFrequency() != null && action.getFrequency() != -1) {
			JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(ViewCourseKeys.FREQUENCY), action.getFrequency());
		}
		
		System.out.println(jsonObject.toString());
		
		return jsonObject;
	}
	
	@Override
	public ViewSectionAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		List<Course> courses = new ArrayList<>();
		
		JSONValue jsonObject = json.get("success");
		
		for(int i = 0; i < jsonObject.isArray().size(); i++) {
			JSONObject courseObject = jsonObject.isArray().get(i).isObject();

			Course course = new Course();
			int id = JSONHelper.getIntValue(courseObject, JSONHelper.convertKeyName(ReceiveCoursesKeys.ID));
			String name = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveCoursesKeys.NAME));
			String number = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveCoursesKeys.NUMBER));
			int frequency = JSONHelper.getIntValue(courseObject, JSONHelper.convertKeyName(ReceiveCoursesKeys.FREQUENCY));
			
			course.setId(id);
			course.setCourseName(name);
			course.setCourseNumber(number);
			course.setFrequency(frequency);
			course.setSections(new ArrayList<Section>());
			
			courses.add(course);
		}
		// possibly use builder pattern if it is a lot of data
		ViewSectionAction action = new ViewSectionAction(courses);	
	
		return action;
	}


}
