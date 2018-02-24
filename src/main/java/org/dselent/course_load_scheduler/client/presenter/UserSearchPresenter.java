package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UserInfo;

import java.util.List;

public interface UserSearchPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void searchUser();
	public void toCreateUsers();
	List<UserInfo> getUsers();
	void viewUserDetails(UserInfo userInfo);
}
