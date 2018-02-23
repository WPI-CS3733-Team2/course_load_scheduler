package org.dselent.course_load_scheduler.client.action;


/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class SearchScheduleAction extends Action 
{
	private String searchTerm;
	private String searchBy;
	
	public SearchScheduleAction(String searchBy, String searchTerm)
	{
		this.searchTerm = searchTerm;
		this.searchBy = searchBy;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}

	public String getSearchBy() {
		return searchBy;
	}

	@Override
	public String toString() {
		return "SearchScheduleAction [searchBy=" + searchBy + ", searchTerm=" + searchTerm + "]";
	}

}
