package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.CreateScheduleVisualPresenter;
import org.dselent.course_load_scheduler.client.view.CreateScheduleVisualView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;

//public class CreateScheduleVisualViewImpl extends Composite implements HasText {
public class CreateScheduleVisualViewImpl extends BaseViewImpl<CreateScheduleVisualPresenter> implements CreateScheduleVisualView {

	private static CreateScheduleVisualViewImplUiBinder uiBinder = GWT
			.create(CreateScheduleVisualViewImplUiBinder.class);
	@UiField ListBox navDropDown;
	@UiField Label confirmLabel;
	@UiField Grid scheduleGrid;
	@UiField Button nextPageButton;
	@UiField VerticalPanel verticalPanel;
	@UiField TabBar calendarTabs;

	interface CreateScheduleVisualViewImplUiBinder extends UiBinder<Widget, CreateScheduleVisualViewImpl> {
	}

	public CreateScheduleVisualViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}
	
	public TabBar getCalendarTabs() {
		return calendarTabs;
	}

	public void setCalendarTabs(TabBar calendarTabs) {
		this.calendarTabs = calendarTabs;
	}

	public ListBox getNavDropDown() {
		return navDropDown;
	}

	public void setNavDropDown(ListBox navDropDown) {
		this.navDropDown = navDropDown;
	}

	public Label getConfirmLabel() {
		return confirmLabel;
	}

	public void setConfirmLabel(Label confirmLabel) {
		this.confirmLabel = confirmLabel;
	}

	public Grid getScheduleGrid() {
		return scheduleGrid;
	}

	public void setScheduleGrid(Grid scheduleGrid) {
		this.scheduleGrid = scheduleGrid;
	}

	public Button getNextPageButton() {
		return nextPageButton;
	}

	public void setNextPageButton(Button nextPageButton) {
		this.nextPageButton = nextPageButton;
	}

	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}

	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}

	public void initGrid() {
		scheduleGrid.resize(14,6);
		scheduleGrid.setText(0, 0, "Times");
		scheduleGrid.setText(0, 1, "Monday");
		scheduleGrid.setText(0, 2, "Tuesday");
		scheduleGrid.setText(0, 3, "Wednesday");
		scheduleGrid.setText(0, 4, "Thursday");
		scheduleGrid.setText(0, 5, "Friday");
		scheduleGrid.setText(1, 0, "8:00 am");
		scheduleGrid.setText(2, 0, "9:00 am");
		scheduleGrid.setText(3, 0, "10:00 am");
		scheduleGrid.setText(4, 0, "11:00 am");
		scheduleGrid.setText(5, 0, "12:00 pm");
		scheduleGrid.setText(6, 0, "1:00 pm");
		scheduleGrid.setText(7, 0, "2:00 pm");
		scheduleGrid.setText(8, 0, "3:00 pm");
		scheduleGrid.setText(9, 0, "4:00 pm");
		scheduleGrid.setText(10, 0, "5:00 pm");
		scheduleGrid.setText(11, 0, "6:00 pm");
		scheduleGrid.setText(12, 0, "7:00 pm");
		scheduleGrid.setText(13, 0, "8:00 pm");
		
	}

	@Override
	public void setPresenter(CreateScheduleVisualPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}


	@Override
	public HasWidgets getViewRootPanel()
	{
		return verticalPanel;
	}
	
	public void initTabs() {
		calendarTabs.addTab("A Term");
		calendarTabs.addTab("B Term");
		calendarTabs.addTab("C Term");
		calendarTabs.addTab("D Term");
		calendarTabs.addTab("Fall Semester");
		calendarTabs.addTab("Spring Semester");
		calendarTabs.selectTab(0, false);
	}
	
	public void clearGrid() {
		for(int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 5; j++) {
				scheduleGrid.clearCell(i, j);
			}
		}
	}

	@UiHandler("calendarTabs")
	void onTabSelected(SelectionEvent<Integer> evt)
	{
		presenter.updateGrid();
	}
	
}
