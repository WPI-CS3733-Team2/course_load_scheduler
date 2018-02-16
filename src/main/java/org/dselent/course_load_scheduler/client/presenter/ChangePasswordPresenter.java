package org.dselent.course_load_scheduler.client.presenter;


public interface ChangePasswordPresenter extends BasePresenter{
	public void requestChangePassword();
	public void goBack();
	int getUserId();
	void setUserId(int userId);
	
}
