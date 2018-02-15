package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.RequestCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;
import org.dselent.course_load_scheduler.client.view.IndexView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

public class FacultyCourseViewImpl extends BaseViewImpl<FacultyCoursePresenter> implements FacultyCourseView {

	private static FacultyCourseViewImplUiBinder uiBinder = GWT.create(FacultyCourseViewImplUiBinder.class);
	@UiField(provided=true) DataGrid<Object> sectionGrid = new DataGrid<Object>();
	@UiField Button requestCourseBtn;
	@UiField TextBox searchCourseTextBox;
	@UiField HTMLPanel facultyCoursePanel;
	@UiField Label courseNameLabel;
	@UiField Label courseNumberLabel;

	interface FacultyCourseViewImplUiBinder extends UiBinder<Widget, FacultyCourseViewImpl> {
	}

	public FacultyCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("requestCourseBtn")
	void onRequestCourseBtnClick(ClickEvent event) {
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();		

		RequestCoursePresenterImpl requestCoursePresenter = injector.getRequestCoursePresenter();
		
		requestCoursePresenter.go(indexView.getViewRootPanel());
	}

	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return facultyCoursePanel;
	}

	@Override
	public void setPresenter(FacultyCoursePresenter presenter) {
		this.presenter = presenter;
	}

}
