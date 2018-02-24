package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.FacultyCourse;

public class ReceiveFacultyCourseNavigationAction extends Action{
	private List<FacultyCourse> models;
	
	public ReceiveFacultyCourseNavigationAction(List<FacultyCourse> models)
	{
		this.models = models;
	}

	public List<FacultyCourse> getModels()
	{
		return models;
	}

	public void setModels(List<FacultyCourse> models)
	{
		this.models = models;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveFacultyCourseNavigationAction [models=");
		builder.append(models);
		builder.append("]");
		return builder.toString();
	}
}
