package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Schedule;
import org.dselent.course_load_scheduler.client.model.User;

public class ReceiveScheduleSpecificsAction extends Action{
	private User user;
	private List<Course> models;
	private Schedule schedule;
	
	public ReceiveScheduleSpecificsAction(User user, List<Course> models)
	{
		this.user = user;
		this.models = models;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Course> getModels()
	{
		return models;
	}

	public void setModels(List<Course> models)
	{
		this.models = models;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ReceiveScheduleSpecificsAction [user=" + user + ", models=" + models + ", schedule=" + schedule + "]";
	}


}
