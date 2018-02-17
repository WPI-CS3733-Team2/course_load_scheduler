package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;

public class CreateScheduleSelectCoursesAction {
	private List<Course> courses = new ArrayList<Course>();
	
	public CreateScheduleSelectCoursesAction(List<Course> courses){
		this.courses = courses;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
}
