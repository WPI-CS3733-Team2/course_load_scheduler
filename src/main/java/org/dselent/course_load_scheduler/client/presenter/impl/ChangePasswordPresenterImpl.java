package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.TriggerChangePasswordWindowAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidChangePasswordStrings;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.ChangePasswordView;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ChangePasswordPresenterImpl extends BasePresenterImpl implements ChangePasswordPresenter
{
	private int userId;
	private IndexPresenter parentPresenter;
	private ChangePasswordView view;
	private boolean confirmChangePasswordInProgress;


	@Inject
	public ChangePasswordPresenterImpl(IndexPresenter parentPresenter, ChangePasswordView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		confirmChangePasswordInProgress = false;
	}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind() {
		HandlerRegistration registration1;
		HandlerRegistration registration2;
		registration1 = eventBus.addHandler(InvalidChangePasswordEvent.TYPE, this);
		registration2 = eventBus.addHandler(TriggerChangePasswordWindowEvent.TYPE, this);
		eventBusRegistration.put(InvalidChangePasswordEvent.TYPE, registration1);
		eventBusRegistration.put(TriggerChangePasswordWindowEvent.TYPE, registration2);
		view.getChangePasswordPopupPanel().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public ChangePasswordView getView() {
		return view;
	}

	@Override
	public int getUserId() {
		return this.userId;
	}
	
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public void onTriggerChangePasswordWindow1(TriggerChangePasswordWindowEvent evt) {
		//view.showWindow();
		view.getChangePasswordPopupPanel().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
		TriggerChangePasswordWindowAction action = evt.getAction();
		this.userId = action.getUserId();
		view.showErrorMessages("debug3");
	}
	
	
	// event handlers:
	// 1. requestChangePassword: click the "Confirm" button, 
	@Override
	public void requestChangePassword() {
		if(!confirmChangePasswordInProgress) {
			view.getConfirmChangePasswordButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			int userId = this.userId;
			String currentPassword = view.getCurrentPasswordTextBox().getText();
			String newPassword = view.getNewPasswordTextBox().getText();
			String confirmPassword = view.getConfirmPasswordTextBox().getText();
			
			boolean validCurrentPassword = true;
			boolean validNewPassword = true;
			boolean validConfirmPassword = true;
			
			List<String> invalidReasonList = new ArrayList<>();
			
			try {
				validateCurrentPassword(currentPassword);
			}
			catch(EmptyStringException e) {
				invalidReasonList.add(InvalidChangePasswordStrings.NULL_CURRENT_PASSWORD);
				validCurrentPassword = false;
			}
			
			try {
				validateNewPassword(newPassword);
			}
			catch(EmptyStringException e) {
				invalidReasonList.add(InvalidChangePasswordStrings.NULL_NEW_PASSWORD);
				validNewPassword = false;
			}
			
			if (!newPassword.equals(confirmPassword)) {
				invalidReasonList.add(InvalidChangePasswordStrings.CONFIRM_PASSWORD_WRONG);
				validConfirmPassword = false;
			}
			
			if(validCurrentPassword && validNewPassword && validConfirmPassword) {
				sendChangePassword(userId, currentPassword, newPassword);
			}
			else {
				InvalidChangePasswordAction icpa = new InvalidChangePasswordAction(invalidReasonList);
				InvalidChangePasswordEvent icpe = new InvalidChangePasswordEvent(icpa);
				eventBus.fireEvent(icpe);
			}
		}
	}
	
	private void sendChangePassword(int userId, String currentPassword, String newPassword) {
		if (!confirmChangePasswordInProgress) {
			confirmChangePasswordInProgress = true;
			SendChangePasswordAction scpa = new SendChangePasswordAction(userId, currentPassword, newPassword);
			SendChangePasswordEvent scpe = new SendChangePasswordEvent(scpa);
			eventBus.fireEvent(scpe);
			confirmChangePasswordInProgress = false;
		}
		else {
			view.showErrorMessages("Unknown Error 1 in ChangePasswordPresenterImpl.java. Please refresh the webpage.");
		}
		
	}
	
	private void validateCurrentPassword(String currentPassword) throws EmptyStringException{
		checkEmptyString(currentPassword);
	}
	
	private void validateNewPassword(String newPassword) throws EmptyStringException{
		checkEmptyString(newPassword);
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	// 2. toGoBack: click the go back button, the pop-up window disappears and returns account detail page.
	@Override
	public void goBack() {
		if(confirmChangePasswordInProgress) {
			confirmChangePasswordInProgress = false;
			view.getBackButton().setEnabled(false);
			view.getChangePasswordPopupPanel().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
			
		}
		else {
			view.showErrorMessages("Unknown Error 4 in ChangePasswordPresenterImpl.java. Please refresh the webpage.");
		}
	}
	
	// 3. onInvalidChangePassword
	public void onInvalidChangePassword(InvalidChangePasswordEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getConfirmChangePasswordButton().setEnabled(true);
		confirmChangePasswordInProgress = false;
		
		InvalidChangePasswordAction icpa = evt.getAction();
		view.showErrorMessages(icpa.toString());
	}
}
