package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveCalendarsAction;
import org.dselent.course_load_scheduler.client.action.ViewCalendarAction;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.ViewCalendarKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class CalendarTranslatorImpl implements ActionTranslator<ViewCalendarAction, ReceiveCalendarsAction>
{
	@Override
	public JSONObject translateToJson(ViewCalendarAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		List<Section> sections = action.getAllSections();
		String jsonString = "[" + sections.get(0).getCalendarId();
		
		for(int i = 1; i < sections.size(); i++) {
			jsonString += ", " + sections.get(i).getCalendarId();	
		}
		
		jsonString += "]";
		
		JSONValue obj = JSONParser.parseLenient(jsonString);
		
		jsonObject.put(JSONHelper.convertKeyName(ViewCalendarKeys.CALENDAR_IDS), obj);
		
		return jsonObject;
	}
	
	@Override
	public ReceiveCalendarsAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		List<Calendar> calendars = new ArrayList<>();
		
		JSONValue jsonObject = json.get("success");
		
		for(int i = 0; i < jsonObject.isArray().size(); i++) {
			JSONObject calendarObject = jsonObject.isArray().get(i).isObject();

			int id = JSONHelper.getIntValue(calendarObject, JSONHelper.convertKeyName(ReceiveCalendarKeys.ID));
			int year = JSONHelper.getIntValue(calendarObject, JSONHelper.convertKeyName(ReceiveCalendarKeys.YEAR));
			String semester = JSONHelper.getStringValue(calendarObject, JSONHelper.convertKeyName(ReceiveCalendarKeys.SEMESTER));
			String days = JSONHelper.getStringValue(calendarObject, JSONHelper.convertKeyName(ReceiveCalendarKeys.DAYS));
			String startTime = JSONHelper.getStringValue(calendarObject, JSONHelper.convertKeyName(ReceiveCalendarKeys.START_TIME));
			String endTime = JSONHelper.getStringValue(calendarObject, JSONHelper.convertKeyName(ReceiveCalendarKeys.END_TIME));
			
			Calendar calendar = new Calendar();
			calendar.setId(id);
			calendar.setYear(year);
			calendar.setSemester(semester);
			calendar.setDays(days);
			calendar.setStart_time(startTime);
			calendar.setEnd_time(endTime);
			
			calendars.add(calendar);
		}
		// possibly use builder pattern if it is a lot of data
		ReceiveCalendarsAction action = new ReceiveCalendarsAction(calendars);	
	
		return action;
	}


}
