package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.view.RequestInboxView;
import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class RequestInboxViewImpl extends BaseViewImpl<RequestInboxPresenter> implements RequestInboxView {
	
	private static RequestInboxViewImplUiBinder uiBinder = GWT.create(RequestInboxViewImplUiBinder.class);
	@UiField VerticalPanel RequestInboxPanel;
	@UiField Button ApproveButton;
	@UiField Button DenyButton;
	@UiField Button DeleteButton;
	@UiField FlexTable RequestListFlexTable;
	
	@UiField Label detailCourseLabel;
	@UiField Label detailSectionLabel;
	@UiField Label detailFacultyIdLabel;
	@UiField Label detailRequestIdLabel;
	@UiField Label detailMessageLabel;
	


	interface RequestInboxViewImplUiBinder extends UiBinder<Widget, RequestInboxViewImpl> {
	}

	public RequestInboxViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public Button getApproveButton() {
		return ApproveButton;
	}
	
	@Override
	public Button getDenyButton() {
		return DenyButton;
	}
	
	@Override
	public Button getDeleteButton() {
		return DeleteButton;
	}
	
	@Override
	public FlexTable getRequestListFlexTable() {
		return this.RequestListFlexTable;
	}
	// setter fcns
	@Override
	public void setDetailCourseLabel(String text) {
		this.detailCourseLabel.setText(text);
	}
	
	@Override
	public void setDetailSectionLabel(String text) {
		this.detailSectionLabel.setText(text);
	}
	
	@Override
	public void setDetailFacultyIdLabel(String text) {
		this.detailFacultyIdLabel.setText(text);
	}
	
	@Override
	public void setDetailRequestIdLabel(String text) {
		this.detailRequestIdLabel.setText(text);
	}
	
	@Override
	public void setDetailMessageLabel(String text) {
		this.detailMessageLabel.setText(text);
	}
	//

	@UiHandler("ApproveButton")
	void onApproveButtonClick(ClickEvent event) {
		presenter.onClickChangeStateButton(1);
	}
	
	@UiHandler("DenyButton")
	void onDenyButtonClick(ClickEvent event) {
		presenter.onClickChangeStateButton(2);
	}
	
	@UiHandler("DeleteButton")
	void onDeleteButtonClick(ClickEvent event) {
		presenter.onClickChangeStateButton(4);
	}

	@Override
	public void setPresenter(RequestInboxPresenter presenter) {
		this.presenter = presenter;	
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return RequestInboxPanel;
	}
}
