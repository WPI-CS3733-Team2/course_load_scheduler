package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dselent.course_load_scheduler.client.action.InvalidRequestCourseAction;
import org.dselent.course_load_scheduler.client.action.SendCreateRequestAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidRequestCourseStrings;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateRequestEvent;
import org.dselent.course_load_scheduler.client.event.RequestCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateRequestEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;
import org.dselent.course_load_scheduler.client.view.RequestCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.inject.Inject;


public class RequestCoursePresenterImpl extends BasePresenterImpl implements RequestCoursePresenter
{
	
	private IndexPresenter parentPresenter;
	private RequestCourseView view;
	
	private List<Section> currentSections;
	
	private final ListDataProvider<Section> dataProvider;
	private final MultiSelectionModel<Section> selectionModel;
	private Integer courseId = 0;

	@Inject
	public RequestCoursePresenterImpl(RequestCourseView view, IndexPresenter parentPresenter)
	{
			this.view = view;
			this.parentPresenter  = parentPresenter;
			view.setPresenter(this);
			
			this.currentSections = new ArrayList<Section>();
			
			dataProvider = new ListDataProvider<Section>(currentSections);
		    dataProvider.addDataDisplay(view.getSectionTable());

		    selectionModel = new MultiSelectionModel<Section>();
		    view.setSectionTableSelectionModel(selectionModel);
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(RequestCourseEvent.TYPE, this);
		eventBusRegistration.put(RequestCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidSubmitRequestEvent.TYPE, this);
		eventBusRegistration.put(InvalidSubmitRequestEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveCreateRequestEvent.TYPE, this);
		eventBusRegistration.put(ReceiveCreateRequestEvent.TYPE, registration);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public RequestCourseView getView() {
		return view;
	}
	
	@Override
	public void onRequestCourse(RequestCourseEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		dataProvider.getList().clear();
		clearForm();
		
		Course course = evt.getAction().getCourse();
		List<Section> sections = course.getSections();
		courseId = course.getId();
		
		view.setCourseNameLabelText(course.getCourseName());
		view.setCourseNumberLabelText(course.getCourseNumber());
		dataProvider.getList().addAll(sections);
	}
	
	@Override
	public void requestCourseCancel() {
		parentPresenter.showLoadScreen();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		ViewCourseAction vca = new ViewCourseAction();
		FacultyCourseEvent fce = new FacultyCourseEvent(vca, container);
		eventBus.fireEvent(fce);
	}
	
	@Override
	public void requestCourseSubmit() {
		String courseName = view.getCourseNameLabel().getText();
		String courseNumber = view.getCourseNumberLabel().getText();
		Set<Section> sections = selectionModel.getSelectedSet();
		
		Integer facultyId = Injector.INSTANCE.getGlobalData().getUserInfo().getFacultyId();
		
		String requestString = "Request for " + courseName + " (" + courseNumber + "): \n";
		String requestTimes = "";
		String requestSections = "";
		
		List<String> invalidReasonList = new ArrayList<>();
		if(view.getEightToNineCB().getValue()) {
			requestTimes += view.getEightToNineCB().getText() + "\n";
		}
		if(view.getNineToTenCB().getValue()) {
			requestTimes += view.getNineToTenCB().getText() + "\n";
		}
		if(view.getTenToElevenCB().getValue()) {
			requestTimes += view.getTenToElevenCB().getText() + "\n";
		}
		if(view.getElevenToTwelveCB().getValue()) {
			requestTimes += view.getElevenToTwelveCB().getText() + "\n";
		}
		if(view.getTwelveToOneCB().getValue()) {
			requestTimes += view.getTwelveToOneCB().getText() + "\n";
		}
		if(view.getOneToTwoCB().getValue()) {
			requestTimes += view.getOneToTwoCB().getText() + "\n";
		}
		if(view.getTwoToThreeCB().getValue()) {
			requestTimes += view.getTwoToThreeCB().getText() + "\n";
		}
		if(view.getThreeToFourCB().getValue()) {
			requestTimes += view.getThreeToFourCB().getText() + "\n";
		}
		if(view.getFourToFiveCB().getValue()) {
			requestTimes += view.getFourToFiveCB().getText() + "\n";
		}
		if(view.getFiveToSixCB().getValue()) {
			requestTimes += view.getFiveToSixCB().getText() + "\n";
		}
		
		for(Section section: sections) {
			requestSections += section.getCrn() + ": " + section.getType() + " section " + section.getSectionName() + "\n";
		}
		
		int unselectedAreas = 0;
		boolean haveSection = true;
		boolean haveTime = true;
		
		try {
			checkEmptyString(requestTimes);
			requestTimes = "\n Requested Times: \n" + requestTimes;
		}
		catch (EmptyStringException e) {
			unselectedAreas++;
			haveTime = false;
		}
		
		try {
			checkEmptyString(requestSections);
			requestSections = "\n Requested Sections: \n" + requestSections;
		}
		catch (EmptyStringException e) {
			unselectedAreas++;
			haveSection = false;
		}
		
		int requestType = 0;
		if(haveSection) {
			if(haveTime) {
				requestType = 3;
			}
			else {
				requestType = 2;
			}
		}
		else {
			if(haveTime) {
				requestType = 1;
			}
		}
		
		if((unselectedAreas < 2) || (requestType != 0)) {
			requestString += requestSections;
			requestString += requestTimes;
			
			Request request = new Request();
			request.setFacultyId(facultyId);
			request.setSection(1);	
			request.setState(3);	// 3 as pending state
			request.setCourse(courseId);
			request.setData(requestString);
			request.setType(requestType);
			
			selectionModel.clear();
			parentPresenter.showLoadScreen();
			createRequest(request);
		}
		else {
			invalidReasonList.add(InvalidRequestCourseStrings.EMPTY_REQUEST_FIELD);
			
			InvalidRequestCourseAction irca = new InvalidRequestCourseAction(invalidReasonList);
			InvalidSubmitRequestEvent isre = new InvalidSubmitRequestEvent(irca);
			eventBus.fireEvent(isre);
		}
	}
	
	@Override
	public void onInvalidSubmitRequest(InvalidSubmitRequestEvent evt) 
	{
		InvalidRequestCourseAction iamca = evt.getAction();
		view.showErrorMessages(iamca.toString());
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	@Override
	public void clearForm() {
		view.setCourseNameLabelText("Course Name");
		view.setCourseNameLabelText("Course Number");
		view.uncheckAllCB();
		dataProvider.getList().clear();
	}
	
	public void createRequest(Request request) {
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendCreateRequestAction scra = new SendCreateRequestAction(request);
		SendCreateRequestEvent scre = new SendCreateRequestEvent(scra, container);
		eventBus.fireEvent(scre);
	}
	
	@Override
	public void onReceiveCreateRequest(ReceiveCreateRequestEvent evt) {
		int affectedRowNumber = evt.getAction().getAffectedRows();
		try
		{
			if(affectedRowNumber == 1) {
				view.showErrorMessages("New request created successfully.");
				HasWidgets container = parentPresenter.getView().getViewRootPanel();
				ViewCourseAction vca = new ViewCourseAction();
				FacultyCourseEvent fce = new FacultyCourseEvent(vca, container);
				eventBus.fireEvent(fce);
			}
			else {
				throw new Exception( "Unable to creat a new request, Please try again.");
			}
		}
		catch (Exception e){
			view.showErrorMessages("Unable to creat a new request, Please try again.");
		}
	}
		
}
