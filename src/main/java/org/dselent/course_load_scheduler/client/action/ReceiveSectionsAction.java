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
public class ReceiveSectionsAction extends Action
{
	private List<Section> sections;
	
	public ReceiveSectionsAction()
	{
		sections = new ArrayList<>();
	}
	
	public ReceiveSectionsAction(List<Section> sections)
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
		
		for(Section section : sections)
		{
			sb.append(section);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
