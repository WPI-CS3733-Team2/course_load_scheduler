package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitCourseEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;
import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SearchCourseEvent;

/**
 * Adapter class for convenience All classes that need to implement an event
 * handler can extend from this class This allows for presenters or other
 * classes not to implement a large number of handler interfaces Need to
 * register all event handling functions with this class by implementing the
 * handler and overriding with an empty method
 * 
 * 
 * 
 */
public abstract class EventHandlerAdapter implements InvalidLoginEventHandler, SendLoginEventHandler,
		SearchUserEventHandler, CreateUserEventHandler, TerminateAccountEventHandler, CreateScheduleEventHandler,
		InvalidChangePasswordEventHandler, SendChangePasswordEventHandler, TriggerChangePasswordWindowEventHandler,
		ModifyCourseEventHandler, SearchCourseEventHandler, AdminCourseEventHandler, FacultyCourseEventHandler,
		InvalidAddSectionEventHandler, InvalidSubmitCourseEventHandler {
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {}
	
	@Override
	public void onSendLogin(SendLoginEvent evt) {}
	
	@Override
	public void onSearchUser(SearchUserEvent evt) {}
	
	@Override
	public void onCreateUser(CreateUserEvent evt) {}
	
	@Override
	public void onTerminateAccount(TerminateAccountEvent evt) {}
	
	@Override
	public void onCreateSchedule(CreateScheduleEvent evt) {}
	
	@Override
	public void onTriggerChangePasswordWindow(TriggerChangePasswordWindowEvent evt) {}
	
	@Override
	public void onSendChangePassword(SendChangePasswordEvent evt){}
	
	@Override
	public void onInvalidChangePassword(InvalidChangePasswordEvent evt) {}
	
	@Override
	public void onModifyCourse(ModifyCourseEvent evt) {}
	
	@Override
	public void onSearchCourse(SearchCourseEvent evt) {}

	@Override
	public void onAdminCourse(AdminCourseEvent evt) {}
	
	@Override
	public void onFacultyCourse(FacultyCourseEvent evt) {}
	
	@Override
	public void onInvalidAddSection(InvalidAddSectionEvent evt) {}
	
	@Override
	public void onInvalidSubmitCourse(InvalidSubmitCourseEvent evt) {}
}
