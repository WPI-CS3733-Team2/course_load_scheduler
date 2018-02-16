package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountDetailsView;
import org.dselent.course_load_scheduler.client.action.TriggerChangePasswordWindowAction;
import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;
import org.dselent.course_load_scheduler.client.model.User;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AccountDetailsPresenterImpl extends BasePresenterImpl implements AccountDetailsPresenter
{
	private int userId;
	private IndexPresenter parentPresenter;
	private AccountDetailsView view;
	private boolean changePasswordInProgress;
	
	@Inject
	public AccountDetailsPresenterImpl(IndexPresenter parentPresenter, AccountDetailsView view)
	{
		this.userId = userId;
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		changePasswordInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		registration = eventBus.addHandler(TriggerChangePasswordWindowEvent.TYPE, this);
		eventBusRegistration.put(TriggerChangePasswordWindowEvent.TYPE, registration);
		System.out.println();
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public AccountDetailsView getView() {
		return view;
	}
	
	@Override
	public IndexPresenter getParentPresenter(){
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	// event:
	// 1. toChangePassword: click the change password button, then the pop up windows about changing password shows.
	@Override
	public void toChangePassword(){
		if (!changePasswordInProgress) {
			view.getChangePasswordButton().setEnabled(false);
			// parentPresenter.showLoadScreen();
			triggerChangePasswordWindow(userId);	
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
	
	private void debug1(TriggerChangePasswordWindowEvent evt) {
		parentPresenter.hideLoadScreen();
		TriggerChangePasswordWindowAction action = evt.getAction();
		view.showErrorMessage("debug1");
	}
}
