package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountDetailsView;
import org.dselent.course_load_scheduler.client.action.TriggerChangePasswordWindowAction;
import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UserRole;
import org.dselent.course_load_scheduler.client.model.UsersRolesLink;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AccountDetailsPresenterImpl extends BasePresenterImpl implements AccountDetailsPresenter
{
	private User user;
	private UsersRolesLink usersRolesLink;
	private UserRole userRole;
	private IndexPresenter parentPresenter;
	private AccountDetailsView view;
	private boolean changePasswordInProgress;
	
	@Inject
	public AccountDetailsPresenterImpl(IndexPresenter parentPresenter, AccountDetailsView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		changePasswordInProgress = false;
		this.user = new User();
		this.usersRolesLink = new UsersRolesLink();
		this.userRole = new UserRole();
		
		user.setId(1);
		user.setWpiId(111111111);
		user.setUserName("jjones");
		user.setFirstName("Jimmy");
		user.setLastName("Jones");
		user.setEmail("jjones1990@wpi.edu");
		user.setUserStateId(1);
		userRole.setId(1);
		userRole.setRoleName("Faculty");
		usersRolesLink.setUserId(user.getId());
		usersRolesLink.setRoleId(userRole.getId());
		
		view.setFirstName(user.getFirstName());
		view.setLastName(user.getLastName());
		view.setUserName(user.getUserName());
		view.setWpiIdInChar(user.getWpiId().toString());
		view.setEmail(user.getEmail());
		view.setAccountType(userRole.getRoleName());
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
	
	@Override
	public String getUserType() {
		return this.userRole.getRoleName();
	}
	
	// event:
	// 1. toChangePassword: click the change password button, then the pop up windows about changing password shows.
	@Override
	public void toChangePassword(){
		if (!changePasswordInProgress) {
			view.getChangePasswordButton().setEnabled(false);
			// parentPresenter.showLoadScreen();
			int id = user.getId();
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
}
