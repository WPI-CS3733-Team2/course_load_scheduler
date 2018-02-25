package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import java.util.List;


public class CreateScheduleAction extends Action{
	private Integer facultyId;
	private String scheduleName;
	private List<Integer> sectionIds = new ArrayList<Integer>();

	public CreateScheduleAction(Integer facultyId, String scheduleName, List<Integer> sectionIds) {

		this.facultyId = facultyId;
		this.scheduleName = scheduleName;
		this.sectionIds = sectionIds;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public List<Integer> getSectionIds() {
		return sectionIds;
	}

	@Override
	public String toString() {
		return "CreateScheduleAction [facultyId=" + facultyId + ", scheduleName=" + scheduleName + ", sectionIds="
				+ sectionIds + "]";
	}
	
}
