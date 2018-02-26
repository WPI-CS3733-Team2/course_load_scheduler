package org.dselent.course_load_scheduler.client.model;

public class RequestInfo extends Model
{
	private Request request;
	private String fullName;
	private String courseNumber;
	
	public RequestInfo()
	{
		
	}
	
	public Request getRequest()
	{
		return request;
	}

	public void setRequest(Request request)
	{
		this.request = request;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public String getCourseNumber()
	{
		return courseNumber;
	}
	
	public void setCourseNumber(String courseNumber)
	{
		this.courseNumber = courseNumber;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((courseNumber == null) ? 0 : courseNumber.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestInfo other = (RequestInfo) obj;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (courseNumber == null) {
			if (other.courseNumber != null)
				return false;
		} else if (!courseNumber.equals(other.courseNumber))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnRequestInfo [request=");
		builder.append(request);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", courseNumber=");
		builder.append(courseNumber);
		builder.append("]");
		return builder.toString();
	}
}
