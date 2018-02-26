package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.action.SendRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.model.RequestInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceivePendingRequestListKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendRequestsDetailsActionTranslatorImpl implements ActionTranslator<SendRequestsDetailsAction, ReceiveRequestsDetailsAction>{

	@Override
	public JSONObject translateToJson(SendRequestsDetailsAction object)
	{
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveRequestsDetailsAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONArray requestInfoListObject = jsonObject.isArray().get(0).isArray();
		List<RequestInfo> requestInfoList = new ArrayList<RequestInfo>();
		Integer jsonSize = requestInfoListObject.size();
		for (int i = 0; i < jsonSize; i++) {
			JSONObject requestInfoObject = JSONHelper.getObjectValue(requestInfoListObject.get(i).isObject());
			
			JSONObject requestObject = requestInfoObject.get("value1").isObject();
			Integer id = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.ID));
			Integer facultyId = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.FACULTY_ID));
			Integer state = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.STATE));
			Integer type = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.TYPE));
			Integer course = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.COURSE));
			Integer section = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.SECTION));
			String data = JSONHelper.getStringValue(requestObject, JSONHelper.convertKeyName(ReceivePendingRequestListKeys.DATA));			
			
			String fullName = JSONHelper.getStringValue(requestInfoObject.get("value2"));
			String courseNumber = JSONHelper.getStringValue(requestInfoObject.get("value3"));
			
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
			
			RequestInfo requestInfo = new RequestInfo();
			requestInfo.setRequest(r);
			requestInfo.setFullName(fullName);
			requestInfo.setCourseNumber(courseNumber);
			
			requestInfoList.add(requestInfo);
		}
		ReceiveRequestsDetailsAction action = new ReceiveRequestsDetailsAction(requestInfoList);
		return action;
	}

}
