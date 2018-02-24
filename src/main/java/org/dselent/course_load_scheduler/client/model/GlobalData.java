package org.dselent.course_load_scheduler.client.model;

import com.google.inject.Inject;

/*
 * Class to hold data persistent on the client that all parts of the application may need
 */
public class GlobalData
{
	private UserInfo userInfo;
	
	@Inject
	public GlobalData(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}
}
