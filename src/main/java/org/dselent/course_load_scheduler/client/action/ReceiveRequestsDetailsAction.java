package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.RequestInfo;

public class ReceiveRequestsDetailsAction extends Action{
	private List<RequestInfo> model;
	
	public ReceiveRequestsDetailsAction(List<RequestInfo> model) {
		this.model = model;
	}
	
	public List<RequestInfo> getModel(){
		return model;
	}
	
	public void setModel(List<RequestInfo> model) {
		this.model = model;
	}
	
	public boolean addAnRequestInfo(RequestInfo element) {
		return this.model.add(element);
	}
	
	public void clearRequestInfoList() {
		this.model.clear();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveRequestsDetailsAction [model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}
}
