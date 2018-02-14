package org.dselent.course_load_scheduler.client.presenter.impl;


import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.FacultyCourseMappingView;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class CreateModifyCoursePresenterImpl extends BasePresenterImpl implements CreateModifyCoursePresenter
{

	@Inject
	public CreateModifyCoursePresenterImpl(IndexPresenter parentPresenter, FacultyCourseMappingView view)
	{
			
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
