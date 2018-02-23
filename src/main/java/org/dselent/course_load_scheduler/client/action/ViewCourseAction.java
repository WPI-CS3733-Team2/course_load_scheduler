package org.dselent.course_load_scheduler.client.action;

/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class ViewCourseAction extends Action
{
	private String courseName;
	private String courseNumber;
	private Integer frequency;
	
	public String getCourseName() {
		return courseName;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public Integer getFrequency() {
		return frequency;
	}
	
	public ViewCourseAction()
	{	
		courseName = "";
		courseNumber = "";
		frequency = -1;
	}
	
	public ViewCourseAction(String courseName, String courseNumber)
	{
		if(courseName != null) {
			this.courseName = courseName;
		}
		else {
			this.courseNumber = courseNumber;
		}
	}
	
	public ViewCourseAction(Integer frequency)
	{
		this.frequency = frequency;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(courseName);
		sb.append("\n");
		sb.append(courseNumber);
		sb.append("\n");
		sb.append(frequency);
		sb.append("\n");
		
		return sb.toString();
	}
}
