package org.dselent.course_load_scheduler.client.presenter;

public interface ChangePasswordPresenter extends BasePresenter
{
	void setParentPresenter(AccountDetailsPresenter parentPresenter);
	AccountDetailsPresenter getParentPrsenter();
	void requestChangePassword();
	void goBack();
	void showChangePasswordPopup(int userId);
	void hideChangePasswordPopup();
}
