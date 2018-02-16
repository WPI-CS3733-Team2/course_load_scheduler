package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;

import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;

public interface AdminCourseView extends BaseView<AdminCoursePresenter> {
	

	public Grid getAllCoursesGrid();
	
	public void setAllCoursesGrid(Grid allCoursesGrid);
	
	public void addCourseToGrid(DecoratorPanel dp);
	
	public void clearAllCoursesGrid();
	
	public TextBox getSearchCourseTxtBox();

	public void setSearchCourseTxtBox(TextBox searchCourseTxtBox);

	public HTMLPanel getAdminCoursePanel();

	public void setAdminCoursePanel(HTMLPanel adminCoursePanel);

	public void showErrorMessages(String errorMessages);

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();
	
}
