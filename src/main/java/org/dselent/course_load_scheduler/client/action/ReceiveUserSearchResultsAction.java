package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UserInfo;

import java.util.List;

public class ReceiveUserSearchResultsAction extends Action{
	private List<UserInfo> users;
	
	public ReceiveUserSearchResultsAction(List<UserInfo> users) {
		this.users = users;
	}
	
	public List<UserInfo> getUsers(){
		return users;
	}
}
