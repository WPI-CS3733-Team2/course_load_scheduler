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
