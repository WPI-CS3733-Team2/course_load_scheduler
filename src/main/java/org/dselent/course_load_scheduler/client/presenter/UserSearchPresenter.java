package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.model.User;

import java.util.List;

public interface UserSearchPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void searchUser();
	public void toCreateUsers();
	List<User> getUsers();
	void viewUserDetails(User user);
}
