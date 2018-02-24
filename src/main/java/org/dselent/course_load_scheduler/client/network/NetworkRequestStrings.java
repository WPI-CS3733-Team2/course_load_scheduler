package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String SERVER_LOCATION = "http://localhost:8081/";
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static String LOGIN = "user/login";
	public static String LOAD_PENDING_REQUEST_LIST = "request/view_pending_requests";
	public static String CHANGE_REQUEST_STATE = "request/change_request_state";
	
	private NetworkRequestStrings() {};
}
