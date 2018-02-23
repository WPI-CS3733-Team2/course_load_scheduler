package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Schedule;

public class ReceiveViewScheduleNavigationAction extends Action{
	private List<Schedule> models;
	
	public ReceiveViewScheduleNavigationAction(List<Schedule> models)
	{
		this.models = models;
	}

	public List<Schedule> getModels()
	{
		return models;
	}

	public void setModels(List<Schedule> models)
	{
		this.models = models;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveViewScheduleNavigationAction [models=");
		builder.append(models);
		builder.append("]");
		return builder.toString();
	}
}
