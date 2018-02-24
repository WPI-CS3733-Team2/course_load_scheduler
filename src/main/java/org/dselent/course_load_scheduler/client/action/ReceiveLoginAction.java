package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveLoginAction extends Action
{
	private UserInfo userInfo;
	
	public ReceiveLoginAction(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}
	
	public UserInfo getUserInfo()
	{
		return userInfo;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveLoginAction [userInfo=");
		builder.append(userInfo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
