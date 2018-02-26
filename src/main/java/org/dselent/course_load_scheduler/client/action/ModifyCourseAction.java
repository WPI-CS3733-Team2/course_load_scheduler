package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;

public class ModifyCourseAction extends Action{
	private Course course;
	
	public ModifyCourseAction(Course course) {
		this.course = course;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
