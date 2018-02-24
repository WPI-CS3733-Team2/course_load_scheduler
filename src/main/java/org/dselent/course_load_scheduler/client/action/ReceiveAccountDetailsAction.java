package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveAccountDetailsAction extends Action
{
	private UserInfo userInfo;
	
	public ReceiveAccountDetailsAction(UserInfo userInfo)
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
		builder.append("ReceiveAccountDetailsAction [userInfo=");
		builder.append(userInfo);
		builder.append("]");
		return builder.toString();
	}

}
