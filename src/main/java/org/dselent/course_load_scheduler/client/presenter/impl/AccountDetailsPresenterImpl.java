package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountDetailsView;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.TriggerChangePasswordWindowAction;
import org.dselent.course_load_scheduler.client.event.AccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;
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
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(AccountDetailsEvent.TYPE, this);
		eventBusRegistration.put(AccountDetailsEvent.TYPE, registration);
		
		registration = eventBus.addHandler(TriggerChangePasswordWindowEvent.TYPE, this);
		eventBusRegistration.put(TriggerChangePasswordWindowEvent.TYPE, registration);
		
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
	public void onAccountDetails(AccountDetailsEvent evt)
	{
		HasWidgets container = evt.getContainer();

		go(container);
		parentPresenter.hideLoadScreen();
	}
	
	// event:
	// 1. toChangePassword: click the change password button, then the pop up windows about changing password shows.
	@Override
	public void toChangePassword(){
		if (!changePasswordInProgress) {
			view.getChangePasswordButton().setEnabled(false);
			// parentPresenter.showLoadScreen();
			int id = userInfo.getUsersId();
			triggerChangePasswordWindow(id);	
		}
		else {
			view.showErrorMessage("Unknown Error 3 from AccountDetailsPresenterImpl.java. Please refresh the webpage.");
		}
	}
	
	private void triggerChangePasswordWindow(int userId) {
		if(!changePasswordInProgress) {
			changePasswordInProgress = true;
			TriggerChangePasswordWindowAction tcpwa = new TriggerChangePasswordWindowAction(userId);
			TriggerChangePasswordWindowEvent tcpwe = new TriggerChangePasswordWindowEvent(tcpwa);
			eventBus.fireEvent(tcpwe);
			view.getChangePasswordButton().setEnabled(true);
		}
	}
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt)
	{
		HasWidgets container = evt.getContainer();
		ReceiveLoginAction rla = evt.getAction();

		userInfo = rla.getUserInfo();

		go(container);
		parentPresenter.hideLoadScreen();
	}
}
