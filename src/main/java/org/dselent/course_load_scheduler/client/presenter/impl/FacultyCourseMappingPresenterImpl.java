package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.model.FacultyCourse;
import org.dselent.course_load_scheduler.client.presenter.FacultyCourseMappingPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseMappingView;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class FacultyCourseMappingPresenterImpl extends BasePresenterImpl implements FacultyCourseMappingPresenter
{
	private IndexPresenter parentPresenter;
	private FacultyCourseMappingView view;

	@Inject
	public FacultyCourseMappingPresenterImpl(IndexPresenter parentPresenter, FacultyCourseMappingView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		
	}
	
	public void fillCellTable(List<FacultyCourse> facultyList) {
		view.getFacultyCellTable().setRowData(facultyList);
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
		
		registration = eventBus.addHandler(ReceiveFacultyCourseNavigationEvent.TYPE, this);
		eventBusRegistration.put(ReceiveFacultyCourseNavigationEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public FacultyCourseMappingView getView()
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
	
	@Override
	public void onReceiveFacultyCourseNavigation(ReceiveFacultyCourseNavigationEvent evt) {
		List<FacultyCourse> facultyCourseList = evt.getAction().getModels();
		this.fillCellTable(facultyCourseList);
		parentPresenter.hideLoadScreen();
		this.go(parentPresenter.getView().getViewRootPanel());
	}
}
