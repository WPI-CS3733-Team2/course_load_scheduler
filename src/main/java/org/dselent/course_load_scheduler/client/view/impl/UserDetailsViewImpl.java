package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.UserDetailsPresenter;
import org.dselent.course_load_scheduler.client.view.UserDetailsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;

public class UserDetailsViewImpl extends BaseViewImpl<UserDetailsPresenter> implements UserDetailsView {

	private static UserDetailsViewImplUiBinder uiBinder = GWT.create(UserDetailsViewImplUiBinder.class);
	@UiField VerticalPanel userDetailsPanel;
	@UiField Label userDetailsLabel;
	@UiField Button returnToSearchButton;
	@UiField Button terminateAccountButton;
	@UiField TextBox wpiIdBox;
	@UiField Label wpiIdLabel;
	@UiField Label userNameLabel;
	@UiField TextBox userNameBox;
	@UiField Label firstNameLabel;
	@UiField TextBox firstNameBox;
	@UiField Label userRoleLabel;
	@UiField TextBox userRoleBox;
	@UiField Label lastNameLabel;
	@UiField TextBox lastNameBox;
	@UiField Label emailLabel;
	@UiField TextBox emailBox;
	@UiField Label accountStateLabel;
	@UiField TextBox accountStateBox;
	@UiField Label userIDLabel;
	@UiField TextBox userIdBox;

	interface UserDetailsViewImplUiBinder extends UiBinder<Widget, UserDetailsViewImpl> {
	}

	public UserDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public Button getTerminateAccountButton() {
		return terminateAccountButton;
	}
	
	@Override
	public TextBox getUserIdBox() {
		return userIdBox;
	}
	
	@Override
	public TextBox getWpiIdBox() {
		return wpiIdBox;
	}
	
	@Override
	public TextBox getUserNameBox() {
		return userNameBox;
	}
	
	@Override
	public TextBox getFirstNameBox() {
		return firstNameBox;
	}
	
	@Override
	public TextBox getLastNameBox() {
		return lastNameBox;
	}
	
	@Override
	public TextBox getEmailBox() {
		return emailBox;
	}
	
	@Override
	public TextBox getAccountStateBox() {
		return accountStateBox;
	}
	
	@Override
	public TextBox getUserRoleBox() {
		return userRoleBox;
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public void setPresenter(UserDetailsPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return userDetailsPanel;
	}

	@UiHandler("returnToSearchButton")
	void onReturnToSearchButtonClick(ClickEvent event) {
		presenter.backToSearch();
	}
	@UiHandler("terminateAccountButton")
	void onTerminateAccountButtonClick(ClickEvent event) {
		presenter.terminateAccount();
	}
}
