package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;

public interface RequestInboxView extends BaseView<RequestInboxPresenter>{
	public Button getAccountButton();
	public Button getCourcesButton();
	public Button getSchedulesButton();
	public Button getUsersButton();
	public Button getApproveButton();
	public Button getInboxButton();
	public Button getDenyButton();
	public Button getDeleteButton();
}
