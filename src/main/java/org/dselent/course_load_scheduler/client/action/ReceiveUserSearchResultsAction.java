package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.User;

import java.util.List;

public class ReceiveUserSearchResultsAction extends Action{
	private List<User> users;
	
	public ReceiveUserSearchResultsAction(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers(){
		return users;
	}
}
