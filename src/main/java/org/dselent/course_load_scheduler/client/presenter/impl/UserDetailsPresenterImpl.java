package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.view.UserDetailsView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserDetailsPresenter;

public class UserDetailsPresenterImpl extends BasePresenterImpl implements UserDetailsPresenter{
	
	private UserDetailsView view;
	private IndexPresenter parentPresenter;
	//private boolean searchInProgress; //keeps track of whether system is currently searching
	
	@Inject
	public UserDetailsPresenterImpl(IndexPresenter parentPresenter, UserDetailsView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		//searchInProgress = false;
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
	public void backToSearch(){
		final Injector injector = Injector.INSTANCE;
		UserSearchPresenterImpl userSearchPresenter = injector.getUserSearchPresenter();
		userSearchPresenter.init();
		userSearchPresenter.go(parentPresenter.getView().getViewRootPanel());
	}
}
