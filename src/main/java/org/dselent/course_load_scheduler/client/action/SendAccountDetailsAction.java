package org.dselent.course_load_scheduler.client.action;

public class SendAccountDetailsAction extends Action
{
	private int userId;
	
	public SendAccountDetailsAction(int userId)
	{
		this.userId = userId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendAccountDetailsAction [userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}

	
}