package org.dselent.course_load_scheduler.client.gin;

import org.dselent.course_load_scheduler.client.presenter.CreateScheduleVisualPresenter;
import org.dselent.course_load_scheduler.client.presenter.FacultyCourseMappingPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserDetailsPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleVisualPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCourseMappingPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleListPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleSpecificsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.SearchSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserSearchPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserCreatePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.view.CreateScheduleVisualView;
import org.dselent.course_load_scheduler.client.view.FacultyCourseMappingView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.ScheduleListView;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;
import org.dselent.course_load_scheduler.client.view.UserSearchView;
import org.dselent.course_load_scheduler.client.view.UserCreateView;
import org.dselent.course_load_scheduler.client.view.UserDetailsView;
import org.dselent.course_load_scheduler.client.view.impl.CreateScheduleVisualViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.FacultyCourseMappingViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.IndexViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.LoginViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleListViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleSpecificsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.SearchScheduleViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserSearchViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserCreateViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserDetailsViewImpl;

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
        bind(FacultyCourseMappingPresenter.class).to(FacultyCourseMappingPresenterImpl.class).in(Singleton.class);
        bind(SearchSchedulePresenter.class).to(SearchSchedulePresenterImpl.class).in(Singleton.class);
        bind(ScheduleSpecificsPresenter.class).to(ScheduleSpecificsPresenterImpl.class).in(Singleton.class);
        bind(ScheduleListPresenter.class).to(ScheduleListPresenterImpl.class).in(Singleton.class);
        bind(UserSearchPresenter.class).to(UserSearchPresenterImpl.class).in(Singleton.class);
        bind(UserCreatePresenter.class).to(UserCreatePresenterImpl.class).in(Singleton.class);
        bind(UserDetailsPresenter.class).to(UserDetailsPresenterImpl.class).in(Singleton.class);
        bind(CreateScheduleVisualPresenter.class).to(CreateScheduleVisualPresenterImpl.class).in(Singleton.class);
        
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