package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;

public interface CreateModifyCourseView extends BaseView<CreateModifyCoursePresenter> {
	
	public TextBox getCourseNameTextBox();

	public void setCourseNameTextBox(TextBox courseNameTextBox);

	public TextBox getCourseNumberTextBox();

	public void setCourseNumberTextBox(TextBox courseNumberTextBox);

	public TextBox getSectionNameTextBox();

	public void setSectionNameTextBox(TextBox sectionNameTextBox);

	public TextBox getCrnTextBox();

	public void setCrnTextBox(TextBox crnTextBox);

	public TextBox getTypeTextBox();

	public void setTypeTextBox(TextBox typeTextBox);

	public TextBox getPopTextBox();

	public void setPopTextBox(TextBox popTextBox);

	public TextBox getFreqTextBox();
	
	public void setFreqTextBox(TextBox freqTextBox);
	
	public void showErrorMessages(String errorMessages);

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();
	
}
