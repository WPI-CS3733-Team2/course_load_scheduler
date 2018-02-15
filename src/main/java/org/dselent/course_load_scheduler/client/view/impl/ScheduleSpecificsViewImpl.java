package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleSpecificsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TabBar;

//public class ScheduleSpecificsViewImpl extends Composite {
	public class ScheduleSpecificsViewImpl extends BaseViewImpl<ScheduleSpecificsPresenter> implements ScheduleSpecificsView {
	
	private static ScheduleSpecificsViewImplUiBinder uiBinder = GWT.create(ScheduleSpecificsViewImplUiBinder.class);
	@UiField TextBox report;
	@UiField VerticalPanel verticalPanel;
	@UiField ListBox navDropDown;
	@UiField Grid calendarGrid;
	@UiField TabBar calendarTabs;

	interface ScheduleSpecificsViewImplUiBinder extends UiBinder<Widget, ScheduleSpecificsViewImpl> {
	}

	public ScheduleSpecificsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initGrid();
		initTabs();
	}
	
	public TabBar getCalendarTabs() {
		return calendarTabs;
	}

	public void setCalendarTabs(TabBar calendarTabs) {
		this.calendarTabs = calendarTabs;
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
				calendarGrid.clearCell(i, j);
			}
		}
	}

	@UiHandler("calendarTabs")
	void onTabSelected(SelectionEvent<Integer> evt)
	{
		presenter.updateGrid();
	}

}
