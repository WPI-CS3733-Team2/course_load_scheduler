package org.dselent.course_load_scheduler.client.presenter;

public interface UserDetailsPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void backToSearch(); //returns to user search page
}
