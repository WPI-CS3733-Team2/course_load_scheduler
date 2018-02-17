package org.dselent.course_load_scheduler.client.view;


import java.util.List;

import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface CreateScheduleAddFacultyView extends BaseView<CreateScheduleAddFacultyPresenter>
{
	VerticalPanel getVerticalPanel();
	void setVerticalPanel(VerticalPanel verticalPanel);
	Label getFacultyLabel();
	void setFacultyLabel(Label facultyLabel);
	Button getNextPageButton();
	void setNextPageButton(Button nextPageButton);
	void addFaculty(List<String> names);
	String getCheckedFaculty();
	void showErrorMessages(String errorMessages);
}
