package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Request;

public class SendCreateRequestAction extends Action
{
	private Request request;
	
	public SendCreateRequestAction(Request request) {
		this.request = request;
	}
	
	public Request getRequest() {
		return request;
	}
	
	@Override
	public String toString() {
		return "SendCreateRequestAction [request=" + request + "]";
	}
}
