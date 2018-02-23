package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitRequestEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.event.RequestCourseEvent;
import org.dselent.course_load_scheduler.client.event.RequestInboxNavigationEvent;
import org.dselent.course_load_scheduler.client.event.ScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;
import org.dselent.course_load_scheduler.client.event.TriggerChangePasswordWindowEvent;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.AccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.event.SearchCourseEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.event.ViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.UserCreatePageEvent;
import org.dselent.course_load_scheduler.client.event.UserDetailsPageEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveViewScheduleNavigationEvent;

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
		InvalidAddSectionEventHandler, InvalidSubmitCourseEventHandler, UserSearchPageEventHandler,
		UserCreatePageEventHandler, UserDetailsPageEventHandler, ConfirmSchedulePageEventHandler,
		SearchScheduleEventHandler, ScheduleSpecificsEventHandler, CreateScheduleSelectCoursesEventHandler, 
		CreateScheduleSelectFacultyEventHandler, RequestCourseEventHandler, InvalidSubmitRequestEventHandler,
		CreateScheduleNavigationEventHandler, SearchScheduleNavigationEventHandler, ViewScheduleNavigationEventHandler,
		FacultyCourseNavigationEventHandler, AccountDetailsEventHandler, RequestInboxNavigationEventHandler, 
		ReceiveLoginEventHandler, ReceiveFacultyCourseEventHandler, FacultySectionEventHandler,
		ReceiveFacultyCourseNavigationEventHandler, ReceiveViewScheduleNavigationEventHandler {

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
	public void onFacultyCourse(FacultyCourseEvent evt) {}
	
	@Override
	public void onSearchCourse(SearchCourseEvent evt) {}

	@Override
	public void onAdminCourse(AdminCourseEvent evt) {}
	
	@Override
	public void onSearchSchedule(SearchScheduleEvent evt) {}
	
	@Override
	public void onScheduleSpecifics(ScheduleSpecificsEvent evt) {}

	@Override
	public void onUserSearchPage(UserSearchPageEvent evt) {}
	
	@Override
	public void onUserCreatePage(UserCreatePageEvent evt) {}
	
	@Override
	public void onUserDetailsPage(UserDetailsPageEvent evt) {}
	
	@Override
	public void onConfirmSchedulePage(ConfirmSchedulePageEvent evt) {}
	
	@Override
	public void onInvalidAddSection(InvalidAddSectionEvent evt) {}
	
	@Override
	public void onInvalidSubmitCourse(InvalidSubmitCourseEvent evt) {}
	
	@Override
	public void onCreateScheduleSelectCourses(CreateScheduleSelectCoursesEvent evt) {}

	@Override
	public void onCreateScheduleSelectFaculty(CreateScheduleSelectFacultyEvent evt) {}
	
	@Override
	public void onRequestCourse(RequestCourseEvent evt) {}
	
	@Override
	public void onInvalidSubmitRequest(InvalidSubmitRequestEvent evt) {}
	
	@Override
	public void onCreateScheduleNavigation(CreateScheduleNavigationEvent evt) {}
	
	@Override
	public void onSearchScheduleNavigation(SearchScheduleNavigationEvent evt) {}
	
	@Override
	public void onViewScheduleNavigation(ViewScheduleNavigationEvent evt) {}

	@Override
	public void onFacultyCourseNavigation(FacultyCourseNavigationEvent evt) {}

	@Override
	public void onAccountDetails(AccountDetailsEvent evt) {}
	
	@Override
	public void onRequestInboxNavigation(RequestInboxNavigationEvent evt) {}
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt) {}
	
	@Override
	public void onReceiveFacultyCourse(ReceiveFacultyCourseEvent evt) {}

	@Override
	public void onFacultySection(FacultySectionEvent evt) {}
	
	@Override
	public void onReceiveFacultyCourseNavigation(ReceiveFacultyCourseNavigationEvent evt) {}
	
	@Override
	public void onReceiveViewScheduleNavigation(ReceiveViewScheduleNavigationEvent evt) {}
}
