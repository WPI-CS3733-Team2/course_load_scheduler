package org.dselent.course_load_scheduler.client.action;

import java.util.List;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class ReceiveCourseNumberAction extends Action
{
	private List<String> courseNumbers;
	
	public ReceiveCourseNumberAction(List<String> courseNumbers)
	{
		this.courseNumbers = courseNumbers;
	}
	
	public List<String> getCourseNumbers()
	{
		return courseNumbers;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(courseNumbers);
		sb.append("\n");
		
		return sb.toString();
	}
}
