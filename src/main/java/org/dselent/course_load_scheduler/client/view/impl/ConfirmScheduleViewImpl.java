package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.ConfirmSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ConfirmScheduleView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ConfirmScheduleViewImpl extends BaseViewImpl<ConfirmSchedulePresenter> implements ConfirmScheduleView {

	private static ConfirmScheduleViewImplUiBinder uiBinder = GWT.create(ConfirmScheduleViewImplUiBinder.class);
	@UiField VerticalPanel confirmSchedulePanel;
	@UiField Label confirmScheduleHeader;
	@UiField TextBox courseInformationBox;
	@UiField TextBox scheduleNameBox;
	@UiField Button confirmScheduleButton;
	@UiField Label scheduleNameLabel;

	interface ConfirmScheduleViewImplUiBinder extends UiBinder<Widget, ConfirmScheduleViewImpl> {
	}

	public ConfirmScheduleViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("confirmScheduleButton")
	void onConfirmScheduleButtonClick(ClickEvent event) {
	}
	
	@Override
	public void setPresenter(ConfirmSchedulePresenter presenter)
	{
		this.presenter = presenter;
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
		return confirmSchedulePanel;
	}
}
