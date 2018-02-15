package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.presenter.ScheduleListPresenter;
import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleListView;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ScheduleListViewImpl extends BaseViewImpl<ScheduleListPresenter> implements ScheduleListView {

	private static ScheduleListViewImplUiBinder uiBinder = GWT.create(ScheduleListViewImplUiBinder.class);
	@UiField ListBox navDropDown;
	@UiField CellTable<Schedule> scheduleTable;
	@UiField VerticalPanel verticalPanel;
	
	interface ScheduleListViewImplUiBinder extends UiBinder<Widget, ScheduleListViewImpl> {
	}

	public ScheduleListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initColumns();
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

	public CellTable<Schedule> getScheduleTable() {
		return scheduleTable;
	}

	public void setScheduleTable(CellTable<Schedule> scheduleTable) {
		this.scheduleTable = scheduleTable;
	}

	@Override
	public void setPresenter(ScheduleListPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return verticalPanel;
	}

	public void initColumns() {
		TextColumn<Schedule> scheduleNameColumn = new TextColumn<Schedule>() {
			@Override
			public String getValue(Schedule schedule) {
				return schedule.getScheduleName();
			}
		};
		scheduleNameColumn.setSortable(true);
		this.scheduleTable.addColumn(scheduleNameColumn, "Name");
		ButtonCell buttonCell = new ButtonCell();
		Column buttonColumn = new Column<Schedule, String>(buttonCell) {
		  @Override
		  public String getValue(Schedule schedule) {
		    return "Select";
		  }
		};
		this.scheduleTable.addColumn(buttonColumn, "View Details");
	}
	
}
