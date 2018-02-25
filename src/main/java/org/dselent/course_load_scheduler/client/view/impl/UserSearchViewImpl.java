package org.dselent.course_load_scheduler.client.view.impl;

//import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.view.UserSearchView;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.ScrollPanel;

public class UserSearchViewImpl extends BaseViewImpl<UserSearchPresenter> implements UserSearchView{
	private static UserSearchViewUiBinder uiBinder = GWT.create(UserSearchViewUiBinder.class);
	@UiField VerticalPanel searchPanel;
	@UiField Label viewUsersLabel;
	@UiField HorizontalPanel searchBarPanel;
	@UiField TextBox searchUserBox;
	@UiField Button searchUser;
	@UiField Label searchByLabel;
	@UiField ListBox searchByListBox;
	@UiField Button createUser;
	@UiField CellTable<UserInfo> userTable;
	@UiField ScrollPanel userScroll;
	
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
	
	@Override
	public ListBox getSearchBy(){
		return searchByListBox;
	}
	
	@Override
	public CellTable<UserInfo> getUserTable(){
		return userTable;
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
	
	@UiHandler("searchUser")
	void onReturnToSearchButtonClick(ClickEvent event) {
		presenter.searchUser();
	}
	@UiHandler("createUser")
	void onCreateUserButtonClick(ClickEvent event) {
		presenter.toCreateUsers();
	}
	
	//Shows search results
	public void initColumns() {
		TextColumn<UserInfo> userNameColumn = new TextColumn<UserInfo>() {
			@Override
			public String getValue(UserInfo userInfo) {
				return userInfo.getUsersUserName();
			}
		};
		userNameColumn.setSortable(true);
		this.userTable.addColumn(userNameColumn, "Name");
		ButtonCell buttonCell = new ButtonCell();
		Column<UserInfo, String> buttonColumn = new Column<UserInfo, String>(buttonCell) {
		  @Override
		  public String getValue(UserInfo userInfo) {
		    return "Select";
		  }
		};
		buttonColumn.setFieldUpdater(new FieldUpdater<UserInfo, String>() {
	        @Override
	        public void update(int index, UserInfo user, String value) {
	            onSelectClicked(index);
	        }
	    });
		this.userTable.addColumn(buttonColumn, "View Details");
	}
	
	//Navigates to appropriate user details page
	public void onSelectClicked(int index) {
		//int size = presenter.getUsers().size();
		UserInfo userInfo = presenter.getUsers().get(index);
		presenter.viewUserDetails(userInfo);
	}
}
