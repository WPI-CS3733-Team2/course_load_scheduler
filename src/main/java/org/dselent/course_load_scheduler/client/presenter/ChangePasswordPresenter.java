package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;

public interface ChangePasswordPresenter extends BasePresenter{
	public void requestChangePassword();
	public void goBack();
	int getUserId();
	void setUserId(int userId);
	void onTriggerChangePasswordWindow1(TriggerChangePasswordWindowEvent evt);
	
}
