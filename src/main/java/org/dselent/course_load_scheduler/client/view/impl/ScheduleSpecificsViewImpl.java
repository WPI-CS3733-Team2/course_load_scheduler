package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.asm.Label;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Grid;

//public class ScheduleSpecificsViewImpl extends Composite {
	public class ScheduleSpecificsViewImpl extends BaseViewImpl<ScheduleSpecificsPresenter> implements ScheduleSpecificsView {
	
	private static ScheduleSpecificsViewImplUiBinder uiBinder = GWT.create(ScheduleSpecificsViewImplUiBinder.class);
	@UiField TextBox report;
	@UiField VerticalPanel verticalPanel;
	@UiField ListBox navDropDown;
	@UiField Grid calendarGrid;

	interface ScheduleSpecificsViewImplUiBinder extends UiBinder<Widget, ScheduleSpecificsViewImpl> {
	}

	public ScheduleSpecificsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
	}

	
	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}



	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}



	public ListBox getNavDropDown() {
		return navDropDown;
	}



	public void setNavDropDown(ListBox navDropDown) {
		this.navDropDown = navDropDown;
	}



	public TextBox getReport() {
		return report;
	}

	public void setReport(TextBox report) {
		this.report = report;
	}

	public Grid getCalendarGrid() {
		return calendarGrid;
	}

	public void setCalendarGrid(Grid calendarGrid) {
		this.calendarGrid = calendarGrid;
	}

	@Override
	public void setPresenter(ScheduleSpecificsPresenter presenter) {
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
	
	public void initGrid() {
		calendarGrid.resize(14,6);
		calendarGrid.setText(0, 0, "Times");
		calendarGrid.setText(0, 1, "Monday");
		calendarGrid.setText(0, 2, "Tuesday");
		calendarGrid.setText(0, 3, "Wednesday");
		calendarGrid.setText(0, 4, "Thursday");
		calendarGrid.setText(0, 5, "Friday");
		calendarGrid.setText(1, 0, "8:00 am");
		calendarGrid.setText(2, 0, "9:00 am");
		calendarGrid.setText(3, 0, "10:00 am");
		calendarGrid.setText(4, 0, "11:00 am");
		calendarGrid.setText(5, 0, "12:00 pm");
		calendarGrid.setText(6, 0, "1:00 pm");
		calendarGrid.setText(7, 0, "2:00 pm");
		calendarGrid.setText(8, 0, "3:00 pm");
		calendarGrid.setText(9, 0, "4:00 pm");
		calendarGrid.setText(10, 0, "5:00 pm");
		calendarGrid.setText(11, 0, "6:00 pm");
		calendarGrid.setText(12, 0, "7:00 pm");
		calendarGrid.setText(13, 0, "8:00 pm");
		
	}
	
}
