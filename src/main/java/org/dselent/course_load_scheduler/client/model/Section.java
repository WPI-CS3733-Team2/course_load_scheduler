package org.dselent.course_load_scheduler.client.model;

public class Section extends Model
{	
	// attributes
	
	private Integer id;
	private String sectionName;
	private Integer crn;
	private String type;
	private Integer expectedPopulation;
	private Calendar calendar;
	private Integer courseId;
	private Integer calendarId;
	private Integer scheduleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Integer getCrn() {
		return crn;
	}
	public void setCrn(Integer crn) {
		this.crn = crn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getExpectedPopulation() {
		return expectedPopulation;
	}
	public void setExpectedPopulation(Integer expectedPopulation) {
		this.expectedPopulation = expectedPopulation;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(Integer calendarId) {
		this.calendarId = calendarId;
	}
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendar == null) ? 0 : calendar.hashCode());
		result = prime * result + ((calendarId == null) ? 0 : calendarId.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((crn == null) ? 0 : crn.hashCode());
		result = prime * result + ((expectedPopulation == null) ? 0 : expectedPopulation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (calendar == null) {
			if (other.calendar != null)
				return false;
		} else if (!calendar.equals(other.calendar))
			return false;
		if (calendarId == null) {
			if (other.calendarId != null)
				return false;
		} else if (!calendarId.equals(other.calendarId))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (crn == null) {
			if (other.crn != null)
				return false;
		} else if (!crn.equals(other.crn))
			return false;
		if (expectedPopulation == null) {
			if (other.expectedPopulation != null)
				return false;
		} else if (!expectedPopulation.equals(other.expectedPopulation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", sectionName=" + sectionName + ", crn=" + crn + ", type=" + type
				+ ", expectedPopulation=" + expectedPopulation + ", calendar=" + calendar + ", courseId=" + courseId
				+ ", calendarId=" + calendarId + ", scheduleId=" + scheduleId + "]";
	}
	

}
