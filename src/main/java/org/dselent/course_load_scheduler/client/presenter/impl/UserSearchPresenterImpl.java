package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.view.UserSearchView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.UserCreatePresenterImpl;
//import org.dselent.course_load_scheduler.client.view.LoginView;

public class UserSearchPresenterImpl extends BasePresenterImpl implements UserSearchPresenter{
	
	private UserSearchView view;
	private IndexPresenter parentPresenter;
	private boolean searchInProgress; //keeps track of whether system is currently searching
	
	@Inject
	public UserSearchPresenterImpl(IndexPresenter parentPresenter, UserSearchView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		searchInProgress = false;
	}
	//Have to make view extend presenter
	@Override
	public UserSearchView getView()
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
	
	@Override
	public void searchUser() {
		if(!searchInProgress) {
			searchInProgress = true;
			parentPresenter.showLoadScreen();
			
			String userQuery = view.getSearchUserBox().getText();
			
			boolean validQuery = true;
			
			try 
			{
				checkEmptyString(userQuery);
			}
			catch(EmptyStringException e)
			{
				validQuery = false;
			}
			
			if(validQuery){
				//Search for users
			}else {
				//Invalid query event
				//Maybe don't need a whole event; just have to send message to screen that
				// says search can't be empty
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
	
	//Navigate to create users page
	public void toCreateUsers(){
		final Injector injector = Injector.INSTANCE;
		UserCreatePresenterImpl userCreatePresenter = injector.getUserCreatePresenter();
		userCreatePresenter.init();
		userCreatePresenter.go(parentPresenter.getView().getViewRootPanel());
	}
	
}
