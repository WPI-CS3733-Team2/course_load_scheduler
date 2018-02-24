package org.dselent.course_load_scheduler.client.action;

public class SendChangeRequestStateAction extends Action {
	private int requestId;
	private int requestState;
	
	public SendChangeRequestStateAction(int requestId, int requestState)
	{
		this.requestId = requestId;
		this.requestState = requestState;
	}

	public int getRequestId()
	{
		return requestId;
	}

	public int getRequestState()
	{
		return requestState;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendChangeRequestStateAction [requestId=");
		builder.append(requestId);
		builder.append(", requestState=");
		builder.append(requestState);
		builder.append("]");
		return builder.toString();
	}
}
