package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.CreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.SearchSpecificCourseAction;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendSearchUnassignedCoursesKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SelectCoursesTranslatorImpl implements ActionTranslator<CreateScheduleNavigationAction, ReceiveCreateScheduleNavigationAction>
{
	@Override
	public JSONObject translateToJson(CreateScheduleNavigationAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSearchUnassignedCoursesKeys.SEARCH_TERM), "");
		
		return jsonObject;
	}
	
	public JSONObject translateToJson(SearchSpecificCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSearchUnassignedCoursesKeys.SEARCH_TERM), action.getSearchTerm());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveCreateScheduleNavigationAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONArray coursesAvailable = jsonObject.isArray();
		
		List<Course> courseList = new ArrayList<Course>();
		for(int i = 0; i < coursesAvailable.isArray().size(); i++) {
			JSONObject courseObject = coursesAvailable.isArray().get(i).isObject();
			
			Course course = new Course();
			Integer courseId = Integer.parseInt(courseObject.get("id").toString().replace("\"", ""));
			String courseName = courseObject.get("courseName").toString().replace("\"", "");
			String courseNumber = courseObject.get("courseNumber").toString().replace("\"", "");
			Integer frequency = Integer.parseInt(courseObject.get("frequency").toString().replace("\"", ""));
			JSONArray sectionsOfCourse = JSONHelper.getArrayValue(courseObject.get("sectionsOfCourse"));

			List<Section> sectionsList = new ArrayList<Section>();
			
			for(int j = 0; j < sectionsOfCourse.isArray().size(); j++) {
				JSONObject sectionObject = sectionsOfCourse.isArray().get(j).isObject();
				
				Section section= new Section();
				Integer sectionId = Integer.parseInt(sectionObject.get("id").toString().replace("\"", ""));
				String sectionName = sectionObject.get("name").toString().replace("\"", "");
				String type = sectionObject.get("type").toString().replace("\"", "");
				Integer expected_population = Integer.parseInt(sectionObject.get("expected_population").toString().replace("\"", ""));
				JSONObject calendarOfSection = JSONHelper.getObjectValue(sectionObject.get("calendar"));
				Integer crn = Integer.parseInt(sectionObject.get("crn").toString().replace("\"", ""));
				Integer calendarId = Integer.parseInt(sectionObject.get("calendarId").toString().replace("\"", ""));
				
				Calendar calendar = new Calendar();
				Integer year = Integer.parseInt(calendarOfSection.get("year").toString().replace("\"", ""));
				String semester = calendarOfSection.get("semester").toString().replace("\"", "");
				String days = calendarOfSection.get("days").toString().replace("\"", "");
				String start_time = calendarOfSection.get("start_time").toString().replace("\"", "");
				String end_time = calendarOfSection.get("end_time").toString().replace("\"", "");
				
				calendar.setId(calendarId);
				calendar.setYear(year);
				calendar.setSemester(semester);
				calendar.setDays(days);
				calendar.setStart_time(start_time);
				calendar.setEnd_time(end_time);
								
				section.setId(sectionId);
				section.setCrn(crn);
				section.setSectionName(sectionName);
				section.setType(type);
				section.setExpectedPopulation(expected_population);
				section.setCalendar(calendar);
				section.setCourseId(courseId);
				section.setCalendarId(calendarId);
				section.setScheduleId(0);
				sectionsList.add(section);
			}
			
			course.setId(courseId);
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setFrequency(frequency);
			course.setSections(sectionsList);
			courseList.add(course);
			
		}
		ReceiveCreateScheduleNavigationAction action = new ReceiveCreateScheduleNavigationAction(courseList);	
	
		return action;
	}


}
