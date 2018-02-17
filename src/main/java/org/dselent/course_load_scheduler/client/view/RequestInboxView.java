package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;

import com.google.gwt.user.client.ui.Button;

public interface RequestInboxView extends BaseView<RequestInboxPresenter>{
	public Button getApproveButton();
	public Button getDenyButton();
	public Button getDeleteButton();
}
