package org.dselent.course_load_scheduler.client.presenter;

public interface RequestInboxPresenter extends BasePresenter{

	IndexPresenter getParentPresenter();

	void setParentPresenter(IndexPresenter parentPresenter);

}
