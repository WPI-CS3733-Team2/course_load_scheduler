package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.action.RemoveSectionsAction;
import org.dselent.course_load_scheduler.client.action.ReceiveRemoveSectionsAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.send.jsonkeys.RemoveSectionsKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class RemoveSectionsTranslatorImpl implements ActionTranslator<RemoveSectionsAction, ReceiveRemoveSectionsAction>
{
	@Override
	public JSONObject translateToJson(RemoveSectionsAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		List<Section> sections = action.getSections();
		String jsonString = "[" + sections.get(0).getId();
		
		for(int i = 1; i < sections.size(); i++) {
			jsonString += ", " + sections.get(i).getId();	
		}
		
		jsonString += "]";
		
		JSONValue obj = JSONParser.parseLenient(jsonString);
		
		//JSONHelper.putArrayValue(jsonObject, JSONHelper.convertKeyName(ViewSectionKeys.COURSE_IDS), obj);
		jsonObject.put(JSONHelper.convertKeyName(RemoveSectionsKeys.SECTION_IDS), obj);
		
		return jsonObject;
	}
	
	@Override
	public ReceiveRemoveSectionsAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		/*JSONValue jsonValue = json.get("success");
		JSONObject jsonObject = jsonValue.isArray().get(0).isObject();
		
		int id = JSONHelper.getIntValue(jsonObject, JSONHelper.convertKeyName(RemoveSectionsKeys.ID));
		String name = JSONHelper.getStringValue(jsonObject, JSONHelper.convertKeyName(RemoveSectionsKeys.NAME));
		String number = JSONHelper.getStringValue(jsonObject, JSONHelper.convertKeyName(RemoveSectionsKeys.NUMBER));
		int freq = JSONHelper.getIntValue(jsonObject, JSONHelper.convertKeyName(RemoveSectionsKeys.FREQUENCY));
		
		Sections course = new Sections();
		course.setId(id);
		course.setSectionsName(name);
		course.setSectionsNumber(number);
		course.setFrequency(freq);
		
		// possibly use builder pattern if it is a lot of data
*/		ReceiveRemoveSectionsAction action = new ReceiveRemoveSectionsAction();	
	
		return action;
	}


}
