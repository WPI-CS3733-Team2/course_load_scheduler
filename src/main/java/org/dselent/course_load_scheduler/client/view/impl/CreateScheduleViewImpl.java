package org.dselent.course_load_scheduler.client.view.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateScheduleVisualPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleSpecificsPresenterImpl;
import org.dselent.course_load_scheduler.client.view.CreateScheduleView;
import org.dselent.course_load_scheduler.client.view.IndexView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CreateScheduleViewImpl extends BaseViewImpl<CreateSchedulePresenter> implements CreateScheduleView {

	private static CreateScheduleImplUiBinder uiBinder = GWT.create(CreateScheduleImplUiBinder.class);

	interface CreateScheduleImplUiBinder extends UiBinder<Widget, CreateScheduleViewImpl> {
	}
	

	@UiField
	VerticalPanel createSchedulePanel;
	
	@UiField
	TextBox searchTextBox;
	
	@UiField
	Button nextButton;
	
	@UiField
	VerticalPanel coursesVerticalPanel;

	public CreateScheduleViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(CreateSchedulePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}

	public HasWidgets getViewRootPanel() {
		return createSchedulePanel;
	}
	
	public TextBox getSearchTextBox() {
		return searchTextBox;
	}

	public void setSearchTextbox(TextBox searchTextBox) {
		this.searchTextBox = searchTextBox;
	}
	
	public Button getNextButton() {
		return nextButton;
	}

	public VerticalPanel getCoursesVerticalPanel() {
		return coursesVerticalPanel;
	}

	public void setCoursesVerticalPanel(VerticalPanel coursesVerticalPanel) {
		this.coursesVerticalPanel = coursesVerticalPanel;
	}
	
	public void addCourses(List<String> names) {
		for (String name : names) {
			CheckBox checkBox = new CheckBox(name);
			coursesVerticalPanel.add(checkBox);
		}
	}
	
	public List<String> getCheckedCourses() {
		List<String> checkedCourses = new ArrayList<String>();
		for (Widget widget : coursesVerticalPanel) {
			if (widget instanceof CheckBox){
			    CheckBox checkBox = (CheckBox) widget;
			    if (checkBox.getValue()) {
			    	checkedCourses.add(checkBox.getText());
			    }
			}
		}
		return checkedCourses;
	}

	@UiHandler("nextButton")
	public void onButtonClick(ClickEvent event) {
		presenter.goToNextPage(getCheckedCourses());
	}
}
