package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;

public class ReceiveCreateScheduleNavigationAction extends Action{
	private List<Course> models;
	
	public ReceiveCreateScheduleNavigationAction(List<Course> models)
	{
		this.models = models;
	}

	public List<Course> getModels()
	{
		return models;
	}

	public void setModels(List<Course> models)
	{
		this.models = models;
	}

	@Override
	public String toString() {
		return "ReceiveScheduleSpecificsAction [models=" + models + "]";
	}


}
