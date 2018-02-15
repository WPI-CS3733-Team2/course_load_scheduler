package org.dselent.course_load_scheduler.client.presenter.impl;


import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.view.AdminCourseView;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class AdminCoursePresenterImpl extends BasePresenterImpl implements AdminCoursePresenter
{
	
	private AdminCourseView view;

	@Inject
	public AdminCoursePresenterImpl(AdminCourseView view)
	{
			this.view = view;
			view.setPresenter(this);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public AdminCourseView getView() {
		return view;
	}
		
}
