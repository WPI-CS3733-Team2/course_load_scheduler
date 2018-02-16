package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface AccountDetailsView extends BaseView<AccountDetailsPresenter>{

	Button getChangePasswordButton();

	void showErrorMessage(String msg);
}