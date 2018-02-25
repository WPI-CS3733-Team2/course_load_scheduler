package org.dselent.course_load_scheduler.client.action;

public class SendChangePasswordAction extends Action
{
	private String currentPassword;
	private String newPassword;
	private int userId;
	
	public SendChangePasswordAction(int userId, String currentPassword, String newPassword)
	{
		this.userId = userId;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public String getCurrentPassword()
	{
		return currentPassword;
	}
	
	public String getNewPassword()
	{
		return newPassword;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendChangePasswordAction [userId=");
		builder.append(userId);
		builder.append(", currentPassword=");
		builder.append(currentPassword);
		builder.append(", newPassword=");
		builder.append(newPassword);
		builder.append("]");
		return builder.toString();
	}
}
