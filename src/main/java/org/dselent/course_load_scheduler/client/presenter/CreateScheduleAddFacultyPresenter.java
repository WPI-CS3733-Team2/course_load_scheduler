package org.dselent.course_load_scheduler.client.presenter;


public interface CreateScheduleAddFacultyPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void fireConfirmSchedulePage();
	
}
