package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.User;

public class UserDetailsPageAction {
	private User user;
	
	public UserDetailsPageAction() {
		this.user = new User();
	}
	
	public User getUser() {
		return user;
	}
}
