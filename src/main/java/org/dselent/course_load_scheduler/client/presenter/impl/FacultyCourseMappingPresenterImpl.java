package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;
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
		List<Integer> numberList = new ArrayList<Integer>();
		List<String> stringList = new ArrayList<String>();
		numberList.add(1);
		stringList.add("Course info example");
		FacultyCourse faculty1 = new FacultyCourse();
		faculty1.setUser_id(1);
		faculty1.setFaculty_id(1);
		faculty1.setCourse_idList(numberList);
		faculty1.setSection_idList(numberList);
		faculty1.setCalendar_idList(numberList);
		faculty1.setFirstName("Jim");
		faculty1.setLastName("Bob");
		faculty1.setCourseNumberList(stringList);
		faculty1.setSectionNameList(stringList);
		faculty1.setSemesterList(stringList);
		List<FacultyCourse> facultyList = Arrays.asList(faculty1,faculty1,faculty1,faculty1,faculty1,faculty1,faculty1);
		this.fillCellTable(facultyList);
		
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
		
		registration = eventBus.addHandler(FacultyCourseNavigationEvent.TYPE, this);
		eventBusRegistration.put(FacultyCourseNavigationEvent.TYPE, registration);
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
	public void onFacultyCourseNavigation(FacultyCourseNavigationEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
	}
}
