package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String SERVER_LOCATION = "http://localhost:8080/";
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static String LOGIN = "user/login";
	public static String ACCOUNT_DETAILS = "user/account_details";
	public static String CHANGE_PASSWORD = "user/change_password";
	public static String LOAD_PENDING_REQUEST_LIST = "request/view_pending_requests";
	public static String REGISTER = "user/register";
	public static String CHANGE_REQUEST_STATE = "request/change_request_state";
	public static String USERSEARCH = "user/search_user";
	public static String ADD_COURSE = "course/create_course";
	public static String ADD_SECTIONS = "section/create_sections";
	public static String VIEW_COURSES = "course/search_course";
	public static String DELETEUSER = "user/delete";
	public static String VIEW_SECTIONS = "section/view_course_sections";
	public static String REQUEST_DETAILS = "request/view_pending_requests_details";
	public static String CREATE_REQUEST = "request/create_request";
	//Will have to change if it isn't right
	public static String CREATESCHEDULE = "schedule/create_schedule";
	public static String FACULTY_COURSE_MAP = "faculty_course_map/map";
	public static String SCHEDULE_SEARCH = "schedule/search_schedule";
	public static String SCHEDULE_SPECIFICS = "schedule/schedule_specifics";
	public static String GET_UNASSIGNED_COURSE_SECTIONS = "course/search_unassigned";
	public static String GET_UNASSIGNED_USERS = "user/unassigned_user";
	public static String CREATE_SCHEDULE = "schedule/create_schedule";
	
	
	private NetworkRequestStrings() {};
}
