package org.dselent.course_load_scheduler.client.action;

public class TriggerChangePasswordWindowAction
{
	private int userId;
	
	public TriggerChangePasswordWindowAction(int userId)
	{
		this.userId = userId;
	}
	
	public int getUserId()
	{
		return this.userId;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("TriggerChangePasswordWindowAction [userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
}
