package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Section;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class ViewCalendarAction extends Action
{
	private List<Section> sections;
	
	public ViewCalendarAction()
	{
		sections = new ArrayList<>();
	}
	
	public ViewCalendarAction(List<Section> sections)
	{
		this.sections = sections;
	}

	public boolean addSections(List<Section> sections)
	{
		return this.sections.addAll(sections);
	}
	
	public void addSection(Section section)
	{
		sections.add(section);
	}
	
	public Section getSection(int index)
	{
		return sections.get(index);
	}
	
	public List<Section> getAllSections()
	{
		return sections;
	}
	
	public int getNumberOfSections()
	{
		return sections.size();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(Section course : sections)
		{
			sb.append(course);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
