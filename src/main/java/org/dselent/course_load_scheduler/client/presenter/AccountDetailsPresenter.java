package org.dselent.course_load_scheduler.client.presenter;

public interface AccountDetailsPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void showChangePasswordPopup();
	void hideChangePasswordPopup();
	void showLoadScreen();
	void hideLoadScreen();
	String getUserType();
}
