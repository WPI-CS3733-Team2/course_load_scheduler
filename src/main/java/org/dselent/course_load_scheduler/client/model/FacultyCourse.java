package org.dselent.course_load_scheduler.client.model;

import java.util.List;


public class FacultyCourse extends Model
{	
	// attributes
	private String firstName;
	private String lastName;
	private String courseAssignment;

	// methods
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

	public String getCourseAssignment() {
		return courseAssignment;
	}

	public void setCourseAssignment(String courseAssignment) {
		this.courseAssignment = courseAssignment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseAssignment == null) ? 0 : courseAssignment.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (courseAssignment == null) {
			if (other.courseAssignment != null)
				return false;
		} else if (!courseAssignment.equals(other.courseAssignment))
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
		return true;
	}

	@Override
	public String toString() {
		return "FacultyCourse [firstName=" + firstName + ", lastName=" + lastName + ", courseAssignment="
				+ courseAssignment + "]";
	}
	
}
