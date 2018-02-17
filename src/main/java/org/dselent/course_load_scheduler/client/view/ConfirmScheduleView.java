package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Button;

public interface ConfirmScheduleView extends BaseView<ConfirmSchedulePresenter>{
	void showErrorMessages(String errorMessages);
	TextBox getScheduleNameBox();
	Button getConfirmScheduleButton();
	TextArea getCourseInformationBox();
}
