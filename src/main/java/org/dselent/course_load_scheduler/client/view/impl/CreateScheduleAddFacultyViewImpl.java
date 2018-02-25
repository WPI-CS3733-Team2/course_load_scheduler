package org.dselent.course_load_scheduler.client.view.impl;

import java.util.List;
import org.dselent.course_load_scheduler.client.presenter.CreateScheduleAddFacultyPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleAddFacultyView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ScrollPanel;

public class CreateScheduleAddFacultyViewImpl extends BaseViewImpl<CreateScheduleAddFacultyPresenter> implements CreateScheduleAddFacultyView {

	private static CreateScheduleAddFacultyViewImplUiBinder uiBinder = GWT
			.create(CreateScheduleAddFacultyViewImplUiBinder.class);

	interface CreateScheduleAddFacultyViewImplUiBinder extends UiBinder<Widget, CreateScheduleAddFacultyViewImpl> {
	}

	public CreateScheduleAddFacultyViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField VerticalPanel innerVerticalPanel;
	@UiField ScrollPanel scrollPanel;
	@UiField VerticalPanel verticalPanel;
	@UiField Label facultyLabel;
	@UiField Button nextPageButton;
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}

	public CreateScheduleAddFacultyViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ScrollPanel getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(ScrollPanel scrollPanel) {
		this.scrollPanel = scrollPanel;
	}
	
	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}

	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}

	public VerticalPanel getInnerVerticalPanel() {
		return innerVerticalPanel;
	}

	public void setInnerVerticalPanel(VerticalPanel innerVerticalPanel) {
		this.innerVerticalPanel = innerVerticalPanel;
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
			innerVerticalPanel.add(radioButton);
		}
	}
	
	@Override
	public Integer getCheckedFaculty() {
		Integer checkedFaculty = -1;
		int i = 0;
		for (Widget widget : innerVerticalPanel) {
			if (widget instanceof RadioButton){
			    RadioButton radioButton = (RadioButton) widget;
			    if (radioButton.getValue()) {
			    	checkedFaculty = i;
			    }
				i++;
			}
		}
		return checkedFaculty;
	}
	
	@UiHandler("nextPageButton")
	void onButtonClick(ClickEvent event) {
		if(getCheckedFaculty() == -1) {
			showErrorMessages("Must select a faculty.");
		}else {
			presenter.fireConfirmSchedulePage();
		}
	}
}
