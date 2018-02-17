package org.dselent.course_load_scheduler.client.presenter;


public interface CreateScheduleVisualPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void updateGrid();
	void fireCreateScheduleSelectFaculty(); 
}
