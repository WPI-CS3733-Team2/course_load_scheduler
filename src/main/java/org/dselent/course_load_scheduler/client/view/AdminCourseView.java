package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;

public interface AdminCourseView extends BaseView<AdminCoursePresenter> {
		
	public void showErrorMessages(String errorMessages);

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();
	
}
