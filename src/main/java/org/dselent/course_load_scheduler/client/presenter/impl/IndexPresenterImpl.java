package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.AdminCourseAction;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Model;
import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;
import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;
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
			public void execute() {	
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				AccountDetailsPresenter accountDetailsPresenter = injector.getAccountDetailsPresenter();
				
				accountDetailsPresenter.go(indexView.getViewRootPanel());
			}
		});
		
		view.setViewScheduleCommand(new Command() {
			@Override
			public void execute() {	
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				ScheduleListPresenter scheduleListPresenter = injector.getScheduleListPresenter();
				
				scheduleListPresenter.go(indexView.getViewRootPanel());
			}
		});
		
		view.setSearchScheduleCommand(new Command() {
			@Override
			public void execute() {	
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				SearchSchedulePresenter searchSchedulePresenter = injector.getSearchSchedulePresenter();
				
				searchSchedulePresenter.go(indexView.getViewRootPanel());
			}
		});
		
		view.setCreateScheduleCommand(new Command() {
			@Override
			public void execute() {	
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				// TODO : create schedule first page 
				
			}
		});
		
		view.setCoursesCommand(new Command() {
			@Override
			public void execute() {
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				String userRole = injector.getAccountDetailsPresenter().getUserType();
				
				BasePresenter coursePresenter;
				
				if(userRole.equals("Faculty")) {
					coursePresenter = injector.getFacultyCoursePresenter();
					coursePresenter.init();
					coursePresenter.go(indexView.getViewRootPanel());
				}
				else if (userRole.equals("Admin")){
					AdminCourseAction aca = new AdminCourseAction(new ArrayList<Course>());
					AdminCourseEvent ace = new AdminCourseEvent(aca);
					eventBus.fireEvent(ace);
				} else {
					//TODO exception needed: user role from database doesn't match either "Faculty" or "Admin".
				}
			}
		});
		
		view.setUsersCommand(new Command() {
			@Override
			public void execute() {	
				final Injector injector = Injector.INSTANCE;
				
				
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				UserSearchPresenter userSearchPresenter = injector.getUserSearchPresenter();
				
				userSearchPresenter.go(indexView.getViewRootPanel());
			}
		});
		
		view.setRequestsCommand(new Command() {
			@Override
			public void execute() {	
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		
				
				RequestInboxPresenter requestInboxPresenter = injector.getRequestInboxPresenter();
				
				requestInboxPresenter.go(indexView.getViewRootPanel());
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
	
	// Currently no model
	@Override
	public Model getModel()
	{
		return null;
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
