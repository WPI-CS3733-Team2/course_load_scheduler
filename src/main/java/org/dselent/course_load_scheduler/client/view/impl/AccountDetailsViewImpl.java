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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
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
	Button changePasswordButton;
	
	@UiField
	HTMLPanel accountDetailsPanel;
	
	@UiField
	Image logo;
	
	@UiField 
	ChangePasswordViewImpl changePasswordPopupPanel;
	
	@Inject
	public AccountDetailsViewImpl(ChangePasswordViewImpl changePasswordPopupPanel)
	{
		this.changePasswordPopupPanel = changePasswordPopupPanel;
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(AccountDetailsPresenter presenter)
	{
		this.presenter = presenter;
		
	}

	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel()
	{
		return accountDetailsPanel;
	}
	
	public ChangePasswordViewImpl getChangePasswordPopupPanel()
	{
		return changePasswordPopupPanel;
	}

	@Override
	public Button getChangePasswordButton()
	{
		return changePasswordButton;
	}
	
	@Override
	public void setUserName(String username)
	{
		this.userName.setText(username);
	}
	
	@Override
	public void setAccountType(String acctType)
	{
		this.accountType.setText(acctType);
	}
	
	@Override
	public void setAccountState(int acctStateInt)
	{
		if (acctStateInt == 0)
		{
			this.accountState.setText("Inactive");
		} 
		else if (acctStateInt == 1)
		{
			this.accountState.setText("Active");
		}
		else
		{
			this.accountState.setText("Unknown");
		}
		
	}
	
	@Override
	public void setWpiIdInChar(String wpiIdChar)
	{
		this.wpiId.setText(wpiIdChar);
	}
	
	@Override
	public void setFirstName (String firstName)
	{
		this.firstName.setText(firstName);
	}
	
	@Override
	public void setLastName (String lastName)
	{
		this.lastName.setText(lastName);
	}
	
	@Override
	public void setEmail (String email)
	{
		this.email.setText(email);
	}
	
	@Override
	public void showErrorMessage(String msg)
	{
		Window.alert(msg);
	}
	
	@UiHandler("changePasswordButton")
	void onChangePasswordButtonClick(ClickEvent event)
	{
		presenter.showChangePasswordPopup();
	}
	
}
