package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.LoadPendingRequestListAction;
import org.dselent.course_load_scheduler.client.action.ReceiveChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.action.ReceivePendingRequestListAction;
import org.dselent.course_load_scheduler.client.action.ReceiveRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.action.SendChangeRequestStateAction;
import org.dselent.course_load_scheduler.client.action.SendRequestsDetailsAction;
import org.dselent.course_load_scheduler.client.event.LoadPendingRequestListEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangeRequestStateEvent;
import org.dselent.course_load_scheduler.client.event.ReceivePendingRequestListEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveRequestsDetailsEvent;
import org.dselent.course_load_scheduler.client.event.RequestInboxNavigationEvent;
import org.dselent.course_load_scheduler.client.event.SendChangeRequestStateEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestsDetailsEvent;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.model.RequestInfo;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.RequestInboxPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.RequestInboxView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;

public class RequestInboxPresenterImpl extends BasePresenterImpl implements RequestInboxPresenter {

	private IndexPresenter parentPresenter;
	private RequestInboxView view;
	private int selectRequestId;
	
	@Inject
	public RequestInboxPresenterImpl(IndexPresenter parentPresenter, RequestInboxView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.selectRequestId = 0;
		view.setPresenter(this);
	}
	
	@Override
	public void init()
	{
		bind();
		//exampleTest();
	}

	/*
	public void exampleTest() {
		List<Request> requestList = new ArrayList<Request>();
		Request r1 = new Request();
		r1.setId(1);
		r1.setFacultyId(1);
		r1.setCourse(1111);
		r1.setType(1);
		r1.setState(3);
		r1.setSection(01);
		r1.setData("text1");
		Request r2 = new Request();
		r2.setId(2);
		r2.setFacultyId(2);
		r2.setCourse(2222);
		r2.setType(2);
		r2.setState(3);
		r2.setSection(02);
		r2.setData("text2");
		Request r3 = new Request();
		r3.setId(3);
		r3.setFacultyId(3);
		r3.setCourse(3333);
		r3.setType(3);
		r3.setState(3);
		r3.setSection(03);
		r3.setData("text3");
		requestList.add(r1);
		requestList.add(r2);
		requestList.add(r3);
		loadFlexTable(requestList);
	}
	*/
	
	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(RequestInboxNavigationEvent.TYPE, this);
		eventBusRegistration.put(RequestInboxNavigationEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceivePendingRequestListEvent.TYPE, this);
		eventBusRegistration.put(ReceivePendingRequestListEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveChangeRequestStateEvent.TYPE, this);
		eventBusRegistration.put(ReceiveChangeRequestStateEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveRequestsDetailsEvent.TYPE, this);
		eventBusRegistration.put(ReceiveRequestsDetailsEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	public void onRequestInboxNavigation(RequestInboxNavigationEvent evt)
	{
		this.go(parentPresenter.getView().getViewRootPanel());
		// loadRequestList();
		loadRequestsDetails();
	}
	
	public void loadRequestList() {
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		LoadPendingRequestListAction lria = new LoadPendingRequestListAction();
		LoadPendingRequestListEvent lrie = new LoadPendingRequestListEvent(lria, container);
		eventBus.fireEvent(lrie);
	}
	
	public void loadRequestsDetails() {
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendRequestsDetailsAction srda = new SendRequestsDetailsAction();
		SendRequestsDetailsEvent srde = new SendRequestsDetailsEvent(srda, container);
		eventBus.fireEvent(srde);
	}
	
	@Override
	public void onReceivePendingRequestList(ReceivePendingRequestListEvent evt) {
		ReceivePendingRequestListAction rprla = evt.getAction();
		List<Request> requestList =  rprla.getModel();
		loadFlexTable(requestList);
	}
	
	@Override
	public void onReceiveRequestsDetails(ReceiveRequestsDetailsEvent evt) {
		ReceiveRequestsDetailsAction action = evt.getAction();
		List<RequestInfo> requestInfoList = action.getModel();
		loadFlexTable2(requestInfoList);
	}
	
	public void loadFlexTable2(List<RequestInfo> requestInfoList) {
		FlexTable flexTable = view.getRequestListFlexTable();
		flexTable.removeAllRows();
		/*
		int rows = flexTable.getRowCount();
		for(Integer i=1; i<rows; i++) {
			int columns = flexTable.getCellCount(rows);
			for (Integer j=1; j<columns; j++) {
				//flexTable.clearCell(i, j);
				Window.alert(i.toString()+","+j.toString());
			}
		}
		*/
		
		flexTable.setText(0, 0, "Type");
		flexTable.setText(0, 1, "Course");
		flexTable.setText(0, 2, "Section");
		flexTable.setText(0, 3, "View");
		int index = 1;
		// load FlexTable
		for (RequestInfo requestInfo : requestInfoList) {
			flexTable.setText(index, 0, translateRequestType(requestInfo.getRequest().getType()));
			flexTable.setText(index, 1, requestInfo.getCourseNumber());
			flexTable.setText(index, 2, "Any");
			index++;
		}
		loadButtons2(requestInfoList);
		flexTable.setBorderWidth(1);
	}
	
	public void loadFlexTable(List<Request> requestList) {
		FlexTable flexTable = view.getRequestListFlexTable();
		flexTable.setText(0, 0, "Type");
		flexTable.setText(0, 1, "Course");
		flexTable.setText(0, 2, "Section");
		flexTable.setText(0, 3, "View");
		int index = 1;
		// load FlexTable
		for (Request request : requestList) {
			flexTable.setText(index, 0, translateRequestType(request.getType()));
			flexTable.setText(index, 1, Integer.toString(request.getCourse()));
			flexTable.setText(index, 2, Integer.toString(request.getSection()));
			index++;
		}
		// load buttons
		loadButtons(requestList);
		flexTable.setBorderWidth(1);
	}
	
	public void loadButtons2(List<RequestInfo> requestInfoList){
		ClickHandler ViewButtonsHandler = new ViewButtonsHandler2(requestInfoList);
	}
	
	private class ViewButtonsHandler2 implements ClickHandler
	{
		private HashMap<Button, RequestInfo> buttonRequestList;
		
		public ViewButtonsHandler2(List<RequestInfo> requestInfoList)
		{
			this.buttonRequestList = new HashMap<Button, RequestInfo>();
			int size = requestInfoList.size();
			for (int i=1;i<=size;i++) {
				Button button = new Button();
				button.setText("View");
				
				// define each button with different ui field (button+number), cascading by the accumulator i.
				button.getElement().setId("button"+Integer.toString(i));
				
				// add click handler for each button.
				button.addClickHandler(this);
				
				// set the button into the corresponding cell of flexTable.
				view.getRequestListFlexTable().setWidget(i, 3, button);
				buttonRequestList.put(button, requestInfoList.get(i-1));
			}
		}

		@Override
		public void onClick(ClickEvent event) {
			Button senderButton = (Button) event.getSource();
			RequestInfo clickedRequestInfo = new RequestInfo();
			if (buttonRequestList.containsKey(senderButton)) {
				clickedRequestInfo = buttonRequestList.get(senderButton);
				selectRequest(clickedRequestInfo.getRequest().getId());
			}
			else {
				clickedRequestInfo.getRequest().setId(0);
				clickedRequestInfo.getRequest().setFacultyId(0);
				clickedRequestInfo.getRequest().setType(0);
				clickedRequestInfo.getRequest().setState(0);
				clickedRequestInfo.getRequest().setCourse(0);
				clickedRequestInfo.getRequest().setSection(0);
				clickedRequestInfo.getRequest().setData("Code Error.");
				clickedRequestInfo.setFullName("N/A");
				clickedRequestInfo.setCourseNumber("N/A");
				Window.alert("Code Error.");
			}
			loadDetailsInfo2(clickedRequestInfo);
		}	
	}
	
	public void loadDetailsInfo2(RequestInfo clickedRequestInfo) {
		view.setDetailCourseLabel(clickedRequestInfo.getCourseNumber());
		view.setDetailSectionLabel("Any");
		view.setDetailFacultyIdLabel(clickedRequestInfo.getFullName());
		view.setDetailRequestIdLabel(Integer.toString(clickedRequestInfo.getRequest().getId()));
		view.setDetailMessageLabel(clickedRequestInfo.getRequest().getData());
	}

	
	public void loadButtons(List<Request> requestList) {
		ClickHandler ViewButtonsHandler = new ViewButtonsHandler(requestList);
	}
	
	public void loadDetailsInfo(Request request) {
		view.setDetailCourseLabel(Integer.toString(request.getCourse()));
		view.setDetailSectionLabel(Integer.toString(request.getSection()));
		view.setDetailFacultyIdLabel(Integer.toString(request.getFacultyId()));
		view.setDetailRequestIdLabel(Integer.toString(request.getId()));
		view.setDetailMessageLabel(request.getData());
	}
	
	public String translateRequestType(int id) {
		if (id == 1) {
			return "Time";
		} 
		if (id == 2) {
			return "Section";
		}
		if (id == 3) {
			return "Time and Section";
		}
		return "Unknown";
	}
	
	private class ViewButtonsHandler implements ClickHandler
	{
		private HashMap<Button, Request> buttonRequestList;
		
		public ViewButtonsHandler(List<Request> requestList)
		{
			this.buttonRequestList = new HashMap<Button, Request>();
			int size = requestList.size();
			for (int i=1;i<=size;i++) {
				Button button = new Button();
				button.setText("View");
				
				// define each button with different ui field (button+number), cascading by the accumulator i.
				button.getElement().setId("button"+Integer.toString(i));
				
				// add click handler for each button.
				button.addClickHandler(this);
				
				// set the button into the corresponding cell of flex table.
				view.getRequestListFlexTable().setWidget(i, 3, button);
				buttonRequestList.put(button, requestList.get(i-1));
			}
		}

		@Override
		public void onClick(ClickEvent event) {
			Button senderButton = (Button) event.getSource();
			Request clickedRequest = new Request();
			if (buttonRequestList.containsKey(senderButton)) {
				clickedRequest = buttonRequestList.get(senderButton);
				selectRequest(clickedRequest.getId());
			}
			else {
				clickedRequest.setId(0);
				clickedRequest.setFacultyId(0);
				clickedRequest.setType(0);
				clickedRequest.setState(0);
				clickedRequest.setCourse(0);
				clickedRequest.setSection(0);
				clickedRequest.setData("Code Error.");
				Window.alert("Code Error.");
			}
			loadDetailsInfo(clickedRequest);
		}	
	}
	
	public void selectRequest(int requestId) {
		this.selectRequestId = requestId;
	}
	
	// for changing state of the request.
	@Override
	public void onClickChangeStateButton(int stateNum) {
		if (this.selectRequestId != 0){
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			SendChangeRequestStateAction scrsa = new SendChangeRequestStateAction(this.selectRequestId, stateNum);
			SendChangeRequestStateEvent scrse = new SendChangeRequestStateEvent(scrsa, container);
			eventBus.fireEvent(scrse);
		}
		else {
			Window.alert("Please select the request first by clicking corresponding [View] button");
		}
		
	}
	
	@Override
	public void onReceiveChangeRequestState(ReceiveChangeRequestStateEvent evt) {
		ReceiveChangeRequestStateAction action = evt.getAction();
		int numRowsAffected = action.geAffectedRows();
		try {
			if (numRowsAffected > 0) {
				Window.alert("Request state change successfully.");
				loadRequestsDetails();
			}
		} catch (Throwable e){
			 {
				 Window.alert("This request is not a pending state. The pending list is reloading automatically.");
				 loadRequestsDetails();
			}
		}
	}

}
