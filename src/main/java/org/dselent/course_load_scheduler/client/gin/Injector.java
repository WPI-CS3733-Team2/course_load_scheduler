package org.dselent.course_load_scheduler.client.gin;

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
import org.dselent.course_load_scheduler.client.view.impl.CreateScheduleVisualViewImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ConfirmSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.view.impl.FacultyCourseMappingViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.IndexViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.LoginViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleListViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleSpecificsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.SearchScheduleViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserSearchViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserCreateViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.UserDetailsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ConfirmScheduleViewImpl;

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
    public FacultyCourseMappingPresenterImpl getFacultyCourseMappingPresenter();
    public SearchSchedulePresenterImpl getSearchSchedulePresenter();
    public ScheduleSpecificsPresenterImpl getScheduleSpecificsPresenter();
    public ScheduleListPresenterImpl getScheduleListPresenter();
    public UserSearchPresenterImpl getUserSearchPresenter();
    public UserCreatePresenterImpl getUserCreatePresenter();
    public UserDetailsPresenterImpl getUserDetailsPresenter();
    public CreateScheduleVisualPresenterImpl getCreateScheduleVisualPresenter();
    public ConfirmSchedulePresenterImpl getConfirmSchedulePresenter();
         
    //views
    public IndexViewImpl getIndexView();
    public LoginViewImpl getLoginView();
    public FacultyCourseMappingViewImpl getFacultyCourseMappingView();
    public SearchScheduleViewImpl getSearchScheduleView();
    public ScheduleSpecificsViewImpl getScheduleSpecificsView();
    public ScheduleListViewImpl getScheduleListView();
    public UserSearchViewImpl getUserSearchView();
    public UserCreateViewImpl getUserCreateView();
    public UserDetailsViewImpl getUserDetailsView();
    public CreateScheduleVisualViewImpl getCreateScheduleVisualView();
    public ConfirmScheduleViewImpl getConfirmScheduleView();
}
