package org.dselent.course_load_scheduler.client.gin;

import org.dselent.course_load_scheduler.client.presenter.ExamplePresenter;
import org.dselent.course_load_scheduler.client.presenter.AccountDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleVisualPresenter;
import org.dselent.course_load_scheduler.client.presenter.FacultyCourseMappingPresenter;
import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;

import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleVisualPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ExamplePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ChangePasswordPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCourseMappingPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.RequestCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.RequestInboxPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleListPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleSpecificsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.SearchSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserSearchPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserCreatePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ConfirmSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleAddFacultyPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateSchedulePresenterImpl;

import org.dselent.course_load_scheduler.client.view.CreateScheduleVisualView;
import org.dselent.course_load_scheduler.client.view.FacultyCourseMappingView;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.RequestCourseView;
import org.dselent.course_load_scheduler.client.view.RequestInboxView;
import org.dselent.course_load_scheduler.client.view.ScheduleListView;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;
import org.dselent.course_load_scheduler.client.view.UserSearchView;
import org.dselent.course_load_scheduler.client.view.UserCreateView;
import org.dselent.course_load_scheduler.client.view.UserDetailsView;
import org.dselent.course_load_scheduler.client.view.impl.CreateScheduleVisualViewImpl;
import org.dselent.course_load_scheduler.client.view.AdminCourseView;
import org.dselent.course_load_scheduler.client.view.ConfirmScheduleView;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;
import org.dselent.course_load_scheduler.client.view.CreateScheduleAddFacultyView;
import org.dselent.course_load_scheduler.client.view.CreateScheduleView;
import org.dselent.course_load_scheduler.client.view.AccountDetailsView;
import org.dselent.course_load_scheduler.client.view.ChangePasswordView;
import org.dselent.course_load_scheduler.client.view.ExampleView;

import org.dselent.course_load_scheduler.client.view.impl.ExampleViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.AccountDetailsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ChangePasswordViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.FacultyCourseMappingViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.FacultyCourseViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.IndexViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.LoginViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.RequestCourseViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.RequestInboxViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleListViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleSpecificsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.SearchScheduleViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserSearchViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserCreateViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserDetailsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.AdminCourseViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ConfirmScheduleViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.CreateModifyCourseViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.CreateScheduleAddFacultyViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.CreateScheduleViewImpl;
import org.dselent.course_load_scheduler.client.service.FacultyCourseService;
import org.dselent.course_load_scheduler.client.service.UserService;
import org.dselent.course_load_scheduler.client.service.impl.FacultyCourseServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Module where all to-be-injected dependencies are defined
 * 
 * @author dselent
 *
 */
public class InjectorModule extends AbstractGinModule
{
	@Override
    protected void configure()
    {
		// event bus
        bind(SimpleEventBus.class).in(Singleton.class);
        
        // presenters
        bind(IndexPresenter.class).to(IndexPresenterImpl.class).in(Singleton.class);
        bind(LoginPresenter.class).to(LoginPresenterImpl.class).in(Singleton.class);
        bind(ExamplePresenter.class).to(ExamplePresenterImpl.class).in(Singleton.class);
        bind(ChangePasswordPresenter.class).to(ChangePasswordPresenterImpl.class).in(Singleton.class);
        bind(AccountDetailsPresenter.class).to(AccountDetailsPresenterImpl.class).in(Singleton.class);    
        bind(FacultyCourseMappingPresenter.class).to(FacultyCourseMappingPresenterImpl.class).in(Singleton.class);
        bind(SearchSchedulePresenter.class).to(SearchSchedulePresenterImpl.class).in(Singleton.class);
        bind(ScheduleSpecificsPresenter.class).to(ScheduleSpecificsPresenterImpl.class).in(Singleton.class);
        bind(ScheduleListPresenter.class).to(ScheduleListPresenterImpl.class).in(Singleton.class);
        bind(UserSearchPresenter.class).to(UserSearchPresenterImpl.class).in(Singleton.class);
        bind(UserCreatePresenter.class).to(UserCreatePresenterImpl.class).in(Singleton.class);
        bind(UserDetailsPresenter.class).to(UserDetailsPresenterImpl.class).in(Singleton.class);
        bind(CreateScheduleVisualPresenter.class).to(CreateScheduleVisualPresenterImpl.class).in(Singleton.class);
        bind(ConfirmSchedulePresenter.class).to(ConfirmSchedulePresenterImpl.class).in(Singleton.class);
        bind(CreateModifyCoursePresenter.class).to(CreateModifyCoursePresenterImpl.class).in(Singleton.class);
        bind(AdminCoursePresenter.class).to(AdminCoursePresenterImpl.class).in(Singleton.class);
        bind(FacultyCoursePresenter.class).to(FacultyCoursePresenterImpl.class).in(Singleton.class);
        bind(RequestCoursePresenter.class).to(RequestCoursePresenterImpl.class).in(Singleton.class);
        bind(RequestInboxPresenter.class).to(RequestInboxPresenterImpl.class).in(Singleton.class);
        bind(CreateScheduleAddFacultyPresenter.class).to(CreateScheduleAddFacultyPresenterImpl.class).in(Singleton.class);
        bind(CreateSchedulePresenter.class).to(CreateSchedulePresenterImpl.class).in(Singleton.class);

        // views
        bind(IndexView.class).to(IndexViewImpl.class).in(Singleton.class);
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(FacultyCourseMappingView.class).to(FacultyCourseMappingViewImpl.class).in(Singleton.class);
        bind(SearchScheduleView.class).to(SearchScheduleViewImpl.class).in(Singleton.class);
        bind(ScheduleSpecificsView.class).to(ScheduleSpecificsViewImpl.class).in(Singleton.class);
        bind(ScheduleListView.class).to(ScheduleListViewImpl.class).in(Singleton.class);
        bind(UserSearchView.class).to(UserSearchViewImpl.class).in(Singleton.class);
        bind(UserCreateView.class).to(UserCreateViewImpl.class).in(Singleton.class);
        bind(UserDetailsView.class).to(UserDetailsViewImpl.class).in(Singleton.class);
        bind(CreateScheduleVisualView.class).to(CreateScheduleVisualViewImpl.class).in(Singleton.class);
        bind(ConfirmScheduleView.class).to(ConfirmScheduleViewImpl.class).in(Singleton.class);
        bind(CreateModifyCourseView.class).to(CreateModifyCourseViewImpl.class).in(Singleton.class);
        bind(AdminCourseView.class).to(AdminCourseViewImpl.class).in(Singleton.class);
        bind(FacultyCourseView.class).to(FacultyCourseViewImpl.class).in(Singleton.class);
        bind(RequestCourseView.class).to(RequestCourseViewImpl.class).in(Singleton.class);
        bind(RequestInboxView.class).to(RequestInboxViewImpl.class).in(Singleton.class);
        bind(ChangePasswordView.class).to(ChangePasswordViewImpl.class).in(Singleton.class);
        bind(AccountDetailsView.class).to(AccountDetailsViewImpl.class).in(Singleton.class);
        bind(CreateScheduleAddFacultyView.class).to(CreateScheduleAddFacultyViewImpl.class).in(Singleton.class);
        bind(CreateScheduleView.class).to(CreateScheduleViewImpl.class).in(Singleton.class);
        bind(ExampleView.class).to(ExampleViewImpl.class).in(Singleton.class);
        
        //services
        bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);
        bind(FacultyCourseService.class).to(FacultyCourseServiceImpl.class).in(Singleton.class);
    }
	
	/*
	 * Tried playing with this but had unresolved issues
	@Provides @Singleton @Inject
	public LoginPresenter provideLoginPresenter(IndexPresenter parentPresenter)
	{
	    return new LoginPresenter(parentPresenter);
	}
	*/
}