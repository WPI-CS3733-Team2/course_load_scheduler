package org.dselent.course_load_scheduler.client.action;


/**
 * Actions are used to package up data to be sent on the event bus
 * This particular action is for data related to an invalid login attempt caught client-side
 * 
 * @author dselent
 *
 */
public class SearchScheduleAction 
{
	private String queryTerm;
	private String searchBy;
	
	public SearchScheduleAction(String queryTerm, String searchBy)
	{
		this.queryTerm = queryTerm;
		this.searchBy = searchBy;
	}
	
	public String getQueryTerm() {
		return queryTerm;
	}

	public String getSearchBy() {
		return searchBy;
	}

	@Override
	public String toString() {
		return "SearchScheduleAction [queryTerm=" + queryTerm + ", searchBy=" + searchBy + "]";
	}

}
