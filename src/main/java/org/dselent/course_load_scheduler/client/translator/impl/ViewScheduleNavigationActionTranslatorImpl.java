package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.ViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendScheduleListKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ViewScheduleNavigationActionTranslatorImpl implements ActionTranslator<ViewScheduleNavigationAction, ReceiveViewScheduleNavigationAction>
{
	@Override
	public JSONObject translateToJson(ViewScheduleNavigationAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendScheduleListKeys.SEARCH_BY), action.getSearchBy());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendScheduleListKeys.SEARCH_TERM), action.getSearchTerm());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveViewScheduleNavigationAction translateToAction(JSONObject json)
	{		
		
		JSONValue jsonObject = json.get("success");
		List<Schedule> scheduleList = new ArrayList();
		
		JSONArray scheduleArray = jsonObject.isArray();
		for (int i = 0; i < scheduleArray.size(); i++) {
			JSONObject object = scheduleArray.get(i).isObject();
			Integer id = Integer.parseInt(object.get("id").toString().replace("\"", ""));
			Integer facultyId = Integer.parseInt(object.get("facultyId").toString().replace("\"", ""));
			String scheduleName = object.get("scheduleName").toString().replace("\"", "");
			Schedule schedule = new Schedule();
			schedule.setId(id);
			schedule.setFacultyId(facultyId);
			schedule.setScheduleName(scheduleName);
			scheduleList.add(schedule);
		}
		// possibly use builder pattern if it is a lot of data
		ReceiveViewScheduleNavigationAction action = new ReceiveViewScheduleNavigationAction(scheduleList);	
	
		return action;
	}


}
