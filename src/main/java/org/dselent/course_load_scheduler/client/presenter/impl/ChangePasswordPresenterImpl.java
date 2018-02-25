package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidChangePasswordStrings;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.view.ChangePasswordView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ChangePasswordPresenterImpl extends BasePresenterImpl implements ChangePasswordPresenter
{
	private int userId;
	private AccountDetailsPresenter parentPresenter;
	private ChangePasswordView view;
	private boolean confirmChangePasswordInProgress;

	@Inject
	public ChangePasswordPresenterImpl(ChangePasswordView view)
	{
		this.view = view;
		view.setPresenter(this);
		confirmChangePasswordInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
		HandlerRegistration registration1;
		registration1 = eventBus.addHandler(InvalidChangePasswordEvent.TYPE, this);
		eventBusRegistration.put(InvalidChangePasswordEvent.TYPE, registration1);
		
		HandlerRegistration registration2;
		registration2 = eventBus.addHandler(ReceiveChangePasswordEvent.TYPE, this);
		eventBusRegistration.put(ReceiveChangePasswordEvent.TYPE, registration2);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public void setParentPresenter(AccountDetailsPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	@Override
	public AccountDetailsPresenter getParentPrsenter()
	{
		return parentPresenter;
	}
	
	@Override
	public ChangePasswordView getView()
	{
		return view;
	}
	
	@Override
	public void showChangePasswordPopup(int userId)
	{
		view.showWindow();
		this.userId = userId;
	}
	
	@Override
	public void hideChangePasswordPopup()
	{
		view.hideWindow();
	}
	
	// event handlers:
	// 1. requestChangePassword: click the "Confirm" button, 
	@Override
	public void requestChangePassword()
	{
		if(!confirmChangePasswordInProgress)
		{
			confirmChangePasswordInProgress = true;
			view.getConfirmChangePasswordButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			String currentPassword = view.getCurrentPasswordTextBox().getText();
			String newPassword = view.getNewPasswordTextBox().getText();
			String confirmPassword = view.getConfirmPasswordTextBox().getText();
			
			List<String> invalidReasonList = new ArrayList<>();
			
			boolean valid = validatePassword(currentPassword, newPassword, confirmPassword, invalidReasonList);
					
			if(valid)
			{
				sendChangePassword(userId, currentPassword, newPassword);
			}
			else
			{
				// fire to itself is probably unnecessary
				InvalidChangePasswordAction icpa = new InvalidChangePasswordAction(invalidReasonList);
				InvalidChangePasswordEvent icpe = new InvalidChangePasswordEvent(icpa);
				eventBus.fireEvent(icpe);
			}
		}
	}
	
	private void sendChangePassword(int userId, String currentPassword, String newPassword)
	{
		SendChangePasswordAction scpa = new SendChangePasswordAction(userId, currentPassword, newPassword);
		SendChangePasswordEvent scpe = new SendChangePasswordEvent(scpa);
		eventBus.fireEvent(scpe);
	}
	
	private boolean validatePassword(String currentPassword, String newPassword, String confirmPassword, List<String> invalidReasonList)
	{
		boolean valid = true;
		
		try
		{
			checkEmptyString(currentPassword);
		}
		catch(EmptyStringException e)
		{
			invalidReasonList.add(InvalidChangePasswordStrings.NULL_CURRENT_PASSWORD);
			valid = false;
		}
		
		try
		{
			checkEmptyString(newPassword);
		}
		catch(EmptyStringException e)
		{
			invalidReasonList.add(InvalidChangePasswordStrings.NULL_NEW_PASSWORD);
			valid = false;
		}
		
		try
		{
			checkEmptyString(confirmPassword);
			
			if (!newPassword.equals(confirmPassword))
			{
				invalidReasonList.add(InvalidChangePasswordStrings.CONFIRM_PASSWORD_WRONG);
				valid = false;
			}
		}
		catch(EmptyStringException e)
		{
			invalidReasonList.add(InvalidChangePasswordStrings.NULL_CONFIRM_PASSWORD);
			valid = false;
		}

		return valid;
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
	public void goBack()
	{
		parentPresenter.hideChangePasswordPopup();
	}
	
	// 3. onInvalidChangePassword
	@Override
	public void onInvalidChangePassword(InvalidChangePasswordEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getConfirmChangePasswordButton().setEnabled(true);
		confirmChangePasswordInProgress = false;
		
		InvalidChangePasswordAction icpa = evt.getAction();
		view.showErrorMessages(icpa.toString());
	}
	
	@Override
	public void onReceiveChangePassword(ReceiveChangePasswordEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getConfirmChangePasswordButton().setEnabled(true);
		confirmChangePasswordInProgress = false;
		
		Window.alert("Password successfully changed");
	}
}
