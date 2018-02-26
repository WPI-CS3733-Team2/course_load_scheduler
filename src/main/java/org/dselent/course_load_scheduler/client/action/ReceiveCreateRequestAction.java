package org.dselent.course_load_scheduler.client.action;

public class ReceiveCreateRequestAction extends Action
{
	private Integer affectedRows;

	public ReceiveCreateRequestAction(Integer affectedRows)
	{
		this.affectedRows = affectedRows;
	}
	
	public int getAffectedRows()
	{
		return affectedRows;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveCreateRequestAction [affectedRows=");
		builder.append(affectedRows);
		builder.append("]");
		return builder.toString();
	}
}
