package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ConfirmSchedulePageAction;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.utils.Pair;
import org.dselent.course_load_scheduler.client.view.CreateScheduleAddFacultyView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class CreateScheduleAddFacultyPresenterImpl extends BasePresenterImpl implements CreateScheduleAddFacultyPresenter
{
	private IndexPresenter parentPresenter;
	private CreateScheduleAddFacultyView view;
	private List<Course> courses = new ArrayList<Course>();
	List<Pair<User, Integer>> pairs = new ArrayList<Pair<User, Integer>>();

	@Inject
	public CreateScheduleAddFacultyPresenterImpl(IndexPresenter parentPresenter, CreateScheduleAddFacultyView view)
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
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(ReceiveSelectFacultyEvent.TYPE, this);
		eventBusRegistration.put(ReceiveSelectFacultyEvent.TYPE, registration);
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
		Integer index = view.getCheckedFaculty();
		Pair<User, Integer> selectedFacultyMember = pairs.get(index);
		User user = selectedFacultyMember.getValue1();
		Integer facultyId = selectedFacultyMember.getValue2();
		ConfirmSchedulePageAction csa = new ConfirmSchedulePageAction(courses, user, facultyId);
		ConfirmSchedulePageEvent cse = new ConfirmSchedulePageEvent(csa);
		eventBus.fireEvent(cse);
	}
	
	@Override
	public void onReceiveSelectFaculty(ReceiveSelectFacultyEvent evt) {
		pairs.clear();
		courses.clear();
		pairs = evt.getAction().getUserFacultyPairs();
		List<String> names = new ArrayList<String>();
		for(Pair<User, Integer> pair : pairs) {
			User user = pair.getValue1();
			String name = user.getFirstName() + " " + user.getLastName();
			names.add(name);
		}
		view.addFaculty(names);
		courses = evt.getAction().getCourseList();
		this.go(parentPresenter.getView().getViewRootPanel());
	}

}
