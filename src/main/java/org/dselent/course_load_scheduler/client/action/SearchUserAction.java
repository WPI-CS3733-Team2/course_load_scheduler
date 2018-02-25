package org.dselent.course_load_scheduler.client.action;

public class SearchUserAction extends Action{
	private String query;
	private Integer searchBy;
	//Not sure if I should make an enum for searchBy
	//1 maps to WPI ID, 2 to username, 3 to first name, 4 to last name, and 5 to email
	
	public SearchUserAction(String query, Integer searchBy) {
		this.query = query;
		this.searchBy = searchBy;
	}
	
	public String getQuery() {
		return query;
	}
	
	public Integer getSearchBy() {
		return searchBy;
	}
}
