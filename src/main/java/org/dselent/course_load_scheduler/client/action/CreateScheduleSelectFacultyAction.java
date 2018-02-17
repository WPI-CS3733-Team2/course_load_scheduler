package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;
import java.util.List;

public class CreateScheduleSelectFacultyAction {
	private List<Course> courses;
	
	public CreateScheduleSelectFacultyAction(List<Course> courses){
		this.courses = courses;
	}
	
	public List<Course> getCourses(){
		return courses;
	}

	
}
