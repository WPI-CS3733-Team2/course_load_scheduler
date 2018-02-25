package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.CreateScheduleAction;
import org.dselent.course_load_scheduler.client.action.CreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.CreateScheduleSelectFacultyAction;
import org.dselent.course_load_scheduler.client.action.SearchSpecificCourseAction;
import org.dselent.course_load_scheduler.client.callback.ScheduleSpecificsCallback;
import org.dselent.course_load_scheduler.client.callback.SelectCoursesCallback;
import org.dselent.course_load_scheduler.client.callback.SelectFacultyCallback;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.event.SearchSpecificCourseEvent;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.ScheduleCreationService;
import org.dselent.course_load_scheduler.client.translator.impl.CreateScheduleTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SelectCoursesTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SelectFacultyTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class ScheduleCreationServiceImpl extends BaseServiceImpl implements ScheduleCreationService
{
	public ScheduleCreationServiceImpl()
	{
		
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
		
		registration = eventBus.addHandler(CreateScheduleEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleEvent.TYPE, registration);
		
		registration = eventBus.addHandler(CreateScheduleNavigationEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleNavigationEvent.TYPE, registration);
		
		registration = eventBus.addHandler(CreateScheduleSelectCoursesEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleSelectCoursesEvent.TYPE, registration);
		
		registration = eventBus.addHandler(CreateScheduleSelectFacultyEvent.TYPE, this);
		eventBusRegistration.put(CreateScheduleSelectFacultyEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ConfirmSchedulePageEvent.TYPE, this);
		eventBusRegistration.put(ConfirmSchedulePageEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SearchSpecificCourseEvent.TYPE, this);
		eventBusRegistration.put(SearchSpecificCourseEvent.TYPE, registration);
	}
	
	@Override
	public void onCreateScheduleNavigation(CreateScheduleNavigationEvent evt) {
		CreateScheduleNavigationAction action = evt.getAction();
		SelectCoursesTranslatorImpl selectCoursesTranslator = new SelectCoursesTranslatorImpl();
		JSONObject json = selectCoursesTranslator.translateToJson(action);
		SelectCoursesCallback selectCoursesCallback = new SelectCoursesCallback(eventBus, evt.getContainer());
	
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_UNASSIGNED_COURSE_SECTIONS, selectCoursesCallback, json);
		request.send();
	}
	
	@Override
	public void onSearchSpecificCourse(SearchSpecificCourseEvent evt) {
		SearchSpecificCourseAction action = evt.getAction();
		SelectCoursesTranslatorImpl selectCoursesTranslator = new SelectCoursesTranslatorImpl();
		JSONObject json = selectCoursesTranslator.translateToJson(action);
		SelectCoursesCallback selectCoursesCallback = new SelectCoursesCallback(eventBus, evt.getContainer());
	
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_UNASSIGNED_COURSE_SECTIONS, selectCoursesCallback, json);
		request.send();
	}
	
	
	@Override
	public void onCreateScheduleSelectFaculty(CreateScheduleSelectFacultyEvent evt) {
		CreateScheduleSelectFacultyAction action = evt.getAction();
		SelectFacultyTranslatorImpl selectFacultyTranslator = new SelectFacultyTranslatorImpl();
		JSONObject json = selectFacultyTranslator.translateToJson(action);
		SelectFacultyCallback selectFacultyCallback = new SelectFacultyCallback(eventBus, evt.getContainer(), evt.getAction().getCourses());
	
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_UNASSIGNED_USERS, selectFacultyCallback, json);
		request.send();
	}
	
	
	@Override
	public void onCreateSchedule(CreateScheduleEvent evt) {
		CreateScheduleAction action = evt.getAction();
		Schedule schedule = new Schedule();
		schedule.setFacultyId(evt.getAction().getFacultyId());
		schedule.setScheduleName(evt.getAction().getScheduleName());
		CreateScheduleTranslatorImpl createScheduleTranslator = new CreateScheduleTranslatorImpl();
		JSONObject json = createScheduleTranslator.translateToJson(action);
		ScheduleSpecificsCallback viewScheduleNavigationCallback = new ScheduleSpecificsCallback(eventBus, evt.getContainer(), schedule);
	
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.CREATE_SCHEDULE, viewScheduleNavigationCallback, json);
		request.send();
	}

}
