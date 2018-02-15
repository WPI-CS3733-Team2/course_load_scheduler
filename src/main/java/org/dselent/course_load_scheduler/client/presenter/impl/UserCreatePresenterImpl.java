package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;
import org.dselent.course_load_scheduler.client.view.UserCreateView;
//import org.dselent.course_load_scheduler.client.view.UserSearchView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class UserCreatePresenterImpl extends BasePresenterImpl implements UserCreatePresenter{
	private UserCreateView view;
	private IndexPresenter parentPresenter;
	private boolean creationInProgress;
	
	@Inject
	public UserCreatePresenterImpl(IndexPresenter parentPresenter, UserCreateView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		creationInProgress = false;
	}
	
	@Override
	public UserCreateView getView()
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
	public void backToSearch(){
		final Injector injector = Injector.INSTANCE;
		UserSearchPresenterImpl userSearchPresenter = injector.getUserSearchPresenter();
		userSearchPresenter.init();
		userSearchPresenter.go(parentPresenter.getView().getViewRootPanel());
	}
	
	//Initiates the "create user" action
	public void createUser(){
		if(!creationInProgress) {
			creationInProgress = true;
			parentPresenter.showLoadScreen();
			
			System.out.println(view.getUserRole());
			
			//Retrieves selected index from list box
			//May have to adjust depending on which indices correspond to which individual roles in
			// our final database
			Integer userRole = view.getUserRole().getSelectedIndex();
			String wpiId = view.getWpiIdBox().getText();
			String userName = view.getUsernameBox().getText();
			String firstName = view.getFirstNameBox().getText();
			String lastName = view.getLastNameBox().getText();
			String email = view.getEmailBox().getText();
			
			//Becomes false if any of the fields are left empty
			boolean validUser = true;
			
			try 
			{
				checkEmptyString(wpiId);
			}
			catch(EmptyStringException e)
			{
				validUser = false;
			}
			
			try 
			{
				checkEmptyString(userName);
			}
			catch(EmptyStringException e)
			{
				validUser = false;
			}
			
			try 
			{
				checkEmptyString(firstName);
			}
			catch(EmptyStringException e)
			{
				validUser = false;
			}
			
			try 
			{
				checkEmptyString(lastName);
			}
			catch(EmptyStringException e)
			{
				validUser = false;
			}
			
			try 
			{
				checkEmptyString(email);
			}
			catch(EmptyStringException e)
			{
				validUser = false;
			}
			
			if(validUser){
				//Create user
			}else{
				//Invalid user event
				//Maybe don't need a whole event; just have to send message to screen that
				// says certain fields were left empty
			}
		}
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
}
