package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event.AccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.event.RequestInboxNavigationEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.action.CreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.FacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.action.RequestInboxNavigationAction;
import org.dselent.course_load_scheduler.client.action.SearchScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.UserSearchPageAction;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.event.ViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.IndexView;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HasWidgets;


public class IndexPresenterImpl extends BasePresenterImpl implements IndexPresenter
{
	private IndexView view;

	@Inject
	public IndexPresenterImpl(IndexView view)
	{
		this.view = view;
		view.setPresenter(this);
		
		view.setAccountCommand(new Command() {
			@Override
			public void execute()
			{	
				AccountDetailsEvent ade = new AccountDetailsEvent(view.getViewRootPanel());
				eventBus.fireEvent(ade);
			}
		});
		
		view.setViewScheduleCommand(new Command() {
			@Override
			public void execute() {	
				ViewScheduleNavigationAction vsna = new ViewScheduleNavigationAction();
				ViewScheduleNavigationEvent vsne = new ViewScheduleNavigationEvent(vsna);
				eventBus.fireEvent(vsne); 
			}
		});
		
		view.setSearchScheduleCommand(new Command() {
			@Override
			public void execute() {	
				SearchScheduleNavigationAction ssna = new SearchScheduleNavigationAction();
				SearchScheduleNavigationEvent ssne = new SearchScheduleNavigationEvent(ssna);
				eventBus.fireEvent(ssne); 
			}
		});
		
		view.setCreateScheduleCommand(new Command() {
			@Override
			public void execute() {	
				CreateScheduleNavigationAction csna = new CreateScheduleNavigationAction();
				CreateScheduleNavigationEvent csne = new CreateScheduleNavigationEvent(csna);
				eventBus.fireEvent(csne); 
				
			}
		});
		
		view.setCoursesCommand(new Command() {
			@Override
			public void execute() {
				final Injector injector = Injector.INSTANCE;
				
				String userRole = injector.getAccountDetailsPresenter().getUserType();
				
				// Used to simulate being an admin
				boolean testing = false;
				
				if (userRole.equals("Admin") || testing) {
					ViewCourseAction vca = new ViewCourseAction(new ArrayList<Course>());
					AdminCourseEvent ace = new AdminCourseEvent(vca);
					eventBus.fireEvent(ace);
				} 
				else {
					ViewCourseAction vca = new ViewCourseAction(new ArrayList<Course>());
					FacultyCourseEvent fce = new FacultyCourseEvent(vca);
					eventBus.fireEvent(fce);
				}
			}
		});
		
		view.setUsersCommand(new Command() {
			@Override
			public void execute() {	
				UserSearchPageAction uspa = new UserSearchPageAction();
				UserSearchPageEvent uspe = new UserSearchPageEvent(uspa);
				eventBus.fireEvent(uspe);
			}
		});
		
		view.setRequestsCommand(new Command() {
			@Override
			public void execute() {	
				RequestInboxNavigationAction rina = new RequestInboxNavigationAction();
				RequestInboxNavigationEvent rine = new RequestInboxNavigationEvent(rina);
				eventBus.fireEvent(rine);
			}
		});
		
		view.setFacultyCourseCommand(new Command() {
			@Override
			public void execute() {
				FacultyCourseNavigationAction fcna = new FacultyCourseNavigationAction();
				FacultyCourseNavigationEvent fcne = new FacultyCourseNavigationEvent(fcna);
				eventBus.fireEvent(fcne); 
			}
		});
		

	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public IndexView getView()
	{
		return view;
	}
	
	@Override
	public void showLoadScreen()
	{
		// thank you stackoverflow
		// https://stackoverflow.com/questions/23017908/gwt-set-the-visibility-of-widget-using-css-visibility-property
		view.getLoadingImage().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
		view.getGlassLoadingPanel().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}
	
	@Override
	public void hideLoadScreen()
	{
		view.getLoadingImage().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
		view.getGlassLoadingPanel().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
}
