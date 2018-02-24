package org.dselent.course_load_scheduler.client.action;

public class TerminateAccountAction extends Action{
	Integer userId;
	
	public TerminateAccountAction(Integer userId) {
		this.userId = userId;
	}
}
