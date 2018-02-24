package org.dselent.course_load_scheduler.client.view.impl;

//import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.view.UserSearchView;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.model.User;
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

public class UserSearchViewImpl extends BaseViewImpl<UserSearchPresenter> implements UserSearchView{
	private static UserSearchViewUiBinder uiBinder = GWT.create(UserSearchViewUiBinder.class);
	@UiField Button searchUser;
	@UiField TextBox searchUserBox;
	@UiField VerticalPanel searchPanel;
	@UiField HorizontalPanel searchBarPanel;
	@UiField Button createUser;
	@UiField Label viewUsersLabel;
	@UiField Label searchByLabel;
	@UiField ListBox searchByListBox;
	@UiField CellTable<User> userTable;

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
	public CellTable<User> getUserTable(){
		return userTable;
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
	
	//Shows search results
	public void initColumns() {
		TextColumn<User> userNameColumn = new TextColumn<User>() {
			@Override
			public String getValue(User user) {
				return user.getUserName();
			}
		};
		userNameColumn.setSortable(true);
		this.userTable.addColumn(userNameColumn, "Name");
		ButtonCell buttonCell = new ButtonCell();
		Column<User, String> buttonColumn = new Column<User, String>(buttonCell) {
		  @Override
		  public String getValue(User user) {
		    return "Select";
		  }
		};
		buttonColumn.setFieldUpdater(new FieldUpdater<User, String>() {
	        @Override
	        public void update(int index, User user, String value) {
	            onSelectClicked(index);
	        }
	    });
		this.userTable.addColumn(buttonColumn, "View Details");
	}
	
	//Navigates to appropriate user details page
	public void onSelectClicked(int index) {
		int size = presenter.getUsers().size();
		User user = presenter.getUsers().get(index);
		presenter.viewUserDetails(user);
	}
}
