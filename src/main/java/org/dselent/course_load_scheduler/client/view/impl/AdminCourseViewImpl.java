package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.view.AdminCourseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Grid;

public class AdminCourseViewImpl extends BaseViewImpl<AdminCoursePresenter> implements AdminCourseView {

	private static AdminCourseViewImplUiBinder uiBinder = GWT.create(AdminCourseViewImplUiBinder.class);
	
	interface AdminCourseViewImplUiBinder extends UiBinder<Widget, AdminCourseViewImpl> {
	}
	
	@UiField
	Button addCourseBtn;
	@UiField
	TextBox searchCourseTxtBox;
	@UiField
	HTMLPanel adminCoursePanel;
	@UiField
	Grid allCoursesGrid;
	@UiField
	Button searchCourseButton;

	AdminCoursePresenter presenter;
	
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

	public TextBox getSearchCourseTxtBox() {
		return searchCourseTxtBox;
	}

	public void setSearchCourseTxtBox(TextBox searchCourseTxtBox) {
		this.searchCourseTxtBox = searchCourseTxtBox;
	}

	public HTMLPanel getAdminCoursePanel() {
		return adminCoursePanel;
	}

	public void setAdminCoursePanel(HTMLPanel adminCoursePanel) {
		this.adminCoursePanel = adminCoursePanel;
	}
	
	@Override
	public Button getSearchCourseButton() {
		return searchCourseButton;
	}

	public AdminCourseViewImpl() {
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
		return adminCoursePanel;
	}

	@Override
	public void setPresenter(AdminCoursePresenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("addCourseBtn")
	void onAddCourseBtnClick(ClickEvent event) {
		this.presenter.addCourse();
	}
	@UiHandler("searchCourseButton")
	void onSearchCourseButtonClick(ClickEvent event) {
		presenter.searchCourses();
	}
}
