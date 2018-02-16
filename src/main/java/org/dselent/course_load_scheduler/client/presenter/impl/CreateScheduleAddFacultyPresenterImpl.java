package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleVisualPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleAddFacultyView;
import org.dselent.course_load_scheduler.client.view.CreateScheduleVisualView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class CreateScheduleAddFacultyPresenterImpl extends BasePresenterImpl implements CreateScheduleAddFacultyPresenter
{
	private IndexPresenter parentPresenter;
	private CreateScheduleAddFacultyView view;

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
		
		//registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		//eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
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

}
