package org.dselent.course_load_scheduler.client.translator;

import org.dselent.course_load_scheduler.client.action.Action;
import com.google.gwt.json.client.JSONObject;

public interface SendActionTranslator<A extends Action>
{
	public JSONObject translateToJson(A object);
}

