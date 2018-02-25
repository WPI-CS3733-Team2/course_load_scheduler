package org.dselent.course_load_scheduler.client.view.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.presenter.CreateSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
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
		searchTextBox.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	            if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	              presenter.results();
	            }
	          }
	        });
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
	
	public List<Integer> getCheckedCourses() {
		List<Integer> checkedCourses = new ArrayList<Integer>();
		int i = 0;
		for (Widget widget : coursesVerticalPanel) {
			if (widget instanceof CheckBox){
			    CheckBox checkBox = (CheckBox) widget;
			    if (checkBox.getValue()) {
			    	checkedCourses.add(i);
			    }
			    i++;
			}
		}
		return checkedCourses;
	} 

	@UiHandler("nextButton")
	public void onButtonClick(ClickEvent event) {
		if(getCheckedCourses().isEmpty()) {
			showErrorMessages("At least 1 course must be selected.");
		}else {
			presenter.goToNextPage(getCheckedCourses());
		}
	}
}
