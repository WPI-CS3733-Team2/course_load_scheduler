package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.Arrays;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ConfirmSchedulePageAction;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleAddFacultyView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class CreateScheduleAddFacultyPresenterImpl extends BasePresenterImpl implements CreateScheduleAddFacultyPresenter
{
	private IndexPresenter parentPresenter;
	private CreateScheduleAddFacultyView view;
	private List<Course> courses;

	@Inject
	public CreateScheduleAddFacultyPresenterImpl(IndexPresenter parentPresenter, CreateScheduleAddFacultyView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		List<String> names = Arrays.asList("Faculty1", "Faculty2", "Faculty3");
		view.addFaculty(names);
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
		
		registration = eventBus.addHandler(CreateScheduleSelectFacultyEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleSelectFacultyEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public CreateScheduleAddFacultyView getView()
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
	
	public void fireConfirmSchedulePage() {
		ConfirmSchedulePageAction csa = new ConfirmSchedulePageAction(courses,view.getCheckedFaculty());
		ConfirmSchedulePageEvent cse = new ConfirmSchedulePageEvent(csa);
		eventBus.fireEvent(cse);
	}
	
	@Override
	public void onCreateScheduleSelectFaculty(CreateScheduleSelectFacultyEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		this.courses = evt.getAction().getCourses();
	}

}
