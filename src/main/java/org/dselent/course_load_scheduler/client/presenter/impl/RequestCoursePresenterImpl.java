package org.dselent.course_load_scheduler.client.presenter.impl;


import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;
import org.dselent.course_load_scheduler.client.view.RequestCourseView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class RequestCoursePresenterImpl extends BasePresenterImpl implements RequestCoursePresenter
{
	
	private RequestCourseView view;

	@Inject
	public RequestCoursePresenterImpl(RequestCourseView view)
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
	public RequestCourseView getView() {
		return view;
	}
		
}
