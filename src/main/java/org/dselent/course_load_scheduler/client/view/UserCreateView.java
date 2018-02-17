package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface UserCreateView extends BaseView<UserCreatePresenter>{
	TextBox getWpiIdBox();
	TextBox getUsernameBox();
	TextBox getFirstNameBox();
	TextBox getLastNameBox();
	TextBox getEmailBox();
	ListBox getUserRole();
	Button getFinalizeCreateButton();
	void showErrorMessages(String errorMessages);
}
