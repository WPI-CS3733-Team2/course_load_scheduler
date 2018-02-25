package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;

public interface CreateSchedulePresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void goToNextPage(List<Integer> courseNames);
	void fireCreateScheduleSelectCourses(List<Course> courseList);
	void results();
}
