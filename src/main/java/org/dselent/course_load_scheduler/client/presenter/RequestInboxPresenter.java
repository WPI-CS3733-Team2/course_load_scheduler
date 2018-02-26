package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.event.ReceiveChangeRequestStateEvent;

public interface RequestInboxPresenter extends BasePresenter{

	IndexPresenter getParentPresenter();

	void setParentPresenter(IndexPresenter parentPresenter);

	void onClickChangeStateButton(int stateNum);

	void onReceiveChangeRequestState(ReceiveChangeRequestStateEvent evt);

}
