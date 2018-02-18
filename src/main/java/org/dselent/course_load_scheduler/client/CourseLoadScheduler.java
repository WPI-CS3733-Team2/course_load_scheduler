package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.impl.ExamplePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.ChangePasswordPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleAddFacultyPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleVisualPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCourseMappingPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserSearchPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserCreatePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ConfirmSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.RequestCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleListPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleSpecificsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.SearchSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;
import org.dselent.course_load_scheduler.client.view.IndexView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CourseLoadScheduler implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		RootLayoutPanel root = RootLayoutPanel.get();

		// Get the injector, which injected objects can be retrieved from
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		indexPresenter.init();

		IndexView indexView = indexPresenter.getView();		
		
		indexPresenter.go(root);
		
		ExamplePresenterImpl examplePresenter = injector.getExamplePresenter();
		examplePresenter.init();
		
		UserServiceImpl userService = injector.getUserService();
		userService.init();

		AccountDetailsPresenterImpl accountPresenter = injector.getAccountDetailsPresenter();
		accountPresenter.init();
		
		FacultyCoursePresenterImpl facultyCoursePresenter = injector.getFacultyCoursePresenter();
		facultyCoursePresenter.init();
		
		AdminCoursePresenterImpl adminCoursePresenter = injector.getAdminCoursePresenter();
		adminCoursePresenter.init();
		
		CreateModifyCoursePresenterImpl createModifyPresenter = injector.getCreateModifyCoursePresenter();
		createModifyPresenter.init();

		RequestCoursePresenterImpl requestPresenter = injector.getRequestCoursePresenter();
		requestPresenter.init();
		
		ScheduleListPresenterImpl scheduleListPresenter = injector.getScheduleListPresenter();
		scheduleListPresenter.init();
		
		SearchSchedulePresenterImpl searchSchedulePresenter = injector.getSearchSchedulePresenter();
		searchSchedulePresenter.init();
		
		ScheduleSpecificsPresenterImpl scheduleSpecificsPresenter = injector.getScheduleSpecificsPresenter();
		scheduleSpecificsPresenter.init();

		UserSearchPresenterImpl userSearchPresenter = injector.getUserSearchPresenter();
		userSearchPresenter.init();
		
		UserCreatePresenterImpl userCreatePresenter = injector.getUserCreatePresenter();
		userCreatePresenter.init();
		
		UserDetailsPresenterImpl userDetailsPresenter = injector.getUserDetailsPresenter();
		userDetailsPresenter.init();
		
		ConfirmSchedulePresenterImpl confirmSchedulePresenter = injector.getConfirmSchedulePresenter();
		confirmSchedulePresenter.init();
		
		CreateSchedulePresenterImpl createSchedulePresenter = injector.getCreateSchedulePresenter();
		createSchedulePresenter.init();

		CreateScheduleVisualPresenterImpl createScheduleVisualPresenter = injector.getCreateScheduleVisualPresenter();
		createScheduleVisualPresenter.init();
		
		CreateScheduleAddFacultyPresenterImpl createScheduleAddFacultyPresenter = injector.getCreateScheduleAddFacultyPresenter();
		createScheduleAddFacultyPresenter.init();
		
		FacultyCourseMappingPresenterImpl facultyCourseMappingPresenter = injector.getFacultyCourseMappingPresenter();
		facultyCourseMappingPresenter.init();


		// indexPresenter.go(RootPanel.get("indexContainer"));
		indexPresenter.go(root);
		accountPresenter.go(indexView.getViewRootPanel());
		
		ChangePasswordPresenter changePasswordPresenter = injector.getChangePasswordPresenter();
		changePasswordPresenter.init();

	}
}
