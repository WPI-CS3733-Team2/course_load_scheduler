package org.dselent.course_load_scheduler.client.action;


public class ViewScheduleNavigationAction extends Action{
	private String searchBy;
	private String searchTerm;
	
	public ViewScheduleNavigationAction(){
		this.searchBy = "this search by doesn't even matter";
		this.searchTerm = "it's just going to get all the schedules";
	}

	public String getSearchBy() {
		return searchBy;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "ViewScheduleNavigationAction [searchBy=" + searchBy + ", searchTerm=" + searchTerm + "]";
	}

}
