package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class ReceiveAddCourseAction extends Action
{
	private Course course;
	
	public ReceiveAddCourseAction(Course course)
	{
		this.course = course;
	}
	
	public Course getCourse()
	{
		return course;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(course);
		sb.append("\n");
		
		return sb.toString();
	}
}
