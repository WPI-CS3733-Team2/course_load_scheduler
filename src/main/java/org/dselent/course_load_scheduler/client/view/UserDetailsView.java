package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.UserDetailsPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface UserDetailsView extends BaseView<UserDetailsPresenter>{
	Button getTerminateAccountButton();
	TextBox getUserIdBox();
	TextBox getWpiIdBox();
	TextBox getUserNameBox();
	TextBox getFirstNameBox();
	TextBox getLastNameBox();
	TextBox getEmailBox();
	TextBox getAccountStateBox();
	TextBox getUserRoleBox();
	void showErrorMessages(String errorMessages);
}
