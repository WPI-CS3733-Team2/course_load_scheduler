package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.List;

import org.dselent.course_load_scheduler.client.action.RequestCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.event.FacultyCalendarEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.RequestCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSearchCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;


public class FacultyCoursePresenterImpl extends BasePresenterImpl implements FacultyCoursePresenter
{
	
	List<Course> courses;
	private FacultyCourseView view;
	private IndexPresenter parentPresenter;
	boolean searchInProgress;

	@Inject
	public FacultyCoursePresenterImpl(FacultyCourseView view, IndexPresenter parentPresenter)
	{
			this.view = view;
			this.parentPresenter = parentPresenter;
			view.setPresenter(this);
			searchInProgress = false;
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
		
		registration = eventBus.addHandler(FacultySectionEvent.TYPE, this);
		eventBusRegistration.put(FacultySectionEvent.TYPE, registration);
		
		registration = eventBus.addHandler(FacultyCalendarEvent.TYPE, this);
		eventBusRegistration.put(FacultyCalendarEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveFacultyCourseEvent.TYPE, this);
		eventBusRegistration.put(ReceiveFacultyCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidSearchCourseEvent.TYPE, this);
		eventBusRegistration.put(InvalidSearchCourseEvent.TYPE, registration);
		
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public FacultyCourseView getView() {
		return view;
	}
	
	@Override
	public void onFacultySection(FacultySectionEvent evt)
	{
		ViewSectionAction action = evt.getAction();
		courses = action.getAllCourses();
	}
	
	@Override
	public void onFacultyCalendar(FacultyCalendarEvent evt)
	{
		List<Section> sections = evt.getAction().getAllSections();
		int courseId = sections.get(0).getCourseId();
		int currentCourse = 0;
		for (int i = 0; i < sections.size(); i++) {
			Section section = sections.get(i);
			if (section.getCourseId() != courseId)  {
				currentCourse++;
				courseId = section.getCourseId();
			}
			courses.get(currentCourse).addSection(section);
		}
	}
	
	@Override
	public void onReceiveFacultyCourse(ReceiveFacultyCourseEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getSearchCourseButton().setEnabled(true);
		searchInProgress = false;
		
		this.go(parentPresenter.getView().getViewRootPanel());
		view.clearAllCoursesGrid();
		
		List<Calendar> calendars = evt.getAction().getAllCalendars();
		int courseId = 0;
		int sectionId = 0;
		for(int i = 0; i < calendars.size(); i++) {
			Calendar calendar = calendars.get(i);
			List<Section> sections = courses.get(courseId).getSections();
			if(sectionId < sections.size()) {
				Section section = sections.get(sectionId);
				section.setCalendar(calendar);
				sections.set(sectionId, section);
				courses.get(courseId).setSections(sections);
				sectionId++;
			}
			else {
				i--;
				sectionId = 0;
				courseId++;
			}
		}
		
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getSections().size() > 0) {
				DecoratorPanel coursePanel = new DecoratorPanel();
				Grid layout = new Grid(1, 3);

				FlowPanel courseInfoPanel = new FlowPanel();

				VerticalPanel courseName = new VerticalPanel();
				courseName.add(new Label(courses.get(i).getCourseName()));

				VerticalPanel courseNumber = new VerticalPanel();
				courseNumber.add(new Label(courses.get(i).getCourseNumber()));

				courseInfoPanel.add(courseName);
				courseInfoPanel.add(courseNumber);
				courseInfoPanel.setWidth("100px");

				CellTable<Section> courseSections = new CellTable<Section>();

				TextColumn<Section> nameColumn = new TextColumn<Section>() {
					@Override
					public String getValue(Section object) {
						return object.getSectionName();
					}
				};
				courseSections.addColumn(nameColumn, "Name");

				TextColumn<Section> crnColumn = new TextColumn<Section>() {
					@Override
					public String getValue(Section object) {
						return Integer.toString(object.getCrn());
					}
				};
				courseSections.addColumn(crnColumn, "CRN");

				TextColumn<Section> typeColumn = new TextColumn<Section>() {
					@Override
					public String getValue(Section object) {
						return object.getType();
					}
				};
				courseSections.addColumn(typeColumn, "Type");

				TextColumn<Section> populationColumn = new TextColumn<Section>() {
					@Override
					public String getValue(Section object) {
						return Integer.toString(object.getExpectedPopulation());
					}
				};
				courseSections.addColumn(populationColumn, "Population");

				courseSections.setRowCount(courses.get(i).getSections().size(), true);
				courseSections.setRowData(0, courses.get(i).getSections());
				courseSections.setWidth("500px");

				Button requestCourseButton = new Button("Request");
				requestCourseButton.addClickHandler(new CustomClickHandler(courses.get(i)) {

					@Override
					public void onClick(ClickEvent event) {
						RequestCourseAction rca = new RequestCourseAction(course);
						RequestCourseEvent rce = new RequestCourseEvent(rca);
						eventBus.fireEvent(rce);
					}
				});

				layout.setWidget(0, 0, courseInfoPanel);
				layout.setWidget(0, 1, courseSections);
				layout.setWidget(0, 2, requestCourseButton);

				coursePanel.add(layout);
				coursePanel.setWidth("650px");

				view.addCourseToGrid(coursePanel);
			}
		}
	}
	
	@Override
	public void searchCourses() {
		if(!searchInProgress) {
			searchInProgress = true;
			parentPresenter.showLoadScreen();
			view.getSearchCourseButton().setEnabled(false);
			
			String courseQuery = view.getSearchCourseTextBox().getText().toUpperCase();
			
			boolean validQuery = true;
			
			try 
			{
				checkEmptyString(courseQuery);
				searchCourseEventFire(courseQuery);
			}
			catch(EmptyStringException e)
			{
				validQuery = false;
				searchCourseEventFire(null);
			}
			
			/*if(validQuery){
				//Search for courses
				searchCourseEventFire(courseQuery);
			}else {
				//Invalid query
				parentPresenter.hideLoadScreen();
				view.getSearchCourseButton().setEnabled(true);
				searchInProgress = false;
				
				view.showErrorMessages("Query cannot be empty.");
				
			}*/
		}
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	private void searchCourseEventFire(String query) {
		ViewCourseAction vca = new ViewCourseAction(query, null);
		FacultyCourseEvent fce = new FacultyCourseEvent(vca, parentPresenter.getView().getViewRootPanel());
		eventBus.fireEvent(fce);
	}
	
	@Override
	public void onInvalidSearchCourse(InvalidSearchCourseEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getSearchCourseButton().setEnabled(true);
		searchInProgress = false;
		
		view.showErrorMessages("There is no course of that name!");
	}
	
	private class CustomClickHandler implements ClickHandler {
		Course course;
		
		public CustomClickHandler(Course course) {
			this.course = course;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
		
}
