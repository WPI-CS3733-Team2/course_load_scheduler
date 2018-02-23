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
public class ViewSectionAction extends Action
{
	private List<Course> courses;
	
	public ViewSectionAction()
	{
		courses = new ArrayList<>();
	}
	
	public ViewSectionAction(List<Course> courses)
	{
		this.courses = courses;
	}

	public boolean addCourses(List<Course> courses)
	{
		return this.courses.addAll(courses);
	}
	
	public void addCourse(Course course)
	{
		courses.add(course);
	}
	
	public Course getCourse(int index)
	{
		return courses.get(index);
	}
	
	public List<Course> getAllCourses()
	{
		return courses;
	}
	
	public int getNumberOfCourses()
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
