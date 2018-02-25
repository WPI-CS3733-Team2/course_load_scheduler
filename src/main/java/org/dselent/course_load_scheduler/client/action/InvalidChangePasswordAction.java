package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;

public class InvalidChangePasswordAction {
	
	private List<String> reasonList;
	
	public InvalidChangePasswordAction()
	{
		reasonList = new ArrayList<>();
	}
	
	public InvalidChangePasswordAction(List<String> reasonList)
	{
		this.reasonList = reasonList;
	}
	
	public InvalidChangePasswordAction(String reason)
	{
		reasonList = new ArrayList<>();
		reasonList.add(reason);
	}

	public boolean addReasons(List<String> reasonList)
	{
		return reasonList.addAll(reasonList);
	}
	
	public void addReason(String reason)
	{
		reasonList.add(reason);
	}
	
	public String getReason(int index)
	{
		return reasonList.get(index);
	}
	
	public int getNumberOfReasons()
	{
		return reasonList.size();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(String reason : reasonList)
		{
			sb.append(reason);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
