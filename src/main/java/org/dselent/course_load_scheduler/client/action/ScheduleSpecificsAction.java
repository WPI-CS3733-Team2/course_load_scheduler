package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Schedule;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class ScheduleSpecificsAction extends Action
{
	private Schedule schedule;
	
	public ScheduleSpecificsAction(Schedule schedule)
	{
		this.schedule = schedule;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	@Override
	public String toString() {
		return "ScheduleSpecificsAction [schedule=" + schedule + "]";
	}

}
