package org.dselent.course_load_scheduler.client.view.impl;

//import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.view.UserSearchView;

import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class UserSearchViewImpl extends BaseViewImpl<UserSearchPresenter> implements UserSearchView{
	private static UserSearchViewUiBinder uiBinder = GWT.create(UserSearchViewUiBinder.class);
	@UiField Button searchUser;
	@UiField TextBox searchUserBox;
	@UiField VerticalPanel searchPanel;
	@UiField HorizontalPanel searchBarPanel;
	@UiField Button createUser;
	@UiField Label viewUsersLabel;

	interface UserSearchViewUiBinder extends UiBinder<Widget, UserSearchViewImpl> {
	}

	public UserSearchViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public TextBox getSearchUserBox()
	{
		return searchUserBox;
	}

	@Override
	public void setSearchUserBox(TextBox searchUserBox)
	{
		this.searchUserBox = searchUserBox;
	}
	
	@Override
	public Button getSearchUserButton()
	{
		return searchUser;
	}

	//Starts user search
	@UiHandler("searchUser")
	void onSearchUserClick(ClickEvent event) {
		presenter.searchUser();
	}
	
	@Override
	public void setPresenter(UserSearchPresenter presenter)
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
		return searchPanel;
	}
	@UiHandler("createUser")
	void onCreateUserClick(ClickEvent event) {
		presenter.toCreateUsers();
	}
}
