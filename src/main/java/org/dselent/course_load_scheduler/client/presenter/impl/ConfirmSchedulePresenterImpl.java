package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.CreateScheduleAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ConfirmScheduleView;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.model.Schedule;
//import org.dselent.course_load_scheduler.client.view.TextBox;
import com.google.gwt.event.shared.HandlerRegistration;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ConfirmSchedulePresenterImpl extends BasePresenterImpl implements ConfirmSchedulePresenter{
	private IndexPresenter parentPresenter;
	private ConfirmScheduleView view;
	private boolean scheduleCreationInProgress;
	
	@Inject
	public ConfirmSchedulePresenterImpl(IndexPresenter parentPresenter, ConfirmScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		scheduleCreationInProgress = false;
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
		
		registration = eventBus.addHandler(CreateScheduleEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public ConfirmScheduleView getView()
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
	
	//Creates schedule
	//Uses data provided in previous pages
	@Override
	public void createSchedule() {
		//Create schedule
		//Should use schedule model
		if(!scheduleCreationInProgress)
		{
			scheduleCreationInProgress = true;
			view.getConfirmScheduleButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			String scheduleName = view.getScheduleNameBox().getText();
			//String password = view.getPasswordTextBox().getText();
			
			boolean validScheduleName = true;
			//boolean validPassword = true;

			//List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				checkEmptyString(scheduleName);
			}
			catch(EmptyStringException e)
			{
				//invalidReasonList.add(InvalidLoginStrings.NULL_USER_NAME);
				validScheduleName = false;
			}

			
			if(validScheduleName)
			{
				//Create schedule
				//Will need data collected from other events/presenters to do this
				
				//Replace with existing schedule model from other pages
				Schedule tempSchedule = new Schedule();
				createScheduleEventFire(tempSchedule);
			}
			else
			{
				parentPresenter.hideLoadScreen();
				view.getConfirmScheduleButton().setEnabled(true);
				scheduleCreationInProgress = false;
				
				//Might want to customize this so it tells you the specific field that was left empty.
				view.showErrorMessages("Schedule name cannot be left empty.");
			}
		}
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	private void createScheduleEventFire(Schedule schedule) {
		CreateScheduleAction csa = new CreateScheduleAction(schedule);
		CreateScheduleEvent cse = new CreateScheduleEvent(csa);
		eventBus.fireEvent(cse);
	}
}
