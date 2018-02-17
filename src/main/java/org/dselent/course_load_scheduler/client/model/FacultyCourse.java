package org.dselent.course_load_scheduler.client.model;

import java.util.List;


public class FacultyCourse extends Model
{	
	// attributes
	
	private Integer user_id;
	private Integer faculty_id;
	private List<Integer> course_idList;
	private List<Integer> section_idList;
	private List<Integer> calendar_idList;
	private String firstName;
	private String lastName;
	private List<String> courseNumberList;
	private List<String> sectionNameList;
	private List<String> semesterList;

	// methods
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}

	public List<Integer> getCourse_idList() {
		return course_idList;
	}

	public void setCourse_idList(List<Integer> course_idList) {
		this.course_idList = course_idList;
	}

	public List<Integer> getSection_idList() {
		return section_idList;
	}

	public void setSection_idList(List<Integer> section_idList) {
		this.section_idList = section_idList;
	}

	public List<Integer> getCalendar_idList() {
		return calendar_idList;
	}

	public void setCalendar_idList(List<Integer> calendar_idList) {
		this.calendar_idList = calendar_idList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getCourseNumberList() {
		return courseNumberList;
	}

	public void setCourseNumberList(List<String> courseNumberList) {
		this.courseNumberList = courseNumberList;
	}

	public List<String> getSectionNameList() {
		return sectionNameList;
	}

	public void setSectionNameList(List<String> sectionNameList) {
		this.sectionNameList = sectionNameList;
	}

	public List<String> getSemesterList() {
		return semesterList;
	}

	public void setSemesterList(List<String> termList) {
		this.semesterList = termList;
	}
	
	public void addCourse_idList(Integer course_id) {
		this.course_idList.add(course_id);
	}
	
	public void addSection_idList(Integer section_id) {
		this.section_idList.add(section_id);
	}
	
	public void addCalendar_idList(Integer calendar_id) {
		this.calendar_idList.add(calendar_id);
	}
	
	public void addCourseNumberList(String courseNumber) {
		this.courseNumberList.add(courseNumber);
	}
	
	public void addSectionNameList(String sectionName) {
		this.sectionNameList.add(sectionName);
	}
	
	public void addSemesterList(String semester) {
		this.semesterList.add(semester);
	}
	
	public String makePresenterString() {
		String courseString = null;
		for (int i = 0; i < courseNumberList.size(); i++) {
			courseString = courseString + (courseNumberList.get(i) + ' ' + sectionNameList.get(i) + ' ' + semesterList.get(i));
			if (i < (courseNumberList.size() - 1)) {
				courseString = courseString + ", ";
			}
		}
		
		return courseString;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendar_idList == null) ? 0 : calendar_idList.hashCode());
		result = prime * result + ((courseNumberList == null) ? 0 : courseNumberList.hashCode());
		result = prime * result + ((course_idList == null) ? 0 : course_idList.hashCode());
		result = prime * result + ((faculty_id == null) ? 0 : faculty_id.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((sectionNameList == null) ? 0 : sectionNameList.hashCode());
		result = prime * result + ((section_idList == null) ? 0 : section_idList.hashCode());
		result = prime * result + ((semesterList == null) ? 0 : semesterList.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		FacultyCourse other = (FacultyCourse) obj;
		if (calendar_idList == null) {
			if (other.calendar_idList != null)
				return false;
		} else if (!calendar_idList.equals(other.calendar_idList))
			return false;
		if (courseNumberList == null) {
			if (other.courseNumberList != null)
				return false;
		} else if (!courseNumberList.equals(other.courseNumberList))
			return false;
		if (course_idList == null) {
			if (other.course_idList != null)
				return false;
		} else if (!course_idList.equals(other.course_idList))
			return false;
		if (faculty_id == null) {
			if (other.faculty_id != null)
				return false;
		} else if (!faculty_id.equals(other.faculty_id))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (sectionNameList == null) {
			if (other.sectionNameList != null)
				return false;
		} else if (!sectionNameList.equals(other.sectionNameList))
			return false;
		if (section_idList == null) {
			if (other.section_idList != null)
				return false;
		} else if (!section_idList.equals(other.section_idList))
			return false;
		if (semesterList == null) {
			if (other.semesterList != null)
				return false;
		} else if (!semesterList.equals(other.semesterList))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "FacultyCourse [user_id=" + user_id + ", faculty_id=" + faculty_id + ", course_idList=" + course_idList
				+ ", section_idList=" + section_idList + ", calendar_idList=" + calendar_idList + ", firstName="
				+ firstName + ", lastName=" + lastName + ", courseNumberList=" + courseNumberList + ", sectionNameList="
				+ sectionNameList + ", semesterList=" + semesterList + "]";
	}
	
}
