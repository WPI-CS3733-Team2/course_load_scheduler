package org.dselent.course_load_scheduler.client.view.impl;


import java.util.ArrayList;
import java.util.List;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleAddFacultyView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;

public class CreateScheduleAddFacultyViewImpl extends BaseViewImpl<CreateScheduleAddFacultyPresenter> implements CreateScheduleAddFacultyView {

	private static CreateScheduleAddFacultyViewImplUiBinder uiBinder = GWT
			.create(CreateScheduleAddFacultyViewImplUiBinder.class);

	interface CreateScheduleAddFacultyViewImplUiBinder extends UiBinder<Widget, CreateScheduleAddFacultyViewImpl> {
	}

	public CreateScheduleAddFacultyViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField VerticalPanel verticalPanel;
	@UiField Label facultyLabel;
	@UiField Button nextPageButton;

	public CreateScheduleAddFacultyViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}

	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}

	public Label getFacultyLabel() {
		return facultyLabel;
	}

	public void setFacultyLabel(Label facultyLabel) {
		this.facultyLabel = facultyLabel;
	}

	public Button getNextPageButton() {
		return nextPageButton;
	}

	public void setNextPageButton(Button nextPageButton) {
		this.nextPageButton = nextPageButton;
	}

	@Override
	public HasWidgets getViewRootPanel()
	{
		return verticalPanel;
	}

	
	@Override
	public void setPresenter(CreateScheduleAddFacultyPresenter presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}
	
	public void addFaculty(List<String> names) {
		for (String name : names) {
			RadioButton radioButton = new RadioButton("facultyMember", name);
			verticalPanel.add(radioButton);
		}
	}
	
	@Override
	public String getCheckedFaculty() {
		String checkedFaculty = new String();
		for (Widget widget : verticalPanel) {
			if (widget instanceof RadioButton){
			    RadioButton radioButton = (RadioButton) widget;
			    if (radioButton.getValue()) {
			    	checkedFaculty = radioButton.getText();
			    }
			}
		}
		return checkedFaculty;
	}
	
	@UiHandler("nextPageButton")
	void onButtonClick(ClickEvent event) {
		presenter.fireConfirmSchedulePage();
	}
}
