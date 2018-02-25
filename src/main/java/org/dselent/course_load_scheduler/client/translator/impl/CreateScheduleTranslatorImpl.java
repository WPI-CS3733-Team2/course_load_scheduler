package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.CreateScheduleAction;
import org.dselent.course_load_scheduler.client.action.ReceiveScheduleSpecificsAction;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveScheduleSpecificsKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendCreateScheduleKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class CreateScheduleTranslatorImpl implements ActionTranslator<CreateScheduleAction, ReceiveScheduleSpecificsAction>
{
	@Override
	public JSONObject translateToJson(CreateScheduleAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendCreateScheduleKeys.FACULTY_ID), action.getFacultyId().toString());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendCreateScheduleKeys.SCHEDULE_NAME), action.getScheduleName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendCreateScheduleKeys.SECTION_IDS), action.getSectionIds().toString());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveScheduleSpecificsAction translateToAction(JSONObject json)
	{
		
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.ID));
		String userName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.USER_NAME));
		String firstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.FIRST_NAME));
		String lastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.LAST_NAME));
		String email = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.EMAIL));
		Integer userStateId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.ACCOUNT_STATE));
		Long createdAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.CREATED_AT));
		Long updatedAt = JSONHelper.getLongValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.UPDATED_AT));
		JSONArray coursesAssigned = JSONHelper.getArrayValue(userObject, JSONHelper.convertKeyName(ReceiveScheduleSpecificsKeys.COURSES_ASSIGNED));

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
		for(int i = 0; i < coursesAssigned.isArray().size(); i++) {
			JSONObject courseObject = coursesAssigned.isArray().get(i).isObject();
			
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
				Integer scheduleId = Integer.parseInt(sectionObject.get("scheduleId").toString().replace("\"", ""));
				
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
				section.setScheduleId(scheduleId);
				sectionsList.add(section);
			}
			
			course.setId(courseId);
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setFrequency(frequency);
			course.setSections(sectionsList);
			courseList.add(course);
			
		}
		ReceiveScheduleSpecificsAction action = new ReceiveScheduleSpecificsAction(user, courseList);	
	
		return action;
	}


}