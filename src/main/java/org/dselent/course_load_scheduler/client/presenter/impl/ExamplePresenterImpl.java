package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.event.SendAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.ExamplePresenter;
import org.dselent.course_load_scheduler.client.view.ExampleView;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ExamplePresenterImpl extends BasePresenterImpl implements ExamplePresenter
{
	private ExampleView view;
	private UserInfo userModel;

	@Inject
	public ExamplePresenterImpl(ExampleView view)
	{
		this.view = view;
		view.setPresenter(this);
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
		
		registration = eventBus.addHandler(SendAccountDetailsEvent.TYPE, this);
		eventBusRegistration.put(SendAccountDetailsEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		view.getUserIdField().setText(Integer.toString(userModel.getUsersId()));
		view.getUserNameField().setText(userModel.getUsersUserName());
		view.getFirstNameField().setText(userModel.getUsersFirstName());
		view.getLastNameField().setText(userModel.getUsersLastName());
		view.getEmailField().setText(userModel.getUsersEmail());
		view.getUserStateIdField().setText(userModel.getUsersAccountState());
		view.getCreatedAtField().setText(userModel.getUsersCreatedAt().toString());
		view.getUpdatedAtField().setText(userModel.getUsersUpdatedAt().toString());
		
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public ExampleView getView()
	{
		return view;
	}
	
	/*
	@Override
	public void onAccountDetails(SendAccountDetailsEvent evt)
	{
		HasWidgets container = evt.getContainer();
		UserDetailsPageAction udpa = evt.getAction();

		userModel = udpa.getUserInfo();
		
		// show myself
		go(container);
		
		// use injector to get to index presenter
		// hide loading screen
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
	*/

}
