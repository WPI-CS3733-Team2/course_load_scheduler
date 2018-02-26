package org.dselent.course_load_scheduler.client.presenter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.AddSectionsAction;
import org.dselent.course_load_scheduler.client.action.GetCourseNumberAction;
import org.dselent.course_load_scheduler.client.action.InvalidAddCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidAddModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.RemoveSectionsAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidAddModifyCourseStrings;
import org.dselent.course_load_scheduler.client.event.AddCourseEvent;
import org.dselent.course_load_scheduler.client.event.AddSectionsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitCourseEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.CreateModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.GetCourseNumberEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAddCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCourseNumberEvent;
import org.dselent.course_load_scheduler.client.event.RemoveSectionsEvent;
import org.dselent.course_load_scheduler.client.exceptions.DuplicateCourseNumberException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyArrayException;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Calendar;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;

import com.google.gwt.event.shared.HandlerRegistration;
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
	private List<String> allCourseNumbers;
	
	private boolean newCourse;
	private int currentCourseId;
	
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
			this.allCourseNumbers = new ArrayList<String>();
			
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
		
		registration = eventBus.addHandler(ReceiveCourseNumberEvent.TYPE, this);
		eventBusRegistration.put(ReceiveCourseNumberEvent.TYPE, registration);
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
		currentCourseId = -1;
		if(course != null) {
			newCourse = false;
			view.setCourseNameTextBoxText(course.getCourseName());
			view.setCourseNumberTextBoxText(course.getCourseNumber());
			view.setFrequencyTextBoxText(Integer.toString(course.getFrequency()));
			currentCourseId = course.getId();
			currentSections = course.getSections();
			dataProvider.setList(currentSections);
			dataProvider.refresh();
		}
		
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
	    GetCourseNumberAction vca = new GetCourseNumberAction();
		GetCourseNumberEvent ace = new GetCourseNumberEvent(vca, container);
		eventBus.fireEvent(ace);
	}
	
	@Override
	public void addSection() {
		Section section = new Section();
		
		String sectionName = view.getSectionNameTextBox().getText();
		String crnString = view.getCrnTextBox().getText();
		String type = view.getTypeTextBox().getText();
		String expectedPopString = view.getPopTextBox().getText();
		String yearString = view.getYearTextBox().getText();
		String days = view.getDaysTextBox().getText();
		String term = view.getTermTextBox().getText();
		String startTime = view.getStartTimeTextBox().getText();
		String endTime = view.getEndTimeTextBox().getText();
		int crn = 0;
		int expectedPop = 0;
		int year = 0;
		
		List<String> invalidReasonList = new ArrayList<>();
		
		try {
			checkEmptyString(sectionName);
			checkEmptyString(crnString);
			checkEmptyString(type);
			checkEmptyString(expectedPopString);
			checkEmptyString(yearString);
			checkEmptyString(days);
			checkEmptyString(term);
			checkEmptyString(startTime);
			checkEmptyString(endTime);
			
			crn = Integer.parseInt(crnString);
			expectedPop = Integer.parseInt(expectedPopString);
			year = Integer.parseInt(yearString);
		}
		catch(EmptyStringException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.EMPTY_SECTION_FIELD);
		}
		catch(NumberFormatException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.INTEGER_SECTION_FIELDS);
		}
		
		if(invalidReasonList.size() == 0)
		{
			Calendar calendar = new Calendar();
			calendar.setDays(days);
			calendar.setYear(year);
			calendar.setSemester(term);
			calendar.setStart_time(startTime);
			calendar.setEnd_time(endTime);
			
			section.setSectionName(sectionName);
			section.setCrn(crn);
			section.setType(type);
			section.setExpectedPopulation(expectedPop);
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
	
	private void checkDuplicateCourseNumber(String courseNumber) throws DuplicateCourseNumberException
	{
		for(int i = 0; i < allCourseNumbers.size(); i++) {
			if(courseNumber.equalsIgnoreCase(allCourseNumbers.get(i))) {
				throw new DuplicateCourseNumberException();
			}
		}
	}
	
	@Override
	public void onReceiveCourseNumber(ReceiveCourseNumberEvent evt)
	{
		allCourseNumbers = evt.getAction().getCourseNumbers();
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
		String frequencyString = view.getFrequencyTextBox().getText();
		List<Section> sections = currentSections;
		int frequency = 0;
		
		List<String> invalidReasonList = new ArrayList<>();
		
		try {
			checkEmptyString(courseName);
			checkEmptyString(courseNumber);
			checkEmptyString(frequencyString);
			checkEmptyArray(sections);
			checkDuplicateCourseNumber(courseNumber);
			frequency = Integer.parseInt(frequencyString);
		}
		catch (EmptyStringException | EmptyArrayException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.EMPTY_COURSE_FIELD);
		} catch (DuplicateCourseNumberException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.DUPLICATE_COURSE_NAME);
		} catch (NumberFormatException e) {
			invalidReasonList.add(InvalidAddModifyCourseStrings.INTEGER_COURSE_FIELDS);
		}
		
		if(invalidReasonList.size() == 0) {
			parentPresenter.showLoadScreen();
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setFrequency(frequency);
			course.setSections(sections);
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			
			if(newCourse) {
				AddCourseAction vca = new AddCourseAction(course);
				AddCourseEvent ace = new AddCourseEvent(vca, container);
				eventBus.fireEvent(ace);
			}
			else {
				course.setId(currentCourseId);
				if(addedSections.size() > 0) {
					int courseId = course.getId();
					for(int i = 0; i < addedSections.size(); i++) {
						addedSections.get(i).setCourseId(courseId);
					}
					AddSectionsAction asa = new AddSectionsAction(addedSections);
					AddSectionsEvent ase = new AddSectionsEvent(asa, container);
					eventBus.fireEvent(ase);
				}
				if(removedSections.size() > 0) {
					RemoveSectionsAction rsa = new RemoveSectionsAction(removedSections);
					RemoveSectionsEvent rse = new RemoveSectionsEvent(rsa, container);
					eventBus.fireEvent(rse);
				}
				ModifyCourseAction mca = new ModifyCourseAction(course);
				ModifyCourseEvent mce = new ModifyCourseEvent(mca, container);
				eventBus.fireEvent(mce);
				
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
