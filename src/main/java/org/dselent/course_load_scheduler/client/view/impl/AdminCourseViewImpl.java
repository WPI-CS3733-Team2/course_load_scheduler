package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.view.AdminCourseView;
import org.dselent.course_load_scheduler.client.view.IndexView;

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
import com.google.gwt.event.dom.client.KeyUpEvent;

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
	@UiField Button searchCourseButton;

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
		allCoursesGrid.clear();
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

	/*
	 * @UiHandler("modifyCourseBtn") void onModifyCourseBtnClick(ClickEvent event) {
	 * final Injector injector = Injector.INSTANCE;
	 * 
	 * IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); //
	 * on-demand injection IndexView indexView = indexPresenter.getView();
	 * 
	 * CreateModifyCoursePresenterImpl createModifyCoursePresenter =
	 * injector.getCreateModifyCoursePresenter();
	 * 
	 * createModifyCoursePresenter.go(indexView.getViewRootPanel()); }
	 */

	@UiHandler("addCourseBtn")
	void onAddCourseBtnClick(ClickEvent event) {
		final Injector injector = Injector.INSTANCE;

		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();

		CreateModifyCoursePresenterImpl createModifyCoursePresenter = injector.getCreateModifyCoursePresenter();

		createModifyCoursePresenter.go(indexView.getViewRootPanel());
	}
	@UiHandler("searchCourseButton")
	void onSearchCourseButtonClick(ClickEvent event) {
		presenter.searchCourses();
	}
}
