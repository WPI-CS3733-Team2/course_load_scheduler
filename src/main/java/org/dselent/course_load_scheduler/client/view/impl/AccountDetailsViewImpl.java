package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.view.AccountDetailsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

public class AccountDetailsViewImpl extends BaseViewImpl<AccountDetailsPresenter> implements AccountDetailsView{

	private static AccountDetailsViewImplUiBinder uiBinder = GWT.create(AccountDetailsViewImplUiBinder.class);

	interface AccountDetailsViewImplUiBinder extends UiBinder<Widget, AccountDetailsViewImpl> {}
	
	@UiField
	Label userNameLabel;
	
	@UiField
	Label userName;
	
	@UiField
	Label accountTypeLabel;
	
	@UiField
	Label accountType;
	
	@UiField
	Label accountStateLabel;
	
	@UiField
	Label accountState;
	
	@UiField
	Label wpiIdLabel;
	
	@UiField
	Label wpiId;
	
	@UiField
	Label nameLabel;
	
	@UiField
	Label firstName;
	
	@UiField
	Label lastName;
	
	@UiField
	Label email;
	
	@UiField
	Button toChangePasswordButton;
	
	@UiField
	VerticalPanel accountDetailsPanel;
	
	@UiField
	Image logo;
	
	public AccountDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(AccountDetailsPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return accountDetailsPanel;
	}

	@Override
	public Button getChangePasswordButton() {
		return toChangePasswordButton;
	}
	
	@Override
	public void showErrorMessage(String msg) {
		Window.alert(msg);
	}
	
	@UiHandler("toChangePasswordButton")
	void onToChangePasswordButtonClick(ClickEvent event) {
		presenter.toChangePassword();
	}
	
}
