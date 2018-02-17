package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import com.google.gwt.user.client.ui.Button;

public interface AccountDetailsView extends BaseView<AccountDetailsPresenter>{

	Button getChangePasswordButton();

	void showErrorMessage(String msg);

	void setUserName(String username);

	void setWpiIdInChar(String wpiIdNumber);

	void setFirstName(String firstName);

	void setLastName(String lastName);

	void setAccountState(int acctStateInt);
	
	void setAccountType(String acctType);

	void setEmail(String email);
}
