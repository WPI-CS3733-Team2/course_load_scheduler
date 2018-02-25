package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.User;

import java.util.ArrayList;
import java.util.List;

public class ConfirmSchedulePageAction {
	private List<Course> courses = new ArrayList<Course>();
	private User user;
	private Integer facultyId;
	
	
	public ConfirmSchedulePageAction(List<Course> courses, User user, Integer facultyId) {
		this.courses = courses;
		this.user = user;
		this.facultyId = facultyId;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public User getUser() {
		return user;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	@Override
	public String toString() {
		return "ConfirmSchedulePageAction [courses=" + courses + ", user=" + user + ", facultyId=" + facultyId + "]";
	}

}
