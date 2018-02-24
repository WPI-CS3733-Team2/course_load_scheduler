package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.UserInfo;

public class UserDetailsPageAction extends Action
{
	private UserInfo userInfo;
	
	public UserDetailsPageAction(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}
	
	public UserInfo getUserInfo()
	{
		return userInfo;
	}
}
