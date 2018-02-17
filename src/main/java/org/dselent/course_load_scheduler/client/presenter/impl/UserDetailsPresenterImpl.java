package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.view.UserDetailsView;

import org.dselent.course_load_scheduler.client.model.User;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.TerminateAccountAction;
import org.dselent.course_load_scheduler.client.action.UserSearchPageAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;
import org.dselent.course_load_scheduler.client.event.UserDetailsPageEvent;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserDetailsPresenter;

public class UserDetailsPresenterImpl extends BasePresenterImpl implements UserDetailsPresenter{
	
	//Maybe give this a user model as a field so it can show its details on initialization
	private UserDetailsView view;
	private IndexPresenter parentPresenter;
	private User user;
	private boolean accountDeletionInProgress; 
	
	@Inject
	public UserDetailsPresenterImpl(IndexPresenter parentPresenter, UserDetailsView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		accountDeletionInProgress = false;
		
		//Only temporary so this can display some information before accessing the server
		//Will need a different field to contain the user role from the users/roles linking table
		//And possibly the name of the role through that
		/*this.user = new User();
		
		user.setId(1);
		user.setWpiId(111111111);
		user.setUserName("jjones");
		user.setFirstName("Jimmy");
		user.setLastName("Jones");
		user.setEmail("jjones1990@wpi.edu");
		user.setUserStateId(1);*/
	}
	
	@Override
	public void init()
	{
		/*view.getUserIdBox().setText(Integer.toString(user.getId()));
		view.getWpiIdBox().setText(Integer.toString(user.getWpiId()));
		view.getUserNameBox().setText(user.getUserName());
		view.getFirstNameBox().setText(user.getFirstName());
		view.getLastNameBox().setText(user.getLastName());
		view.getEmailBox().setText(user.getEmail());
		view.getAccountStateBox().setText(Integer.toString(user.getUserStateId()));
		
		//Temporary; placeholder until role can be retrieved from server/other model
		view.getUserRoleBox().setText("2");*/
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(TerminateAccountEvent.TYPE, this);
		eventBusRegistration.put(TerminateAccountEvent.TYPE, registration);
		
		registration = eventBus.addHandler(UserDetailsPageEvent.TYPE, this);
		eventBusRegistration.put(UserDetailsPageEvent.TYPE, registration);
		
	}
	
	@Override
	public UserDetailsView getView()
	{
		return view;
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
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
	
	//Navigates back to the user search page
	@Override
	public void backToSearch(){
		/*final Injector injector = Injector.INSTANCE;
		UserSearchPresenterImpl userSearchPresenter = injector.getUserSearchPresenter();
		userSearchPresenter.init();
		userSearchPresenter.go(parentPresenter.getView().getViewRootPanel());*/
		
		UserSearchPageAction uspa = new UserSearchPageAction();
		UserSearchPageEvent uspe = new UserSearchPageEvent(uspa);
		eventBus.fireEvent(uspe);
	}
	
	//terminates account of user with given ID (stored in view fields?)
	@Override
	public void terminateAccount() {
		if(!accountDeletionInProgress)
		{
			accountDeletionInProgress = true;
			view.getTerminateAccountButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			String userId = view.getUserIdBox().getText();
			//String password = view.getPasswordTextBox().getText();
			
			/*boolean validUserName = true;
			boolean validPassword = true;

			List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				validateLoginUserName(userName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidLoginStrings.NULL_USER_NAME);
				validUserName = false;
			}

			try
			{
				validateLoginPassword(password);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidLoginStrings.NULL_PASSWORD);
				validPassword = false;
			}
			
			if(validUserName && validPassword)
			{
				sendLogin(userName, password);
			}
			else
			{
				InvalidLoginAction ila = new InvalidLoginAction(invalidReasonList);
				InvalidLoginEvent ile = new InvalidLoginEvent(ila);
				eventBus.fireEvent(ile);
			}*/
			
			//Since the user information will be supplied from the server, this shouldn't need a case for
			// invalid input, but it might be a good idea to implement one anyway.
			fireTerminateAccountEvent(userId);
		}
	}
	
	private void fireTerminateAccountEvent(String userId) {
		Integer intId = Integer.parseInt(userId);
		TerminateAccountAction taa = new TerminateAccountAction(intId);
		TerminateAccountEvent tae = new TerminateAccountEvent(taa);
		eventBus.fireEvent(tae);
	}
	
	@Override
	public void onUserDetailsPage(UserDetailsPageEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		
		User displayedUser = evt.getAction().getUser();
		
		view.getUserIdBox().setText(Integer.toString(displayedUser.getId()));
		view.getWpiIdBox().setText(Integer.toString(displayedUser.getWpiId()));
		view.getUserNameBox().setText(displayedUser.getUserName());
		view.getFirstNameBox().setText(displayedUser.getFirstName());
		view.getLastNameBox().setText(displayedUser.getLastName());
		view.getEmailBox().setText(displayedUser.getEmail());
		view.getAccountStateBox().setText(Integer.toString(displayedUser.getUserStateId()));
		
		//Temporary; placeholder until role can be retrieved from server/other model
		view.getUserRoleBox().setText("2");
	}
}
