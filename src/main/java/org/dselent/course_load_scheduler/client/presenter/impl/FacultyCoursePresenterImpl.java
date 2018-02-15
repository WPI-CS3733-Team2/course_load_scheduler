package org.dselent.course_load_scheduler.client.presenter.impl;


import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class FacultyCoursePresenterImpl extends BasePresenterImpl implements FacultyCoursePresenter
{
	
	private FacultyCourseView view;

	@Inject
	public FacultyCoursePresenterImpl(FacultyCourseView view)
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
	public FacultyCourseView getView() {
		return view;
	}
		
}
