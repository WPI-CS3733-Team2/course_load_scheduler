package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.FacultyCourseMappingPresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface FacultyCourseMappingView extends BaseView<FacultyCourseMappingPresenter>
{
	CellTable getFacultyCellTable();
	void setFacultyCellTable(CellTable facultyCellTable);
	VerticalPanel getVerticalPanel();
	void setVerticalPanel(VerticalPanel verticalPanel);
}
