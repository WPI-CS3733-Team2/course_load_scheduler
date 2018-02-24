package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidSearchCourseAction;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSearchCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AdminCourseView;

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


public class AdminCoursePresenterImpl extends BasePresenterImpl implements AdminCoursePresenter
{
	
	private AdminCourseView view;
	private IndexPresenter parentPresenter;
	boolean searchInProgress;

	@Inject
	public AdminCoursePresenterImpl(AdminCourseView view, IndexPresenter parentPresenter)
	{
			this.view = view;
			this.parentPresenter = parentPresenter;
			view.setPresenter(this);
			this.searchInProgress = false;
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
		
		registration = eventBus.addHandler(AdminCourseEvent.TYPE, this);
		eventBusRegistration.put(AdminCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidSearchCourseEvent.TYPE, this);
		eventBusRegistration.put(InvalidSearchCourseEvent.TYPE, registration);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public AdminCourseView getView() {
		return view;
	}
	
	//@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}

	//@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	@Override
	public void searchCourses() {
		if(!searchInProgress) {
			searchInProgress = true;
			parentPresenter.showLoadScreen();
			view.getSearchCourseButton().setEnabled(false);
			
			String courseQuery = view.getSearchCourseTxtBox().getText();
			
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
		InvalidSearchCourseAction sca = new InvalidSearchCourseAction();
		InvalidSearchCourseEvent sce = new InvalidSearchCourseEvent(sca);
		eventBus.fireEvent(sce);
	}
	
	@Override
	public void onInvalidSearchCourse(InvalidSearchCourseEvent evt) {
		/*parentPresenter.hideLoadScreen();
		view.getSearchCourseButton().setEnabled(true);
		searchInProgress = false;
		
		view.showErrorMessages("Course search to be implemented.");*/
	}
	
	@Override
	public void onAdminCourse(AdminCourseEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		view.clearAllCoursesGrid();
		
		List<Section> sections = new ArrayList<>();
		List<Course> courses = new ArrayList<>();

		Section section1 = new Section();
		section1.setSectionName("C01");
		section1.setCrn(12345);
		section1.setType("Lecture");
		section1.setExpectedPopulation(50);

		Section section2 = new Section();
		section2.setSectionName("C02");
		section2.setCrn(12346);
		section2.setType("Lab");
		section2.setExpectedPopulation(50);

		sections.add(section1);
		sections.add(section2);

		Course course1 = new Course();
		course1.setCourseName("Software Engineering");
		course1.setCourseNumber("3733");
		course1.setSections(sections);
		
		Course course2 = new Course();
		course2.setCourseName("Testing");
		course2.setCourseNumber("1234");
		course2.setSections(sections);

		courses.add(course1);
		courses.add(course1);
		courses.add(course2);

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

			courseSections.setRowCount(courses.get(i).getSections().size(), true);
			courseSections.setRowData(0, courses.get(i).getSections());
			courseSections.setWidth("500px");

			Button modifyCourseButton = new Button("Modify");
			Course thisCourse = courses.get(i);
			
			modifyCourseButton.addClickHandler(new CustomClickHandler(thisCourse) {
				@Override
				public void onClick(ClickEvent event) {
					ModifyCourseAction mca = new ModifyCourseAction(course);
					ModifyCourseEvent mce = new ModifyCourseEvent(mca);
					eventBus.fireEvent(mce);
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
	public void addCourse() {
		ModifyCourseAction mca = new ModifyCourseAction(null);
		ModifyCourseEvent mce = new ModifyCourseEvent(mca);
		eventBus.fireEvent(mce);
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
