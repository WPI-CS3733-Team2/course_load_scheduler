package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Calendar;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class ReceiveCalendarsAction extends Action
{
	private List<Calendar> calendars;
	
	public ReceiveCalendarsAction()
	{
		calendars = new ArrayList<>();
	}
	
	public ReceiveCalendarsAction(List<Calendar> calendars)
	{
		this.calendars = calendars;
	}

	public boolean addCalendars(List<Calendar> calendars)
	{
		return this.calendars.addAll(calendars);
	}
	
	public void addCalendar(Calendar section)
	{
		calendars.add(section);
	}
	
	public Calendar getCalendar(int index)
	{
		return calendars.get(index);
	}
	
	public List<Calendar> getAllCalendars()
	{
		return calendars;
	}
	
	public int getNumberOfCalendars()
	{
		return calendars.size();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(Calendar section : calendars)
		{
			sb.append(section);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
