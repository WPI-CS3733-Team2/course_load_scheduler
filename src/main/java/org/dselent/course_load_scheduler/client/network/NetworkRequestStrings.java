package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static String LOGIN = "user/login";
	public static String LOAD_PENDING_REQUEST_LIST = "request/view_pending_requests";
	public static String CHANGE_REQUEST_STATE = "request/change_request_state";
	public static String VIEW_COURSES = "course/search_course";
	public static String VIEW_SECTIONS = "section/view_course_sections";
	public static String FACULTY_COURSE_MAP = "faculty_course_map/map";
	public static String SCHEDULE_SEARCH = "schedule/search_schedule";
	public static String SCHEDULE_SPECIFICS = "schedule/schedule_specifics";
	
	private NetworkRequestStrings() {};
}
