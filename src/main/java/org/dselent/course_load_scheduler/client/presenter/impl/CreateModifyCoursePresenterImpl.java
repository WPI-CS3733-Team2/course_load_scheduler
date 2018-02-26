package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.AddSectionsAction;
import org.dselent.course_load_scheduler.client.action.InvalidAddCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidAddModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidAddModifyCourseStrings;
import org.dselent.course_load_scheduler.client.event.AddCourseEvent;
import org.dselent.course_load_scheduler.client.event.AddSectionsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitCourseEvent;
import org.dselent.course_load_scheduler.client.event.CreateModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAddCourseEvent;
import org.dselent.course_load_scheduler.client.exceptions.DuplicateCRNException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyArrayException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;


public class CreateModifyCoursePresenterImpl extends BasePresenterImpl implements CreateModifyCoursePresenter
{
	
	private CreateModifyCourseView view;
	private IndexPresenter parentPresenter;

	private List<Section> currentSections;
	private List<Section> addedSections;
	private List<Section> removedSections;
	
	private boolean newCourse;
	
	private final ListDataProvider<Section> dataProvider;
	private final SingleSelectionModel<Section> selectionModel;

	@Inject
	public CreateModifyCoursePresenterImpl(CreateModifyCourseView view, IndexPresenter parentPresenter)
	{
			this.view = view;
			this.parentPresenter = parentPresenter;
			view.setPresenter(this);
			
			this.currentSections = new ArrayList<Section>();
			this.addedSections = new ArrayList<Section>();
			this.removedSections = new ArrayList<Section>();
			
			dataProvider = new ListDataProvider<Section>(currentSections);
		    dataProvider.addDataDisplay(view.getSectionTable());

		    selectionModel = new SingleSelectionModel<Section>();
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
		
		registration = eventBus.addHandler(InvalidSubmitCourseEvent.TYPE, this);
		eventBusRegistration.put(InvalidSubmitCourseEvent.TYPE, registration);

		registration = eventBus.addHandler(InvalidAddCourseEvent.TYPE, this);
		eventBusRegistration.put(InvalidAddCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidAddSectionEvent.TYPE, this);
		eventBusRegistration.put(InvalidAddSectionEvent.TYPE, registration);
		
		registration = eventBus.addHandler(CreateModifyCourseEvent.TYPE, this);
		eventBusRegistration.put(CreateModifyCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(AddCourseEvent.TYPE, this);
		eventBusRegistration.put(AddCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveAddCourseEvent.TYPE, this);
		eventBusRegistration.put(ReceiveAddCourseEvent.TYPE, registration);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public CreateModifyCourseView getView() {
		return view;
	}
	
	@Override
	public void onCreateModifyCourse(CreateModifyCourseEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
		parentPresenter.hideLoadScreen();
		clearForm();
		
		newCourse = true;
		Course course = evt.getAction().getCourse();
		if(course != null) {
			newCourse = false;
			view.setCourseNameTextBoxText(course.getCourseName());
			view.setCourseNumberTextBoxText(course.getCourseNumber());
			view.setFrequencyTextBoxText(Integer.toString(course.getFrequency()));
			currentSections = course.getSections();
			dataProvider.setList(currentSections);
			dataProvider.refresh();
		}
	}
	
	@Override
	public void addSection() {
		List<Section> sections = dataProvider.getList();
		Section section = new Section();
		
		String sectionName = view.getSectionNameTextBox().getText();
		String crn = view.getCrnTextBox().getText();
		String type = view.getTypeTextBox().getText();
		String expectedPop = view.getPopTextBox().getText();
		String year = view.getYearTextBox().getText();
		String days = view.getDaysTextBox().getText();
		String term = view.getTermTextBox().getText();
		String startTime = view.getStartTimeTextBox().getText();
		String endTime = view.getEndTimeTextBox().getText();
		
		List<String> invalidReasonList = new ArrayList<>();
		
		try {
			checkEmptyString(sectionName);
			checkEmptyString(crn);
			checkEmptyString(type);
			checkEmptyString(expectedPop);
			checkEmptyString(year);
			checkEmptyString(days);
			checkEmptyString(term);
			checkEmptyString(startTime);
			checkEmptyString(endTime);
			checkDuplicateCrn(Integer.parseInt(crn), sections);
		}
		catch(EmptyStringException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.EMPTY_SECTION_FIELD);
		}
		catch (DuplicateCRNException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.DUPLICATE_CRN);
		}
		
		if(invalidReasonList.size() == 0)
		{
			Calendar calendar = new Calendar();
			calendar.setDays(days);
			calendar.setYear(Integer.parseInt(year));
			calendar.setSemester(term);
			calendar.setStart_time(startTime);
			calendar.setEnd_time(endTime);
			
			section.setSectionName(sectionName);
			section.setCrn(Integer.parseInt(crn));
			section.setType(type);
			section.setExpectedPopulation(Integer.parseInt(expectedPop));
			section.setCalendar(calendar);
			
			clearSectionForm();
			boolean found = false;
        	for(int i = 0; i < removedSections.size(); i++) {
        		if(removedSections.get(i).equals(section)) {
        			removedSections.remove(i);
        			found = true;
        			break;
        		}
        	}
        	if(!found) {
        		addedSections.add(section);
        	}
			currentSections.add(section);
		    dataProvider.setList(currentSections);
		    dataProvider.refresh();
		
		}
		else
		{
			InvalidAddModifyCourseAction iasa = new InvalidAddModifyCourseAction(invalidReasonList);
			InvalidAddSectionEvent iase = new InvalidAddSectionEvent(iasa);
			eventBus.fireEvent(iase);
		}
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	private void checkEmptyArray(List<?> list) throws EmptyArrayException
	{
		if(list.size() == 0)
		{
			throw new EmptyArrayException();
		}
	}
	
	private void checkDuplicateCrn(int crn, List<Section> sections) throws DuplicateCRNException
	{
		for(int i = 0; i < sections.size(); i++) {
			if(crn == sections.get(i).getCrn()) {
				throw new DuplicateCRNException();
			}
		}
	}
	
	@Override
	public void onInvalidAddSection(InvalidAddSectionEvent evt)
	{
		InvalidAddModifyCourseAction iamca = evt.getAction();
		view.showErrorMessages(iamca.toString());
	}
	
	@Override
	public void removeSection() {
		Section selected = selectionModel.getSelectedObject();
        if (selected != null) {
        	boolean found = false;
        	for(int i = 0; i < addedSections.size(); i++) {
        		if(addedSections.get(i).getCrn() == selected.getCrn()) {
        			addedSections.remove(i);
        			found = true;
        			break;
        		}
        	}
        	if(!found) {
        		removedSections.add(selected);
        	}
        	currentSections.remove(selected);
            dataProvider.setList(currentSections);
            dataProvider.refresh();
        }
        while(selectionModel.getSelectedSet().size() > 0) {
            selectionModel.setSelected(selectionModel.getSelectedObject(), false);
        }
	}
	
	@Override
	public void createModifyCourseCancel() {
		parentPresenter.showLoadScreen();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		ViewCourseAction vca = new ViewCourseAction();
		AdminCourseEvent ace = new AdminCourseEvent(vca, container);
		eventBus.fireEvent(ace);
	}
	
	@Override
	public void createModifyCourseSubmit() {
		Course course = new Course();
		
		String courseName = view.getCourseNameTextBox().getText();
		String courseNumber = view.getCourseNumberTextBox().getText();
		String frequency = view.getFrequencyTextBox().getText();
		//List<Section> sections = dataProvider.getList();
		List<Section> sections = currentSections;
		
		List<String> invalidReasonList = new ArrayList<>();
		
		try {
			checkEmptyString(courseName);
			checkEmptyString(courseNumber);
			checkEmptyString(frequency);
			checkEmptyArray(sections);
		}
		catch (EmptyStringException | EmptyArrayException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.EMPTY_COURSE_FIELD);
		}
		
		if(invalidReasonList.size() == 0) {
			parentPresenter.showLoadScreen();
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setFrequency(Integer.parseInt(frequency));
			course.setSections(sections);
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			
			if(newCourse) {
				AddCourseAction vca = new AddCourseAction(course);
				AddCourseEvent ace = new AddCourseEvent(vca, container);
				eventBus.fireEvent(ace);
			}
			else {
				if(addedSections.size() > 0) {
					int courseId = course.getId();
					for(int i = 0; i < currentSections.size(); i++) {
						currentSections.get(i).setCourseId(courseId);
					}
					AddSectionsAction vca = new AddSectionsAction(currentSections);
					AddSectionsEvent ace = new AddSectionsEvent(vca, container);
					eventBus.fireEvent(ace);
				}
				if(removedSections.size() > 0) {
					// Remove these sections
				}
				// Modify Course
				
				ViewCourseAction vca = new ViewCourseAction();
				AdminCourseEvent ace = new AdminCourseEvent(vca, container);
				eventBus.fireEvent(ace);
			}
		}
		else {
			InvalidAddModifyCourseAction iamca = new InvalidAddModifyCourseAction(invalidReasonList);
			InvalidSubmitCourseEvent isce = new InvalidSubmitCourseEvent(iamca);
			eventBus.fireEvent(isce);
		}
	}
	
	@Override
	public void onInvalidAddCourse(InvalidAddCourseEvent evt) {
		parentPresenter.hideLoadScreen();
		InvalidAddCourseAction iamca = evt.getAction();
		view.showErrorMessages(iamca.toString());
	}
	
	@Override
	public void onReceiveAddCourse(ReceiveAddCourseEvent evt) {
		HasWidgets container = parentPresenter.getView().getViewRootPanel();

		int courseId = evt.getAction().getCourse().getId();
		for(int i = 0; i < currentSections.size(); i++) {
			currentSections.get(i).setCourseId(courseId);
		}
		AddSectionsAction vca = new AddSectionsAction(currentSections);
		AddSectionsEvent ace = new AddSectionsEvent(vca, container);
		eventBus.fireEvent(ace);
	}
	
	@Override
	public void onInvalidSubmitCourse(InvalidSubmitCourseEvent evt) 
	{
		InvalidAddModifyCourseAction iamca = evt.getAction();
		view.showErrorMessages(iamca.toString());
	}
	
	@Override
	public void clearForm() {
		view.setCourseNameTextBoxText("");
		view.setCourseNumberTextBoxText("");
		view.setFrequencyTextBoxText("");
		clearSectionForm();
		currentSections.clear();
		dataProvider.getList().clear();
		dataProvider.refresh();
		/*CellTable<Section> sectionTable = view.getSectionTable();
		sectionTable.setRowData(dataProvider.getList());
		view.setSectionTable(sectionTable);*/
	}
	
	@Override
	public void clearSectionForm() {
		view.setSectionNameTextBoxText("");
		view.setCrnTextBoxText("");
		view.setTypeTextBoxText("");
		view.setPopTextBoxText("");
		view.setYearTextBoxText("");
		view.setDaysTextBoxText("");
		view.setTermTextBoxText("");
		view.setStartTimeTextBoxText("");
		view.setEndTimeTextBoxText("");
	}
		
}
