package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.view.ChangePasswordView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ChangePasswordViewImpl extends BaseViewImpl<ChangePasswordPresenter> implements ChangePasswordView{

	private static ChangePasswordViewImplUiBinder uiBinder = GWT.create(ChangePasswordViewImplUiBinder.class);

	interface ChangePasswordViewImplUiBinder extends UiBinder<Widget, ChangePasswordViewImpl> {}
	
	@UiField
	DialogBox changePasswordDialogBox;
	
	@UiField
	Label currentPasswordLabel;
	
	@UiField
	TextBox currentPasswordTextBox;
	
	@UiField
	TextBox newPasswordTextBox;
	
	@UiField
	TextBox confirmPasswordTextBox;
	
	@UiField
	Button confirmChangePasswordButton;
	
	@UiField
	Button backButton;
	
	@UiField 
	PopupPanel changePasswordPopupPanel;

	private ChangePasswordPresenter presenter;
	
	public ChangePasswordViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
		
	@Override
	public void setPresenter(ChangePasswordPresenter presenter) {
		this.presenter = presenter;
	}


	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return changePasswordPopupPanel;
	}

	@Override
	public PopupPanel getChangePasswordPopupPanel() {
		return changePasswordPopupPanel;
	}
	
	@Override
	public TextBox getCurrentPasswordTextBox() {
		return currentPasswordTextBox;
	}

	@Override
	public void setCurrentPasswordTextBox(TextBox currentPasswordTextBox) {
		this.currentPasswordTextBox = currentPasswordTextBox;
	}

	@Override
	public TextBox getNewPasswordTextBox() {
		return newPasswordTextBox;
	}

	@Override
	public void setNewPasswordTextBox(TextBox newPasswordTextBox) {
		this.newPasswordTextBox = newPasswordTextBox;
		
	}

	@Override
	public TextBox getConfirmPasswordTextBox() {
		return confirmPasswordTextBox;
	}

	@Override
	public void setConfirmPasswordTextBox(TextBox confirmPasswordTextBox) {
		this.confirmPasswordTextBox = confirmPasswordTextBox;
		
	}

	@Override
	public Button getConfirmChangePasswordButton() {
		return confirmChangePasswordButton;
	}
	
	@Override
	public Button getBackButton() {
		return backButton;
	}
	
	@Override
	public void hideWindow() {
		if (this.changePasswordPopupPanel.isShowing()){
			changePasswordPopupPanel.hide();
		}
	}
	
	@Override
	public void showWindow() {
		if (!this.changePasswordPopupPanel.isShowing()) {
			changePasswordPopupPanel.show();
		}
	}
	
	@Override
	public void showErrorMessages(String errorMessages) {
		Window.alert(errorMessages);
	}
	
	@UiHandler("confirmChangePasswordButton")
	void confirmChangePasswordButton(ClickEvent evt)
	{
		presenter.requestChangePassword();
	}
	
	@UiHandler("backButton")
	void onbackButtonClick(ClickEvent event) {
		presenter.goBack();
	}

}
