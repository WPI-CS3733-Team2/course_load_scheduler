package org.dselent.course_load_scheduler.client.view.impl;
import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;

public class FacultyCourseViewImpl extends BaseViewImpl<FacultyCoursePresenter> implements FacultyCourseView {

	private static FacultyCourseViewImplUiBinder uiBinder = GWT.create(FacultyCourseViewImplUiBinder.class);
	
	interface FacultyCourseViewImplUiBinder extends UiBinder<Widget, FacultyCourseViewImpl> {
	}
	
	@UiField
	TextBox searchCourseTextBox;
	@UiField
	HTMLPanel facultyCoursePanel;
	@UiField
	Grid allCoursesGrid;
	@UiField Button searchCourseButton;

	public TextBox getSearchCourseTextBox() {
		return searchCourseTextBox;
	}

	public void setSearchCourseTextBox(TextBox searchCourseTextBox) {
		this.searchCourseTextBox = searchCourseTextBox;
	}

	public Grid getAllCoursesGrid() {
		return allCoursesGrid;
	}

	public void setAllCoursesGrid(Grid allCoursesGrid) {
		this.allCoursesGrid = allCoursesGrid;
	}
	
	public void addCourseToGrid(DecoratorPanel dp) {
		int newRow = allCoursesGrid.getRowCount();
		allCoursesGrid.insertRow(newRow);
		allCoursesGrid.setWidget(newRow, 0, dp);
	}
	
	public void clearAllCoursesGrid() {
		while(allCoursesGrid.getRowCount() > 0) {
			allCoursesGrid.removeRow(0);
		}
	}
	
	@Override
	public Button getSearchCourseButton() {
		return searchCourseButton;
	}

	public FacultyCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		allCoursesGrid.insertRow(0);
		allCoursesGrid.resizeColumns(1);
	}

	@Override
	public void showErrorMessages(String errorMessages) {
		Window.alert(errorMessages);
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return facultyCoursePanel;
	}

	@Override
	public void setPresenter(FacultyCoursePresenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("searchCourseButton")
	void onSearchCourseButtonClick(ClickEvent event) {
		presenter.searchCourses();
	}
}
