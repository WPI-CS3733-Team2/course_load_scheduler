package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.utils.Pair;

public class ReceiveSelectFacultyAction extends Action{
	List<Pair<User, Integer>> userFacultyPairs;
	List<Course> courseList = new  ArrayList<Course>();
	
	public ReceiveSelectFacultyAction(List<Pair<User, Integer>> userFacultyPairs)
	{
		this.userFacultyPairs = userFacultyPairs;
	}

	public List<Pair<User, Integer>> getUserFacultyPairs() {
		return userFacultyPairs;
	}

	public void setUserFacultyPairs(List<Pair<User, Integer>> userFacultyPairs) {
		this.userFacultyPairs = userFacultyPairs;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "ReceiveSelectFacultyWithCoursesAction [userFacultyPairs=" + userFacultyPairs + ", courseList="
				+ courseList + "]";
	}


}
