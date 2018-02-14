package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class FacultyCourseViewImpl extends Composite {

	private static CourseViewImplUiBinder uiBinder = GWT.create(CourseViewImplUiBinder.class);
	@UiField(provided=true) DataGrid<Object> dataGrid = new DataGrid<Object>();
	@UiField Button button;

	interface CourseViewImplUiBinder extends UiBinder<Widget, FacultyCourseViewImpl> {
	}

	public FacultyCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
	}
}
