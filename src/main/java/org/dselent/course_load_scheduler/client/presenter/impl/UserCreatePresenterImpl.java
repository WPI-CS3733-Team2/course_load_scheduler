package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.CreateUserAction;
import org.dselent.course_load_scheduler.client.action.UserSearchPageAction;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.event.UserCreatePageEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreatedUserEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;
import org.dselent.course_load_scheduler.client.view.UserCreateView;
//import org.dselent.course_load_scheduler.client.view.UserSearchView;

import com.google.gwt.event.shared.HandlerRegistration;
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
		UserSearchPageAction uspa = new UserSearchPageAction();
		UserSearchPageEvent uspe = new UserSearchPageEvent(uspa);
		eventBus.fireEvent(uspe);
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
		
		registration = eventBus.addHandler(CreateUserEvent.TYPE, this);
		eventBusRegistration.put(CreateUserEvent.TYPE, registration);
		
		registration = eventBus.addHandler(UserCreatePageEvent.TYPE, this);
		eventBusRegistration.put(UserCreatePageEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveCreatedUserEvent.TYPE, this);
		eventBusRegistration.put(ReceiveCreatedUserEvent.TYPE, registration);
		
		//Change to generic "invalid" event later
		//That, or make an invalid event for each request, or at least give the invalid event different
		// types. As things are, it reacts every time there's a failure.
		registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
	}
	
	//Initiates the "create user" action
	public void createUser(){
		if(!creationInProgress) {
			creationInProgress = true;
			parentPresenter.showLoadScreen();
			view.getFinalizeCreateButton();
			
			System.out.println(view.getUserRole());
			
			//Retrieves selected index from list box
			//May have to adjust depending on which indices correspond to which individual roles in
			// our final database
			//Adds 1 to index to correspond with database
			Integer userRole = view.getUserRole().getSelectedIndex() + 1;
			String wpiId = view.getWpiIdBox().getText();
			String userName = view.getUsernameBox().getText();
			String firstName = view.getFirstNameBox().getText();
			String lastName = view.getLastNameBox().getText();
			String email = view.getEmailBox().getText();
			
			//Becomes false if any of the fields are left empty
			boolean validUser = true;
			//Becomes false if field is not an integer
			boolean validWpiId = true;
			
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
			
			//Don't know if I need to throw another exception
			if(!wpiId.matches("\\d+")) {
				validWpiId = false;
			}
			
			if(validUser && validWpiId){
				//Create user
				createUserEventFire(userRole,Integer.parseInt(wpiId), userName, firstName, lastName, email);
				
			}else{
				parentPresenter.hideLoadScreen();
				view.getFinalizeCreateButton().setEnabled(true);
				creationInProgress = false;
				
				if(!validUser) {
					//Might want to customize this so it tells you the specific field that was left empty.
					//Also might want to combine error messages into one.
					view.showErrorMessages("No fields can be left empty.");
				}
				
				if(!validWpiId) {
					view.showErrorMessages("WPI ID must be an integer.");
				}
			}
		}
	}
	
	private void createUserEventFire(Integer userRole, Integer wpiId, String userName, String firstName, String lastName, String email) {
		//HasWidgets container = parentPresenter.getView().getViewRootPanel();
		CreateUserAction cua = new CreateUserAction();
		//May need a more effective way to do this
		cua.setUserRole(userRole);
		cua.setWpiId(wpiId);
		cua.setUserName(userName);
		cua.setFirstName(firstName);
		cua.setLastName(lastName);
		cua.setEmail(email);
		System.out.println("WPI ID:" + cua.getWpiId().toString());
		//CreateUserEvent cue = new CreateUserEvent(cua,container);
		CreateUserEvent cue = new CreateUserEvent(cua);
		eventBus.fireEvent(cue);
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	//Navigate to this page
		@Override
		public void onUserCreatePage(UserCreatePageEvent evt) {
			this.go(parentPresenter.getView().getViewRootPanel());
		}
	
	@Override
	public void onReceiveCreatedUser(ReceiveCreatedUserEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getFinalizeCreateButton().setEnabled(true);
		creationInProgress = false;
		view.showErrorMessages("User creation successful.");
	}
	
	/*@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getFinalizeCreateButton().setEnabled(true);
		creationInProgress = false;
		view.showErrorMessages("ERROR: User creation unsuccessful.");
		//System.out.println(evt.getAction().getReason(0));
	}*/
	
	//The problem is not related to firing the event.
	/*@Override
	public void onCreateUser(CreateUserEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getFinalizeCreateButton().setEnabled(true);
		creationInProgress = false;
		view.showErrorMessages("Create user event fired.");
	}*/
}
