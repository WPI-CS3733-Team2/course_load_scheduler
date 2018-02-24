package org.dselent.course_load_scheduler.client.action;

import java.util.List;

public class ReceiveChangeRequestStateAction extends Action{
	private Integer affectedRows;
	
	public ReceiveChangeRequestStateAction(int affectedRows)
	{
		this.affectedRows = affectedRows;
	}

	public int geAffectedRows()
	{
		return affectedRows;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveChangeRequestStateAction [affectedRows=");
		builder.append(affectedRows);
		builder.append("]");
		return builder.toString();
	}
}
