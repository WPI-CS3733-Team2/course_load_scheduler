package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dselent.course_load_scheduler.client.action.InvalidRequestCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidRequestCourseStrings;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitRequestEvent;
import org.dselent.course_load_scheduler.client.event.RequestCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;
import org.dselent.course_load_scheduler.client.view.RequestCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
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
		
		view.setCourseNameLabelText(course.getCourseName());
		view.setCourseNumberLabelText(course.getCourseNumber());
		dataProvider.getList().addAll(sections);
	}
	
	@Override
	public void requestCourseCancel() {
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
		
		try {
			checkEmptyString(requestTimes);
			requestTimes = "\n Requested Times: \n" + requestTimes;
		}
		catch (EmptyStringException e) {
			unselectedAreas++;
		}
		
		try {
			checkEmptyString(requestSections);
			requestSections = "\n Requested Sections: \n" + requestSections;
		}
		catch (EmptyStringException e) {
			unselectedAreas++;
		}
		
		if(unselectedAreas < 2) {
			requestString += requestSections;
			requestString += requestTimes;
			
			view.showErrorMessages(requestString);
			//TODO: Send to database
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			ViewCourseAction vca = new ViewCourseAction();
			FacultyCourseEvent fce = new FacultyCourseEvent(vca, container);
			eventBus.fireEvent(fce);
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
		
}
