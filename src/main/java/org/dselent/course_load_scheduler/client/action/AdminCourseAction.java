package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class AdminCourseAction 
{
	private List<Course> courses;
	
	public AdminCourseAction()
	{
		courses = new ArrayList<>();
	}
	
	public AdminCourseAction(List<Course> courses)
	{
		this.courses = courses;
	}

	public boolean addReasons(List<Course> courses)
	{
		return this.courses.addAll(courses);
	}
	
	public void addReason(Course course)
	{
		courses.add(course);
	}
	
	public Course getReason(int index)
	{
		return courses.get(index);
	}
	
	public int getNumberOfReasons()
	{
		return courses.size();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(Course course : courses)
		{
			sb.append(course);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
