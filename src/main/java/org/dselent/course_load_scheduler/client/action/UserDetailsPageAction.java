package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.User;

public class UserDetailsPageAction {
	private User user;
	
	public UserDetailsPageAction(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
