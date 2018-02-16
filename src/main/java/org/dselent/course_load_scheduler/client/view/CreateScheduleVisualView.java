package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.CreateScheduleVisualPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface CreateScheduleVisualView extends BaseView<CreateScheduleVisualPresenter>
{
	Grid getScheduleGrid();
	void setScheduleGrid(Grid scheduleGrid);
	VerticalPanel getVerticalPanel();
	void setVerticalPanel(VerticalPanel verticalPanel);
	Button getNextPageButton();
	void setNextPageButton(Button nextPageButton);
	TabBar getCalendarTabs();
	void setCalendarTabs(TabBar calendarTabs);
	void clearGrid();
}
