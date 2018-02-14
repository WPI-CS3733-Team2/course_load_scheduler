package org.dselent.course_load_scheduler.client.presenter;

public interface UserCreatePresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void backToSearch();
	void createUser();
}
