package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserSearchPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserCreatePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ConfirmSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleListPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleSpecificsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.SearchSchedulePresenterImpl;
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

		AccountDetailsPresenterImpl accountPresenter = injector.getAccountDetailsPresenter();
		accountPresenter.init();
		
		FacultyCoursePresenterImpl facultyCoursePresenter = injector.getFacultyCoursePresenter();
		facultyCoursePresenter.init();
		
		AdminCoursePresenterImpl adminCoursePresenter = injector.getAdminCoursePresenter();
		adminCoursePresenter.init();
		
		CreateModifyCoursePresenterImpl createModifyPresenter = injector.getCreateModifyCoursePresenter();
		createModifyPresenter.init();
		
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


		// indexPresenter.go(RootPanel.get("indexContainer"));
		indexPresenter.go(root);
		adminCoursePresenter.go(indexView.getViewRootPanel());
	}
}
