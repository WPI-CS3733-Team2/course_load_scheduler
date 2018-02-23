package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveSectionsAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.ViewSectionKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class FacultySectionTranslatorImpl implements ActionTranslator<ViewSectionAction, ReceiveSectionsAction>
{
	@Override
	public JSONObject translateToJson(ViewSectionAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		List<Course> courses = action.getAllCourses();
		String jsonString = "[" + courses.get(0).getId();
		
		for(int i = 1; i < courses.size(); i++) {
			jsonString += ", " + courses.get(i).getId();	
		}
		
		jsonString += "]";
		
		JSONValue obj = JSONParser.parseLenient(jsonString);
		
		//JSONHelper.putArrayValue(jsonObject, JSONHelper.convertKeyName(ViewSectionKeys.COURSE_IDS), obj);
		jsonObject.put(JSONHelper.convertKeyName(ViewSectionKeys.COURSE_IDS), obj);
		
		return jsonObject;
	}
	
	@Override
	public ReceiveSectionsAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		List<Section> sections = new ArrayList<>();
		
		JSONValue jsonObject = json.get("success");
		
		for(int i = 0; i < jsonObject.isArray().size(); i++) {
			JSONObject sectionObject = jsonObject.isArray().get(i).isObject();

			int id = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.ID));
			String name = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.NAME));
			String type = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.TYPE));
			int crn = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.CRN));
			int expectedPop = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.EXPECTED_POPULATION));
			int courseId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.COURSE_ID));
			int calendarId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.CALENDAR_ID));
			int scheduleId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.SCHEDULE_ID));
			
			Section section = new Section();
			section.setId(id);
			section.setSectionName(name);
			section.setType(type);
			section.setCrn(crn);
			section.setExpectedPopulation(expectedPop);
			section.setCourseId(courseId);
			section.setCalendarId(calendarId);
			section.setScheduleId(scheduleId);
			
			sections.add(section);
		}
		// possibly use builder pattern if it is a lot of data
		ReceiveSectionsAction action = new ReceiveSectionsAction(sections);	
	
		return action;
	}


}
