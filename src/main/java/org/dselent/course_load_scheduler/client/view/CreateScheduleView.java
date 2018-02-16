package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface CreateScheduleView extends BaseView<CreateSchedulePresenter>{

	TextBox getSearchTextBox();

	void setSearchTextbox(TextBox searchTextBox);

	Button getNextButton();

}
