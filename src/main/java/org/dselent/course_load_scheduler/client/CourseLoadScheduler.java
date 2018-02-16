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
		
		//SimplePanelExample simplePanelExample = new SimplePanelExample();
		//root.add(simplePanelExample);
		
		//SimplePanelExample2 simplePanelExample2 = new SimplePanelExample2();
		//root.add(simplePanelExample2);
		
		//HTMLPanelExample htmlPanelExample = new HTMLPanelExample();
		//root.add(htmlPanelExample);
		
		//FlowPanelExample flowPanelExample = new FlowPanelExample();
		//root.add(flowPanelExample);
		
		//VerticalPanelExample verticalPanelExample = new VerticalPanelExample();
		//root.add(verticalPanelExample);
		
		//HorizontalPanelExample horizontalPanelExample = new HorizontalPanelExample();
		//root.add(horizontalPanelExample);
		
		//DockLayoutPanelExample dockLayoutPanelExample = new DockLayoutPanelExample();
		//root.add(dockLayoutPanelExample);
		
		//GridExample gridExample = new GridExample();
		//root.add(gridExample);

		//TabLayoutPanelExample tabLayoutPanelExample = new TabLayoutPanelExample();
		//root.add(tabLayoutPanelExample);
		
		//ExamplesPanel examplesPanel = new ExamplesPanel();
		//root.add(examplesPanel);

		// Get the injector, which injected objects can be retrieved from
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		indexPresenter.init();

		IndexView indexView = indexPresenter.getView();		
		
		indexPresenter.go(root);

		AdminCoursePresenterImpl adminCoursePresenter = injector.getAdminCoursePresenter();
		adminCoursePresenter.init();
		// LoginView loginView = loginPresenter.getView();

		// indexPresenter.go(RootPanel.get("indexContainer"));
		indexPresenter.go(root);
		adminCoursePresenter.go(indexView.getViewRootPanel());
		/*
		switch (10) {

		case 0:
			LoginPresenterImpl loginPresenter = injector.getLoginPresenter();
			loginPresenter.init();
			//LoginView loginView = loginPresenter.getView();	
			
			//indexPresenter.go(RootPanel.get("indexContainer"));
			//indexPresenter.go(root);
			loginPresenter.go(indexView.getViewRootPanel());
			break;

		case 1:
			FacultyCourseMappingPresenterImpl facultyCourseMappingPresenter = injector.getFacultyCourseMappingPresenter();
			facultyCourseMappingPresenter.init();
			//FacultyCourseMappingView facultyCourseMappingView = facultyCourseMappingPresenter.getView();
			facultyCourseMappingPresenter.go(indexView.getViewRootPanel());
		break;
		case 2:
			SearchSchedulePresenterImpl searchSchedulePresenter = injector.getSearchSchedulePresenter();
			searchSchedulePresenter.init();
			//SearchScheduleView searchScheduleView = searchSchedulePresenter.getView();
			searchSchedulePresenter.go(indexView.getViewRootPanel());
		break;
		case 3:
			ScheduleSpecificsPresenterImpl scheduleSpecificsPresenter = injector.getScheduleSpecificsPresenter();
			scheduleSpecificsPresenter.init();
			//ScheduleSpecificsView scheduleSpecificsView = scheduleSpecificsPresenter.getView();
			scheduleSpecificsPresenter.go(indexView.getViewRootPanel());
		break;
		case 4:
			ScheduleListPresenterImpl scheduleListPresenter = injector.getScheduleListPresenter();
			scheduleListPresenter.init();
			ScheduleListView scheduleListView = scheduleListPresenter.getView();
			scheduleListPresenter.go(indexView.getViewRootPanel());
		break;
		case 5:
			AccountDetailsPresenterImpl accountDetailsPresenter = injector.getAccountDetailsPresenter();
			accountDetailsPresenter.init();
			indexPresenter.go(root);
			accountDetailsPresenter.go(indexView.getViewRootPanel());
		break;
		case 6:
			ChangePasswordPresenterImpl changePasswordPresenter = injector.getChangePasswordPresenter();
			changePasswordPresenter.init();
			indexPresenter.go(root);
			changePasswordPresenter.go(indexView.getViewRootPanel());
		break;
		case 7:
			CreateScheduleVisualPresenterImpl createScheduleVisualPresenter = injector.getCreateScheduleVisualPresenter();
			createScheduleVisualPresenter.init();
			//CreateScheduleVisualView createScheduleVisualView = createScheduleVisualPresenter.getView();
			createScheduleVisualPresenter.go(indexView.getViewRootPanel());
		case 8:
			UserSearchPresenterImpl userSearchPresenter = injector.getUserSearchPresenter();
			userSearchPresenter.init();
			//UserSearchView userSearchView = injector.getUserSearchView();
			userSearchPresenter.go(indexView.getViewRootPanel());
		break;
		case 9:
			ConfirmSchedulePresenterImpl confirmSchedulePresenter = injector.getConfirmSchedulePresenter();
			confirmSchedulePresenter.init();
			//ConfirmScheduleView confirmScheduleView = injector.getConfirmScheduleView();
			confirmSchedulePresenter.go(indexView.getViewRootPanel());
		break;
		case 10:
			CreateSchedulePresenterImpl createSchedulePresenter = injector.getCreateSchedulePresenter();
			createSchedulePresenter.init();
			CreateScheduleView createScheduleView = injector.getCreateScheduleView();
			createSchedulePresenter.go(indexView.getViewRootPanel());
		break;
		}*/
	}
}
