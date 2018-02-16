package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.ScheduleSpecificsPresenter;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface ScheduleSpecificsView extends BaseView<ScheduleSpecificsPresenter>
{
	TextBox getReport();
	void setReport(TextBox report);
	Grid getCalendarGrid();
	void setCalendarGrid(Grid calendarGrid);
	VerticalPanel getVerticalPanel();
	void setVerticalPanel(VerticalPanel verticalPanel);
	TabBar getCalendarTabs();
	void setCalendarTabs(TabBar calendarTabs);
	void clearGrid();
	
}
