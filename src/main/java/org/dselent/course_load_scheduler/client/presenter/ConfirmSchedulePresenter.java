package org.dselent.course_load_scheduler.client.presenter;

public interface ConfirmSchedulePresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void createSchedule();
}
