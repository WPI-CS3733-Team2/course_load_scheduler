package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.action.AddSectionsAction;
import org.dselent.course_load_scheduler.client.action.ReceiveAddSectionsAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.send.jsonkeys.AddSectionsKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.ViewSectionKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class AddSectionsTranslatorImpl implements ActionTranslator<AddSectionsAction, ReceiveAddSectionsAction>
{
	@Override
	public JSONObject translateToJson(AddSectionsAction action)
	{
JSONObject jsonObject = new JSONObject();
		
		List<Section> sections = action.getSections();
		String jsonString = "[";
		
		for(int i = 0; i < sections.size(); i++) {
			jsonString += "{\"section\":{";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.NAME);
			jsonString += ":\"" + sections.get(i).getSectionName() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.CRN);
			jsonString += ":\"" + sections.get(i).getCrn() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.TYPE);
			jsonString += ":\"" + sections.get(i).getType() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.EXPECTED_POPULATION);
			jsonString += ":\"" + sections.get(i).getExpectedPopulation() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.COURSE_ID);
			jsonString += ":\"" + sections.get(i).getCourseId() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.YEAR);
			jsonString += ":\"" + sections.get(i).getCalendar().getYear() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.SEMESTER);
			jsonString += ":\"" + sections.get(i).getCalendar().getSemester() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.DAYS);
			jsonString += ":\"" + sections.get(i).getCalendar().getDays() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.START_TIME);
			jsonString += ":\"" + sections.get(i).getCalendar().getStart_time() + "\",";
			jsonString += JSONHelper.convertKeyName(AddSectionsKeys.END_TIME);
			jsonString += ":\"" + sections.get(i).getCalendar().getEnd_time() + "\"";
			jsonString += "}}";
			if(i != sections.size() - 1) {
				jsonString += ",";
			}
		}
		
		jsonString += "]";
		
		JSONValue obj = JSONParser.parseLenient(jsonString);
		
		//JSONHelper.putArrayValue(jsonObject, JSONHelper.convertKeyName(ViewSectionKeys.COURSE_IDS), obj);
		jsonObject.put(JSONHelper.convertKeyName(AddSectionsKeys.SECTIONS), obj);
		
		return jsonObject;
	
		/*JSONObject jsonObject = new JSONObject();
		
		List<Section> sections = action.getSections();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.NAME), course.getSectionsName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.NUMBER), course.getSectionsNumber());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.FREQUENCY), course.getFrequency());
		
		return jsonObject;*/
	}
	
	@Override
	public ReceiveAddSectionsAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		/*JSONValue jsonValue = json.get("success");
		JSONObject jsonObject = jsonValue.isArray().get(0).isObject();
		
		int id = JSONHelper.getIntValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.ID));
		String name = JSONHelper.getStringValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.NAME));
		String number = JSONHelper.getStringValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.NUMBER));
		int freq = JSONHelper.getIntValue(jsonObject, JSONHelper.convertKeyName(AddSectionsKeys.FREQUENCY));
		
		Sections course = new Sections();
		course.setId(id);
		course.setSectionsName(name);
		course.setSectionsNumber(number);
		course.setFrequency(freq);
		
		// possibly use builder pattern if it is a lot of data
*/		ReceiveAddSectionsAction action = new ReceiveAddSectionsAction(null);	
	
		return action;
	}


}
