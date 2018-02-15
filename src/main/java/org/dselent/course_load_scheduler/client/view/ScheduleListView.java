package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.ListBox;

public interface ScheduleListView extends BaseView<ScheduleListPresenter>
{
	ListBox getNavDropDown();
	void setNavDropDown(ListBox navDropDown);
	CellTable<Schedule> getScheduleTable();
	void setScheduleTable(CellTable<Schedule> scheduleTable);
	void initColumns();
}
