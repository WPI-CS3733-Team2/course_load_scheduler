package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;

public class AdminCourseViewImpl extends Composite {

	private static CourseViewImplUiBinder uiBinder = GWT.create(CourseViewImplUiBinder.class);
	@UiField(provided=true) DataGrid<Object> dataGrid = new DataGrid<Object>();

	interface CourseViewImplUiBinder extends UiBinder<Widget, AdminCourseViewImpl> {
	}

	public AdminCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
