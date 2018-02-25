package org.dselent.course_load_scheduler.client.view;

import java.util.List;

import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface CreateScheduleView extends BaseView<CreateSchedulePresenter>{

	TextBox getSearchTextBox();
	void setSearchTextbox(TextBox searchTextBox);
	Button getNextButton();
	VerticalPanel getCoursesVerticalPanel();
	void setCoursesVerticalPanel(VerticalPanel coursesVerticalPanel);
	void onButtonClick(ClickEvent event);
	void addCourses(List<String> names);
	List<Integer> getCheckedCourses();
	void showErrorMessages(String errorMessages);

}
