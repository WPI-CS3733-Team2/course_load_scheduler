package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface SearchScheduleView extends BaseView<SearchSchedulePresenter>
{
	VerticalPanel getVerticalPanel();
	void setVerticalPanel(VerticalPanel verticalPanel);
	ListBox getNavDropDown();
	void setNavDropDown(ListBox navDropDown);
	TextBox getSearchBar();
	void setSearchBar(TextBox searchBar);
	RadioButton getByFaculty();
	void setByFaculty(RadioButton byFaculty);
	RadioButton getByCourse();
	void setByCourse(RadioButton byCourse);
	RadioButton getBySemester();
	void setBySemester(RadioButton bySemester);
	RadioButton getByScheduleName();
	void setByScheduleName(RadioButton byScheduleName);
	
}
