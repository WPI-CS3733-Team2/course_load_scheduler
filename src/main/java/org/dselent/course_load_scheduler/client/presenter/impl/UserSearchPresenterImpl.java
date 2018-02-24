package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.view.UserSearchView;

import java.util.List;
import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.SearchUserAction;
import org.dselent.course_load_scheduler.client.action.UserCreatePageAction;
import org.dselent.course_load_scheduler.client.action.UserDetailsPageAction;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.event.UserCreatePageEvent;
import org.dselent.course_load_scheduler.client.event.UserDetailsPageEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveUserSearchResultsEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;
//import org.dselent.course_load_scheduler.client.view.LoginView;

public class UserSearchPresenterImpl extends BasePresenterImpl implements UserSearchPresenter{
	
	private UserSearchView view;
	private IndexPresenter parentPresenter;
	private boolean searchInProgress; //keeps track of whether system is currently searching
	private List<User> users;
	
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
		//Not the best solution, but makes sure the table is only initialized once.
		view.initColumns();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(UserSearchPageEvent.TYPE, this);
		eventBusRegistration.put(UserSearchPageEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SearchUserEvent.TYPE, this);
		eventBusRegistration.put(SearchUserEvent.TYPE, registration);
		//Don't know if I need to register the navigate event, if we're using it
		
		registration = eventBus.addHandler(ReceiveUserSearchResultsEvent.TYPE, this);
		eventBusRegistration.put(ReceiveUserSearchResultsEvent.TYPE, registration);
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
	public List<User> getUsers() {
		return users;
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
	private void searchUserEventFire(String query) {
		Integer searchBy = view.getSearchBy().getSelectedIndex();
		//HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SearchUserAction sua = new SearchUserAction(query, searchBy);
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
		/*NavigateAction na = new NavigateAction(userCreatePresenter);
		NavigateEvent ne = new NavigateEvent(na);
		eventBus.fireEvent(ne);*/
		UserCreatePageAction ucpa = new UserCreatePageAction();
		UserCreatePageEvent ucpe = new UserCreatePageEvent(ucpa);
		eventBus.fireEvent(ucpe);
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
	
	//Fills table with search results
	public void fillTable(List<User> users) {
		view.getUserTable().setRowData(users);
	}
	
	@Override
	public void onSearchUser(SearchUserEvent evt) {
		parentPresenter.hideLoadScreen();
		//view.getSearchUserButton().setEnabled(true);
		//searchInProgress = false;
		//For now, it just navigates to the user details presenter.
		//In the future, the search function will require retrieving data from the server.
		//This includes the user role, which for now is not in the model.
		
		//view.initColumns();
		//Obtain this from 
		UserInfo userInfo = new UserInfo(); // TODO get from event?
		userInfo.setUsersId(1);
		userInfo.setUsersWpiId("111111111");
		userInfo.setUsersFirstName("jjones");
		userInfo.setUsersFirstName("Jimmy");
		userInfo.setUsersLastName("Jones");
		userInfo.setUsersEmail("jjones1990@wpi.edu");
		userInfo.setUsersAccountState("1");
		UserDetailsPageAction udpa = new UserDetailsPageAction(userInfo);
		UserDetailsPageEvent udpe = new UserDetailsPageEvent(udpa);
		eventBus.fireEvent(udpe);
		
		//Button detailsButton = new Button();
		
		//Test search results work.
		/*User user = new User();
		user.setWpiId(111111111);
		user.setUserName("jjones");
		user.setFirstName("Jimmy");
		user.setLastName("Jones");
		user.setEmail("jjones1990@wpi.edu");
		user.setUserStateId(1);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		
		fillTable(userList);*/
	}
	
	//Clears results table
	public void clearTable() {
		users = new ArrayList<User>();
		fillTable(users);
	}
	
	@Override
	public void onReceiveUserSearchResults(ReceiveUserSearchResultsEvent evt) {
		view.getSearchUserButton().setEnabled(true);
		searchInProgress = false;
		users = evt.getAction().getUsers();
		
		fillTable(evt.getAction().getUsers());
	}
	
	@Override
	public void viewUserDetails(User user) {
		//UserDetailsPageAction udpa = new UserDetailsPageAction(user);
		/*udpa.getUser().setId(1);
		udpa.getUser().setWpiId(111111111);
		udpa.getUser().setUserName("jjones");
		udpa.getUser().setFirstName("Jimmy");
		udpa.getUser().setLastName("Jones");
		udpa.getUser().setEmail("jjones1990@wpi.edu");
		udpa.getUser().setUserStateId(1);*/
		//UserDetailsPageEvent udpe = new UserDetailsPageEvent(udpa);
		//eventBus.fireEvent(udpe);
	}
	
	// Navigate to this page
	@Override
	public void onUserSearchPage(UserSearchPageEvent evt)
	{
		this.go(parentPresenter.getView().getViewRootPanel());
		//Clears table when the user navigates to this page.
		//It might be better to only clear the table after a user has been deleted.
		clearTable();
	}
}
