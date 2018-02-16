package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;

public interface AccountDetailsPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void toChangePassword();
}
