package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class SearchSchedulePresenterImpl extends BasePresenterImpl implements SearchSchedulePresenter
{
	private IndexPresenter parentPresenter;
	private SearchScheduleView view;

	@Inject
	public SearchSchedulePresenterImpl(IndexPresenter parentPresenter, SearchScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		this.insertDropDown();
	}

	public void insertDropDown() {
		view.getNavDropDown().insertItem("View Schedule", 1);
		view.getNavDropDown().insertItem("Search Schedule", 2);
		view.getNavDropDown().insertItem("Create Schedule", 3);
		view.getNavDropDown().insertItem("Modify Schedule", 4);
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
		
		//registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		//eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public SearchScheduleView getView()
	{
		return view;
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
	
}
