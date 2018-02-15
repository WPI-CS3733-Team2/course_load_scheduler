package org.dselent.course_load_scheduler.client.presenter;

public interface UserSearchPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void searchUser();
	public void toCreateUsers();
}
