package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.view.UserCreateView;

import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Hyperlink;

public class UserCreateViewImpl extends BaseViewImpl<UserCreatePresenter> implements UserCreateView{

	private static UserCreateViewImplUiBinder uiBinder = GWT.create(UserCreateViewImplUiBinder.class);
	@UiField VerticalPanel createPanel;
	@UiField Grid createUserGrid;
	@UiField Label userRoleLabel;
	@UiField Label wpiIdLabel;
	@UiField Label usernameLabel;
	@UiField TextBox firstNameBox;
	@UiField Label firstNameLabel;
	@UiField TextBox lastNameBox;
	@UiField Label lastNameLabel;
	@UiField TextBox emailBox;
	@UiField Label emailLabel;
	@UiField Button finalizeCreateButton;
	@UiField Button returnToSearchButton;
	@UiField ListBox userRoleList;
	@UiField TextBox usernameBox;
	@UiField TextBox wpiIdBox;

	interface UserCreateViewImplUiBinder extends UiBinder<Widget, UserCreateViewImpl> {
	}

	public UserCreateViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public ListBox getUserRole(){
		return userRoleList;
	}
	
	@Override
	public TextBox getWpiIdBox()
	{
		return wpiIdBox;
	}
	
	@Override
	public TextBox getUsernameBox()
	{
		return usernameBox;
	}
	
	@Override
	public TextBox getFirstNameBox()
	{
		return firstNameBox;
	}
	
	@Override
	public TextBox getLastNameBox()
	{
		return lastNameBox;
	}
	
	@Override
	public TextBox getEmailBox()
	{
		return emailBox;
	}
	
	@Override
	public Button getFinalizeCreateButton()
	{
		return finalizeCreateButton;
	}

	@UiHandler("finalizeCreateButton")
	void onFinalizeCreateButtonClick(ClickEvent event) {
		presenter.createUser();
	}
	
	@Override
	public void setPresenter(UserCreatePresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return createPanel;
	}
	@UiHandler("returnToSearchButton")
	void onReturnToSearchButtonClick(ClickEvent event) {
		presenter.backToSearch();
	}
}
