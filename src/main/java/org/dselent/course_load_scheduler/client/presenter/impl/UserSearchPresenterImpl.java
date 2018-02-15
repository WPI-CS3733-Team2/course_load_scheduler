package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.view.UserSearchView;
import org.dselent.course_load_scheduler.client.action.NavigateAction;
import org.dselent.course_load_scheduler.client.action.SearchUserAction;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidUserEvent;
import org.dselent.course_load_scheduler.client.event.NavigateEvent;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
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
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(SearchUserEvent.TYPE, this);
		eventBusRegistration.put(SearchUserEvent.TYPE, registration);
		
		//Don't know if I need to register the navigate event, if we're using it
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
			view.getSearchUserButton().setEnabled(false);
			
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
				searchUserEventFire(userQuery);
			}else {
				//Invalid query event
				//Maybe don't need a whole event; just have to send message to screen that
				// says search can't be empty
				parentPresenter.hideLoadScreen();
				view.getSearchUserButton().setEnabled(true);
				searchInProgress = false;
				
				view.showErrorMessages("Query cannot be empty.");
				
			}
		}
	}
	
	//fires "Search User" event
	//Currently this doesn't do anything; it needs to communicate with the server
	private void searchUserEventFire(String query) {
		SearchUserAction sua = new SearchUserAction(query);
		SearchUserEvent sue = new SearchUserEvent(sua);
		eventBus.fireEvent(sue);
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
		/*NavigateAction na = new NavigateAction(userCreatePresenter);
		NavigateEvent ne = new NavigateEvent(na);
		eventBus.fireEvent(ne);*/
		userCreatePresenter.init();
		userCreatePresenter.go(parentPresenter.getView().getViewRootPanel());
	}
	
	//The way it is, it might be better to not have the event.
	//I'll leave code related to this event here in case anyone thinks of a way to improve it.
	//Namely, it needs a way to pass on the type of the presenter you want to make without creating a
	// specific presenter implementation, so all the injector stuff can be done in this function.
	//Also, if we use this, we might want to move it to BasePresenterImpl.
	/*@Override
	public void onNavigate(NavigateEvent evt){
		evt.getAction().getPresenterImpl().init();
		evt.getAction().getPresenterImpl().go(parentPresenter.getView().getViewRootPanel());
		
	}*/
	
	@Override
	public void onSearchUser(SearchUserEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getSearchUserButton().setEnabled(true);
		searchInProgress = false;
		//For now, it just navigates to the user details presenter.
		//In the future, the search function will require retrieving data to the server.
		final Injector injector = Injector.INSTANCE;
		UserDetailsPresenterImpl userDetailsPresenter = injector.getUserDetailsPresenter();
		userDetailsPresenter.init();
		userDetailsPresenter.go(parentPresenter.getView().getViewRootPanel());
	}
	
	
}
