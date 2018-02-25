package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountDetailsView;
import org.dselent.course_load_scheduler.client.action.ReceiveAccountDetailsAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event.ReceiveAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.model.UserInfo;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AccountDetailsPresenterImpl extends BasePresenterImpl implements AccountDetailsPresenter
{
	private UserInfo userInfo;
	private IndexPresenter parentPresenter;
	private ChangePasswordPresenter changePasswordPresenter;
	private AccountDetailsView view;
	private boolean changePasswordInProgress;
	
	@Inject
	public AccountDetailsPresenterImpl(IndexPresenter parentPresenter, AccountDetailsView view, ChangePasswordPresenter changePasswordPresenter)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.changePasswordPresenter = changePasswordPresenter;
		view.setPresenter(this);
		changePasswordInProgress = false;		
	}
	
	@Override
	public void init()
	{
		changePasswordPresenter.init();
		changePasswordPresenter.setParentPresenter(this);
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(ReceiveAccountDetailsEvent.TYPE, this);
		eventBusRegistration.put(ReceiveAccountDetailsEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveLoginEvent.TYPE, this);
		eventBusRegistration.put(ReceiveLoginEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		view.setFirstName(userInfo.getUsersFirstName());
		view.setLastName(userInfo.getUsersLastName());
		view.setUserName(userInfo.getUsersUserName());
		view.setWpiIdInChar(userInfo.getUsersWpiId());
		view.setEmail(userInfo.getUsersEmail());
		view.setAccountType(userInfo.getUserRolesRoleName());
		view.setAccountState(Integer.parseInt(userInfo.getUsersAccountState()));
		
		changePasswordPresenter.go(view.getChangePasswordPopupPanel().getViewRootPanel());
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public AccountDetailsView getView()
	{
		return view;
	}
	
	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	@Override
	public String getUserType()
	{
		return userInfo.getUserRolesRoleName();
	}
		
	@Override
	public void showChangePasswordPopup()
	{
		if (!changePasswordInProgress)
		{
			changePasswordInProgress = true;
			view.getChangePasswordButton().setEnabled(false);
			int userId = userInfo.getUsersId();
			changePasswordPresenter.showChangePasswordPopup(userId);
		}
	}
	
	@Override
	public void hideChangePasswordPopup()
	{
		changePasswordPresenter.hideChangePasswordPopup();
		changePasswordInProgress = false;
		view.getChangePasswordButton().setEnabled(true);
	}
	
	@Override
	public void showLoadScreen()
	{
		parentPresenter.showLoadScreen();
	}
	
	@Override
	public void hideLoadScreen()
	{
		parentPresenter.hideLoadScreen();
	}
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt)
	{
		HasWidgets container = evt.getContainer();
		ReceiveLoginAction rla = evt.getAction();

		userInfo = rla.getUserInfo();//Injector.INSTANCE.getGlobalData().getUserInfo();

		go(container);
		parentPresenter.showMenuBar();
		parentPresenter.hideLoadScreen();
	}
	
	@Override
	public void onReceiveAccountDetails(ReceiveAccountDetailsEvent evt)
	{
		HasWidgets container = evt.getContainer();
		ReceiveAccountDetailsAction rada = evt.getAction();

		userInfo = rada.getUserInfo();//Injector.INSTANCE.getGlobalData().getUserInfo();

		go(container);
		parentPresenter.showMenuBar();
		parentPresenter.hideLoadScreen();
	}
}
