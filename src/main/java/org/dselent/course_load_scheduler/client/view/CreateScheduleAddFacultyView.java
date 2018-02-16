package org.dselent.course_load_scheduler.client.view;


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
}
