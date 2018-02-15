package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;

public interface ConfirmScheduleView extends BaseView<ConfirmSchedulePresenter>{
	void showErrorMessages(String errorMessages);
}
