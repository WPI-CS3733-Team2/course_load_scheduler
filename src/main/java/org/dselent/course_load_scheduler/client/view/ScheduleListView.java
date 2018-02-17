package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;

import com.google.gwt.user.cellview.client.CellTable;

public interface ScheduleListView extends BaseView<ScheduleListPresenter>
{
	CellTable<Schedule> getScheduleTable();
	void setScheduleTable(CellTable<Schedule> scheduleTable);
	void initColumns();
}
