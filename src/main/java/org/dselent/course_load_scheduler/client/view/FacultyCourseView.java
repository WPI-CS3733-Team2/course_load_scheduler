package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;

import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public interface FacultyCourseView extends BaseView<FacultyCoursePresenter> {
	
	public TextBox getSearchCourseTextBox();

	public void setSearchCourseTextBox(TextBox searchCourseTextBox);

	public Grid getAllCoursesGrid();

	public void setAllCoursesGrid(Grid allCoursesGrid);
	
	public void addCourseToGrid(DecoratorPanel dp);
	
	public void clearAllCoursesGrid();
	
	public Button getSearchCourseButton();
		
	public void showErrorMessages(String errorMessages);

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();
	
}
