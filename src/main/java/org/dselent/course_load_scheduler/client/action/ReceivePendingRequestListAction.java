package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Request;
import java.util.List;

public class ReceivePendingRequestListAction extends Action{
	private List<Request> model;
	
	public ReceivePendingRequestListAction(List<Request> model)
	{
		this.model = model;
	}
	
	public List<Request> getModel(){
		return model;
	}
	
	public void setModel(List<Request> model) {
		this.model = model;
	}
	
	public boolean addAnRequest(Request element) {
		return this.model.add(element);
	}
	
	public void clearRequestList() {
		this.model.clear();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceivePendingRequestListAction [model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}

}
