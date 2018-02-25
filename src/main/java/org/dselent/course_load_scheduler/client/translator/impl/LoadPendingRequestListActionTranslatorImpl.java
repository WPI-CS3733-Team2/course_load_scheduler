package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.LoadPendingRequestListAction;
import org.dselent.course_load_scheduler.client.action.ReceivePendingRequestListAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceivePendingRequestListKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class LoadPendingRequestListActionTranslatorImpl implements ActionTranslator<LoadPendingRequestListAction, ReceivePendingRequestListAction>{

	@Override
	public JSONObject translateToJson(LoadPendingRequestListAction object)
	{
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceivePendingRequestListAction translateToAction(JSONObject json)
	{		
		JSONValue jsonObject = json.get("success");
		JSONArray requestListObject = jsonObject.isArray().get(0).isArray();
		List<Request> requestList = new ArrayList<Request>();
		int jsonSize = requestListObject.size();
		for (int i = 0; i < jsonSize; i++) {
			JSONObject requestObject = JSONHelper.getObjectValue(requestListObject.get(i).isObject());
			Integer id = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.ID));
			Integer facultyId = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.FACULTY_ID));
			Integer state = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.STATE));
			Integer type = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.TYPE));
			Integer course = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.COURSE));
			Integer section = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.SECTION));
			String data = JSONHelper.getStringValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.DATA));			
			
			Request r = new Request();
			r.setId(id);
			r.setFacultyId(facultyId);
			r.setState(state);
			r.setCourse(course);
			r.setType(type);
			r.setSection(section);
			r.setData(data);
			r.setCreatedAt(null);
			r.setUpdatedAt(null);
			requestList.add(r);
		}
		ReceivePendingRequestListAction action = new ReceivePendingRequestListAction(requestList);
		return action;
	}

}
