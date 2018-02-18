package org.dselent.course_load_scheduler.client.gin;

import org.dselent.course_load_scheduler.client.presenter.impl.ExamplePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleVisualPresenterImpl;
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
import org.dselent.course_load_scheduler.client.view.impl.CreateScheduleVisualViewImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ConfirmSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleAddFacultyPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ChangePasswordPresenterImpl;

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
import org.dselent.course_load_scheduler.client.view.impl.ExampleViewImpl;

import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Interface required by gin due to lack of runtime reflections
 * Provide methods to get all objects that are to be injected
 * 
 * GinModules annotation: indicates what the module file is
 * 
 * @author dselent
 *
 */
@GinModules(InjectorModule.class)
public interface Injector extends Ginjector
{
	// GIN generator will instantiate this
	// GWT.create uses deferred bindings where many permutations are created but only one
	// is used at runtime (the one for the specific browser)
    public static final Injector INSTANCE = GWT.create(Injector.class);
 
    // event bus
    public SimpleEventBus getEventBus();
    
    // presenters
    public IndexPresenterImpl getIndexPresenter();
    public LoginPresenterImpl getLoginPresenter();
    public ExamplePresenterImpl getExamplePresenter();
	public ChangePasswordPresenterImpl getChangePasswordPresenter();
	public AccountDetailsPresenterImpl getAccountDetailsPresenter();
    public FacultyCourseMappingPresenterImpl getFacultyCourseMappingPresenter();
    public SearchSchedulePresenterImpl getSearchSchedulePresenter();
    public ScheduleSpecificsPresenterImpl getScheduleSpecificsPresenter();
    public ScheduleListPresenterImpl getScheduleListPresenter();
    public UserSearchPresenterImpl getUserSearchPresenter();
    public UserCreatePresenterImpl getUserCreatePresenter();
    public UserDetailsPresenterImpl getUserDetailsPresenter();
    public CreateScheduleVisualPresenterImpl getCreateScheduleVisualPresenter();
    public ConfirmSchedulePresenterImpl getConfirmSchedulePresenter();
    public CreateModifyCoursePresenterImpl getCreateModifyCoursePresenter();
    public AdminCoursePresenterImpl getAdminCoursePresenter();
    public FacultyCoursePresenterImpl getFacultyCoursePresenter();
    public RequestCoursePresenterImpl getRequestCoursePresenter();
    public RequestInboxPresenterImpl getRequestInboxPresenter();
    public CreateScheduleAddFacultyPresenterImpl getCreateScheduleAddFacultyPresenter();
    public CreateSchedulePresenterImpl getCreateSchedulePresenter();
         
    //views
    public IndexViewImpl getIndexView();
    public LoginViewImpl getLoginView();
    public ExampleViewImpl getExampleView();
    public ChangePasswordViewImpl getChangePasswordView();
    public AccountDetailsViewImpl getAccountDetailsView();
    public FacultyCourseMappingViewImpl getFacultyCourseMappingView();
    public SearchScheduleViewImpl getSearchScheduleView();
    public ScheduleSpecificsViewImpl getScheduleSpecificsView();
    public ScheduleListViewImpl getScheduleListView();
    public UserSearchViewImpl getUserSearchView();
    public UserCreateViewImpl getUserCreateView();
    public UserDetailsViewImpl getUserDetailsView();
    public CreateScheduleVisualViewImpl getCreateScheduleVisualView();
    public ConfirmScheduleViewImpl getConfirmScheduleView();
    public CreateModifyCourseViewImpl getCreateModifyCourseView();
    public AdminCourseViewImpl getAdminCourseView();
    public FacultyCourseViewImpl getFacultyCourseView();
    public RequestCourseViewImpl getRequestCourseView();
    public RequestInboxViewImpl getRequestInboxView();
    public CreateScheduleAddFacultyViewImpl getCreateScheduleAddFacultyView();
    public CreateScheduleViewImpl getCreateScheduleView();
    
    //services
    public UserServiceImpl getUserService();

}
