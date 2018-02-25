package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;

public interface UserSearchView extends BaseView<UserSearchPresenter> {
	TextBox getSearchUserBox();
	void setSearchUserBox(TextBox searchUserBox);
	Button getSearchUserButton();
	void showErrorMessages(String errorMessages);
	ListBox getSearchBy();
	CellTable<UserInfo> getUserTable();
	//void setScheduleTable(CellTable<User> userTable);
	void initColumns();
	/*private static UserSearchViewUiBinder uiBinder = GWT.create(UserSearchViewUiBinder.class);
	@UiField Button searchUser;
	@UiField TextBox searchUserBox;

	interface UserSearchViewUiBinder extends UiBinder<Widget, UserSearchView> {
	}

	public UserSearchView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("searchUser")
	void onSearchUserClick(ClickEvent event) {
	}*/
}
