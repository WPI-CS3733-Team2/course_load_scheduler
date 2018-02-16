package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.CreateScheduleView;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

public class CreateSchedulePresenterImpl extends BasePresenterImpl implements CreateSchedulePresenter
{
	private IndexPresenter parentPresenter;
	private CreateScheduleView view;
	
	@Inject
	public CreateSchedulePresenterImpl(IndexPresenter parentPresenter, CreateScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
	}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind(){
		
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());	
	}

	@Override
	public CreateScheduleView getView() {
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
