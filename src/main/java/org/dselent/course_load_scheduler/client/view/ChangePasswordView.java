package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public interface ChangePasswordView extends BaseView<ChangePasswordPresenter>{
	TextBox getCurrentPasswordTextBox();
	void setCurrentPasswordTextBox(TextBox currentPasswordTextBox);
	TextBox getNewPasswordTextBox();
	void setNewPasswordTextBox(TextBox newPasswordTextBox);
	TextBox getConfirmPasswordTextBox();
	void setConfirmPasswordTextBox(TextBox confirmPasswordTextBox);
	Button getConfirmChangePasswordButton();
	Button getBackButton();
	void showErrorMessages(String errorMessages);
	void hideWindow();
	void showWindow();
	PopupPanel getChangePasswordPopupPanel();
}
