package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String SERVER_LOCATION = "http://localhost:8081/";
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static String LOGIN = "user/login";
	public static String REGISTER = "user/register";
	public static String USERSEARCH = "user/search_user";
	public static String DELETEUSER = "user/delete";
	//Will have to change if it isn't right
	public static String CREATESCHEDULE = "schedule/create_schedule";
	
	
	private NetworkRequestStrings() {};
}
