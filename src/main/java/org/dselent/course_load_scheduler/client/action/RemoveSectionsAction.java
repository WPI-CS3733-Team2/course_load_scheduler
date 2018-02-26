package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class RemoveSectionsAction extends Action
{
	private List<Section> sections;
	
	public RemoveSectionsAction(List<Section> sections)
	{
		this.sections = sections;
	}
	
	public List<Section> getSections()
	{
		return sections;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(sections);
		sb.append("\n");
		
		return sb.toString();
	}
}
