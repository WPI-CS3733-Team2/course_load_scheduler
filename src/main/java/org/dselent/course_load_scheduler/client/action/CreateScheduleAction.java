package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Schedule;

public class CreateScheduleAction {
	private Schedule schedule;
	
	public CreateScheduleAction(Schedule schedule){
		this.schedule = schedule;
	}
	
	@Override
	public String toString()
	{
		return this.schedule.toString();
	}
}
