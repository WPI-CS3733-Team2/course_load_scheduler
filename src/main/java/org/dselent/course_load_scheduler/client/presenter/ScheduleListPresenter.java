package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Schedule;

public interface ScheduleListPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	List<Schedule> getSchedules();
	void viewSpecifics(Schedule schedule);
}
