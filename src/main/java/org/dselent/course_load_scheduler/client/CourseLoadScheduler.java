package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountDetailsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ChangePasswordPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ConfirmSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleVisualPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCourseMappingPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.RequestCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleListPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleSpecificsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.SearchSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserSearchPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateSchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.view.CreateScheduleView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.ScheduleListView;

/*
import org.dselent.course_load_scheduler.client.view.ConfirmScheduleView;
import org.dselent.course_load_scheduler.client.view.CreateScheduleVisualView;
>>>>>>> c95ae7a641c5581c0e7af174d3d8e7698a0d374a
import org.dselent.course_load_scheduler.client.view.FacultyCourseMappingView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.ScheduleListView;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;
import org.dselent.course_load_scheduler.client.view.UserSearchView;
*/
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

		AdminCoursePresenterImpl adminCoursePresenter = injector.getAdminCoursePresenter();
		adminCoursePresenter.init();

		// indexPresenter.go(RootPanel.get("indexContainer"));
		indexPresenter.go(root);
		adminCoursePresenter.go(indexView.getViewRootPanel());
	}
}
