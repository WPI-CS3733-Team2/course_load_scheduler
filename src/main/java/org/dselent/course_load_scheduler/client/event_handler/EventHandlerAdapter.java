package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSubmitRequestEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAddCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangeRequestStateEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCourseNumberEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveFacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.event.RequestCourseEvent;
import org.dselent.course_load_scheduler.client.event.RequestInboxNavigationEvent;
import org.dselent.course_load_scheduler.client.event.ScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendChangeRequestStateEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestsDetailsEvent;
import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCalendarEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.event.GetCourseNumberEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAddSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.AddCourseEvent;
import org.dselent.course_load_scheduler.client.event.AddSectionsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCalendarEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.AdminSectionEvent;
import org.dselent.course_load_scheduler.client.event.ConfirmSchedulePageEvent;
import org.dselent.course_load_scheduler.client.event.CreateModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectCoursesEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.event.InvalidSearchCourseEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.SearchSpecificCourseEvent;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.event.ViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.UserCreatePageEvent;
import org.dselent.course_load_scheduler.client.event.UserDetailsPageEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveRequestsDetailsEvent;
import org.dselent.course_load_scheduler.client.event.LoginNavigationEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveScheduleSpecificsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectFacultyEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.RemoveSectionsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCreatedUserEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveUserSearchResultsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveTerminatedAccountEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEvent;

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
		InvalidChangePasswordEventHandler, SendChangePasswordEventHandler, ModifyCourseEventHandler,
		InvalidSearchCourseEventHandler, AdminCourseEventHandler, FacultyCourseEventHandler,
		InvalidAddSectionEventHandler, InvalidSubmitCourseEventHandler, UserSearchPageEventHandler,
		UserCreatePageEventHandler, UserDetailsPageEventHandler, ConfirmSchedulePageEventHandler,
		SearchScheduleEventHandler, ScheduleSpecificsEventHandler, CreateScheduleSelectCoursesEventHandler,
		CreateScheduleSelectFacultyEventHandler, RequestCourseEventHandler, InvalidSubmitRequestEventHandler,
		CreateScheduleNavigationEventHandler, SearchScheduleNavigationEventHandler, ViewScheduleNavigationEventHandler,
		FacultyCourseNavigationEventHandler, RequestInboxNavigationEventHandler, ReceiveLoginEventHandler,
		ReceiveCreatedUserEventHandler, ReceiveUserSearchResultsEventHandler, SendChangeRequestStateEventHandler,
		ReceiveChangeRequestStateEventHandler, ReceiveFacultyCourseEventHandler, ReceiveTerminatedAccountEventHandler,
		FacultySectionEventHandler, ReceiveFacultyCourseNavigationEventHandler,
		ReceiveViewScheduleNavigationEventHandler, ReceiveScheduleSpecificsEventHandler, InvalidEventHandler,
		SendAccountDetailsEventHandler, ReceiveAccountDetailsEventHandler, InvalidAccountDetailsEventHandler,
		SendRequestsDetailsEventHandler, ReceiveRequestsDetailsEventHandler, SendCreateRequestEventHandler,
		ReceiveCreateRequestEventHandler, AdminSectionEventHandler, ReceiveAdminCourseEventHandler,
		ReceiveCreateScheduleNavigationEventHandler, ReceiveSelectFacultyEventHandler,
		ReceiveChangePasswordEventHandler, AddCourseEventHandler, ReceiveAddCourseEventHandler, AddSectionsEventHandler,
		InvalidAddCourseEventHandler, LoginNavigationEventHandler, AdminCalendarEventHandler,
		FacultyCalendarEventHandler, RemoveSectionsEventHandler, CreateModifyCourseEventHandler,
		GetCourseNumberEventHandler, ReceiveCourseNumberEventHandler {

	@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {
	}

	@Override
	public void onSendLogin(SendLoginEvent evt) {
	}

	@Override
	public void onSearchUser(SearchUserEvent evt) {
	}

	@Override
	public void onCreateUser(CreateUserEvent evt) {
	}

	@Override
	public void onTerminateAccount(TerminateAccountEvent evt) {
	}

	@Override
	public void onCreateSchedule(CreateScheduleEvent evt) {
	}

	@Override
	public void onSendChangePassword(SendChangePasswordEvent evt) {
	}

	@Override
	public void onInvalidChangePassword(InvalidChangePasswordEvent evt) {
	}

	@Override
	public void onModifyCourse(ModifyCourseEvent evt) {
	}

	@Override
	public void onFacultyCourse(FacultyCourseEvent evt) {
	}

	@Override
	public void onInvalidSearchCourse(InvalidSearchCourseEvent evt) {
	}

	@Override
	public void onAdminCourse(AdminCourseEvent evt) {
	}

	@Override
	public void onSearchSchedule(SearchScheduleEvent evt) {
	}

	@Override
	public void onScheduleSpecifics(ScheduleSpecificsEvent evt) {
	}

	@Override
	public void onUserSearchPage(UserSearchPageEvent evt) {
	}

	@Override
	public void onUserCreatePage(UserCreatePageEvent evt) {
	}

	@Override
	public void onUserDetailsPage(UserDetailsPageEvent evt) {
	}

	@Override
	public void onConfirmSchedulePage(ConfirmSchedulePageEvent evt) {
	}

	@Override
	public void onInvalidAddSection(InvalidAddSectionEvent evt) {
	}

	@Override
	public void onInvalidSubmitCourse(InvalidSubmitCourseEvent evt) {
	}

	@Override
	public void onCreateScheduleSelectCourses(CreateScheduleSelectCoursesEvent evt) {
	}

	@Override
	public void onCreateScheduleSelectFaculty(CreateScheduleSelectFacultyEvent evt) {
	}

	@Override
	public void onRequestCourse(RequestCourseEvent evt) {
	}

	@Override
	public void onInvalidSubmitRequest(InvalidSubmitRequestEvent evt) {
	}

	@Override
	public void onCreateScheduleNavigation(CreateScheduleNavigationEvent evt) {
	}

	@Override
	public void onSearchScheduleNavigation(SearchScheduleNavigationEvent evt) {
	}

	@Override
	public void onViewScheduleNavigation(ViewScheduleNavigationEvent evt) {
	}

	@Override
	public void onFacultyCourseNavigation(FacultyCourseNavigationEvent evt) {
	}

	@Override
	public void onSendAccountDetails(SendAccountDetailsEvent evt) {
	}

	@Override
	public void onReceiveAccountDetails(ReceiveAccountDetailsEvent evt) {
	}

	@Override
	public void onReceiveChangePassword(ReceiveChangePasswordEvent evt) {
	}

	@Override
	public void onInvalidAccountDetails(InvalidAccountDetailsEvent evt) {
	}

	@Override
	public void onRequestInboxNavigation(RequestInboxNavigationEvent evt) {
	}

	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt) {
	}

	@Override
	public void onReceiveCreatedUser(ReceiveCreatedUserEvent evt) {
	}

	@Override
	public void onReceiveUserSearchResults(ReceiveUserSearchResultsEvent evt) {
	}

	@Override
	public void onSendChangeRequestState(SendChangeRequestStateEvent evt) {
	}

	@Override
	public void onReceiveTerminatedAccount(ReceiveTerminatedAccountEvent evt) {
	}

	@Override
	public void onReceiveChangeRequestState(ReceiveChangeRequestStateEvent evt) {
	}

	@Override
	public void onReceiveFacultyCourse(ReceiveFacultyCourseEvent evt) {
	}

	@Override
	public void onReceiveAdminCourse(ReceiveAdminCourseEvent evt) {
	}

	@Override
	public void onFacultySection(FacultySectionEvent evt) {
	}

	@Override
	public void onAdminSection(AdminSectionEvent evt) {
	}

	@Override
	public void onReceiveFacultyCourseNavigation(ReceiveFacultyCourseNavigationEvent evt) {
	}

	@Override
	public void onReceiveViewScheduleNavigation(ReceiveViewScheduleNavigationEvent evt) {
	}

	@Override
	public void onReceiveScheduleSpecifics(ReceiveScheduleSpecificsEvent evt) {
	}

	@Override
	public void onReceiveCreateScheduleNavigation(ReceiveCreateScheduleNavigationEvent evt) {
	}

	@Override
	public void onSearchSpecificCourse(SearchSpecificCourseEvent evt) {
	}

	@Override
	public void onReceiveSelectFaculty(ReceiveSelectFacultyEvent evt) {
	}

	@Override
	public void onInvalid(InvalidEvent evt) {
	}

	@Override
	public void onSendRequestsDetails(SendRequestsDetailsEvent evt) {
	}

	@Override
	public void onReceiveRequestsDetails(ReceiveRequestsDetailsEvent evt) {
	}

	@Override
	public void onSendCreateRequest(SendCreateRequestEvent evt) {
	}

	@Override
	public void onReceiveCreateRequest(ReceiveCreateRequestEvent evt) {
	}

	@Override
	public void onAddCourse(AddCourseEvent evt) {
	}

	@Override
	public void onReceiveAddCourse(ReceiveAddCourseEvent evt) {
	}

	@Override
	public void onAddSections(AddSectionsEvent evt) {
	}

	@Override
	public void onInvalidAddCourse(InvalidAddCourseEvent evt) {
	}

	@Override
	public void onLoginNavigation(LoginNavigationEvent evt) {
	}

	@Override
	public void onAdminCalendar(AdminCalendarEvent evt) {
	}

	@Override
	public void onFacultyCalendar(FacultyCalendarEvent evt) {
	}

	@Override
	public void onRemoveSections(RemoveSectionsEvent evt) {
	}

	@Override
	public void onCreateModifyCourse(CreateModifyCourseEvent evt) {
	}

	@Override
	public void onGetCourseNumber(GetCourseNumberEvent evt) {
	}

	@Override
	public void onReceiveCourseNumber(ReceiveCourseNumberEvent evt) {
	}

}
