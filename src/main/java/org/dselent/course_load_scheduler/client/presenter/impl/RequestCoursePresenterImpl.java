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
import org.dselent.course_load_scheduler.client.exceptions.EmptyArrayException;
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
		
		Course course = evt.getAction().getCourse();
		List<Section> sections = course.getSections();
		
		view.setCourseNameLabelText(course.getCourseName());
		view.setCourseNumberLabelText(course.getCourseNumber());
		dataProvider.getList().addAll(sections);
	}
	
	@Override
	public void requestCourseCancel() {
		clearForm();

		ViewCourseAction vca = new ViewCourseAction(new ArrayList<Course>());
		FacultyCourseEvent ace = new FacultyCourseEvent(vca);
		eventBus.fireEvent(ace);
	}
	
	@Override
	public void requestCourseSubmit() {
		String courseName = view.getCourseNameLabel().getText();
		String courseNumber = view.getCourseNumberLabel().getText();
		Set<Section> sections = selectionModel.getSelectedSet();
		
		List<String> invalidReasonList = new ArrayList<>();
		List<String> requestedTimes = new ArrayList<>();
		if(view.getEightToNineCB().getValue()) {
			requestedTimes.add(view.getEightToNineCB().getText());
		}
		if(view.getNineToTenCB().getValue()) {
			requestedTimes.add(view.getNineToTenCB().getText());
		}
		if(view.getTenToElevenCB().getValue()) {
			requestedTimes.add(view.getTenToElevenCB().getText());
		}
		if(view.getElevenToTwelveCB().getValue()) {
			requestedTimes.add(view.getElevenToTwelveCB().getText());
		}
		if(view.getTwelveToOneCB().getValue()) {
			requestedTimes.add(view.getTwelveToOneCB().getText());
		}
		if(view.getOneToTwoCB().getValue()) {
			requestedTimes.add(view.getOneToTwoCB().getText());
		}
		if(view.getTwoToThreeCB().getValue()) {
			requestedTimes.add(view.getTwoToThreeCB().getText());
		}
		if(view.getThreeToFourCB().getValue()) {
			requestedTimes.add(view.getThreeToFourCB().getText());
		}
		if(view.getFourToFiveCB().getValue()) {
			requestedTimes.add(view.getFourToFiveCB().getText());
		}
		if(view.getFiveToSixCB().getValue()) {
			requestedTimes.add(view.getFiveToSixCB().getText());
		}
		
		int unselectedAreas = 0;
		
		try {
			checkEmptyArray(requestedTimes);
		}
		catch (EmptyArrayException e) {
			unselectedAreas++;
		}
		
		try {
			checkEmptySet(sections);
		}
		catch (EmptyArrayException e) {
			unselectedAreas++;
		}
		
		if(unselectedAreas < 2) {
			String requestString = "Request for " + courseName + "(" + courseNumber + "): ";
			requestString.concat(requestedTimes.toString());
			requestString.concat(sections.toString());
			
			//TODO: Send to database
			
			clearForm();
			
			ViewCourseAction vca = new ViewCourseAction(new ArrayList<Course>());
			FacultyCourseEvent fce = new FacultyCourseEvent(vca);
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
	
	private void checkEmptyArray(List<?> list) throws EmptyArrayException
	{
		if(list.size() == 0)
		{
			throw new EmptyArrayException();
		}
	}
	
	private void checkEmptySet(Set<?> set) throws EmptyArrayException
	{
		if(set.size() == 0)
		{
			throw new EmptyArrayException();
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
