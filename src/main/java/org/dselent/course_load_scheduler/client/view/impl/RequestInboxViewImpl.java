package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.view.RequestInboxView;
import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class RequestInboxViewImpl extends BaseViewImpl<RequestInboxPresenter> implements RequestInboxView {

	private static RequestInboxViewImplUiBinder uiBinder = GWT.create(RequestInboxViewImplUiBinder.class);
	@UiField VerticalPanel RequestInboxPanel;
	@UiField Button AccountButton;
	@UiField Button CourcesButton;
	@UiField Button SchedulesButton;
	@UiField Button UsersButton;
	@UiField Button InboxButton;
	@UiField Button ApproveButton;
	@UiField Button DenyButton;
	@UiField Button DeleteButton;
	
	@UiField Button request1Button;
	@UiField Button request2Button;
	@UiField Button request3Button;
	@UiField Button request4Button;
	@UiField Button request5Button;
	@UiField Button request6Button;
	@UiField Button request7Button;


	interface RequestInboxViewImplUiBinder extends UiBinder<Widget, RequestInboxViewImpl> {
	}

	public RequestInboxViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public Button getAccountButton() {
		return AccountButton;
	}
	
	@Override
	public Button getCourcesButton() {
		return CourcesButton;
	}
	
	@Override
	public Button getSchedulesButton() {
		return SchedulesButton;
	}
	
	@Override
	public Button getUsersButton() {
		return UsersButton;
	}
	
	@Override
	public Button getInboxButton() {
		return InboxButton;
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
	
	@UiHandler("AccountButton")
	void onAccountButtonClick(ClickEvent event) {
	}
	@UiHandler("CourcesButton")
	void onCourcesButtonClick(ClickEvent event) {
	}
	@UiHandler("SchedulesButton")
	void onSchedulesButtonClick(ClickEvent event) {
	}
	@UiHandler("UsersButton")
	void onUsersButtonClick(ClickEvent event) {
	}
	@UiHandler("InboxButton")
	void onInboxButtonClick(ClickEvent event) {
	}
	@UiHandler("ApproveButton")
	void onApproveButtonClick(ClickEvent event) {
	}
	@UiHandler("DenyButton")
	void onDenyButtonClick(ClickEvent event) {
	}
	@UiHandler("DeleteButton")
	void onDeleteButtonClick(ClickEvent event) {
	}
	@UiHandler("request1Button")
	void onRequest1ButtonClick(ClickEvent event) {
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
