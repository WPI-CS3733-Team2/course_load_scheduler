package org.dselent.course_load_scheduler.client.presenter;

public interface AccountDetailsPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void toChangePassword();
	String getUserType();
}
