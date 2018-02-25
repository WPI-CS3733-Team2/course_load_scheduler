package org.dselent.course_load_scheduler.client.action;


/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class SearchSpecificCourseAction extends Action 
{
	private String searchTerm;
	
	public SearchSpecificCourseAction(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "SearchScheduleAction [searchTerm=" + searchTerm + "]";
	}

}
