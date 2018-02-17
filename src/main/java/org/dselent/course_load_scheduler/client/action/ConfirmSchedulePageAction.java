package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.FacultyCourse;
import java.util.List;

public class ConfirmSchedulePageAction {
	private List<Course> courses;
	//private FacultyCourse facultyCourse;
	
	public ConfirmSchedulePageAction(List<Course> courses) {
		this.courses = courses;
		//this.facultyCourse = new FacultyCourse();
	}
	
	public List<Course> getCourses() {
		return courses;
	}
}
