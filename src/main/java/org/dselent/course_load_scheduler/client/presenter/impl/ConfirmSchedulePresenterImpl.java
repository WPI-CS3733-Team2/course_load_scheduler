package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ConfirmScheduleView;
import org.dselent.course_load_scheduler.client.view.LoginView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ConfirmSchedulePresenterImpl extends BasePresenterImpl implements ConfirmSchedulePresenter{
	private IndexPresenter parentPresenter;
	private ConfirmScheduleView view;
	
	@Inject
	public ConfirmSchedulePresenterImpl(IndexPresenter parentPresenter, ConfirmScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public ConfirmScheduleView getView()
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
