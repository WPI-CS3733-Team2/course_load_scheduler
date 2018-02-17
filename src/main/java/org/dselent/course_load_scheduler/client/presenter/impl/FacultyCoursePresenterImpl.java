package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.SearchCourseAction;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.SearchCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.FacultyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseView;
import org.dselent.course_load_scheduler.client.view.IndexView;

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
		
		registration = eventBus.addHandler(FacultyCourseEvent.TYPE, this);
		eventBusRegistration.put(FacultyCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SearchCourseEvent.TYPE, this);
		eventBusRegistration.put(SearchCourseEvent.TYPE, registration);
		
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
	public void onFacultyCourse(FacultyCourseEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		view.clearAllCoursesGrid();
		
		List<Section> sections = new ArrayList<>();
		List<Course> courses = new ArrayList<>();

		Section section1 = new Section();
		section1.setSectionName("C01");
		section1.setCrn(12345);
		section1.setType("Lecture");
		section1.setFrequency(4);
		section1.setExpectedPopulation(50);

		Section section2 = new Section();
		section2.setSectionName("C02");
		section2.setCrn(12346);
		section2.setType("Lab");
		section2.setFrequency(4);
		section2.setExpectedPopulation(50);

		sections.add(section1);
		sections.add(section2);

		Course course1 = new Course();
		course1.setCourseName("Software Engineering");
		course1.setCourseNumber("3733");
		course1.setSections(sections);

		courses.add(course1);
		courses.add(course1);
		courses.add(course1);

		for (int i = 0; i < courses.size(); i++) {
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

			TextColumn<Section> frequencyColumn = new TextColumn<Section>() {
				@Override
				public String getValue(Section object) {
					return Integer.toString(object.getFrequency());
				}
			};
			courseSections.addColumn(frequencyColumn, "Frequency");

			courseSections.setRowCount(courses.get(i).getSections().size(), true);
			courseSections.setRowData(0, courses.get(i).getSections());
			courseSections.setWidth("500px");

			Button modifyCourseButton = new Button("Request");
			modifyCourseButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					final Injector injector = Injector.INSTANCE;

					IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
					IndexView indexView = indexPresenter.getView();

					RequestCoursePresenterImpl requestCoursePresenter = injector.getRequestCoursePresenter();

					requestCoursePresenter.go(indexView.getViewRootPanel());
				}
			});

			layout.setWidget(0, 0, courseInfoPanel);
			layout.setWidget(0, 1, courseSections);
			layout.setWidget(0, 2, modifyCourseButton);

			coursePanel.add(layout);
			coursePanel.setWidth("650px");

			view.addCourseToGrid(coursePanel);
		}
	}
	
	@Override
	public void searchCourses() {
		if(!searchInProgress) {
			searchInProgress = true;
			parentPresenter.showLoadScreen();
			view.getSearchCourseButton().setEnabled(false);
			
			String courseQuery = view.getSearchCourseTextBox().getText();
			
			boolean validQuery = true;
			
			try 
			{
				checkEmptyString(courseQuery);
			}
			catch(EmptyStringException e)
			{
				validQuery = false;
			}
			
			if(validQuery){
				//Search for courses
				searchCourseEventFire(courseQuery);
			}else {
				//Invalid query
				parentPresenter.hideLoadScreen();
				view.getSearchCourseButton().setEnabled(true);
				searchInProgress = false;
				
				view.showErrorMessages("Query cannot be empty.");
				
			}
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
		SearchCourseAction sca = new SearchCourseAction(query);
		SearchCourseEvent sce = new SearchCourseEvent(sca);
		eventBus.fireEvent(sce);
	}
	
	@Override
	public void onSearchCourse(SearchCourseEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getSearchCourseButton().setEnabled(true);
		searchInProgress = false;
		
		view.showErrorMessages("Course search to be implemented.");
	}
		
}
