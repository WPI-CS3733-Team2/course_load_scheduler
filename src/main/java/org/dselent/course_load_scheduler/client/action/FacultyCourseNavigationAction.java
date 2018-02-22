package org.dselent.course_load_scheduler.client.action;


public class FacultyCourseNavigationAction extends Action{
	
	private String test;
	
	public FacultyCourseNavigationAction(){
		this.test = "Request";
	}

	public String getTest() {
		return test;
	}

	@Override
	public String toString() {
		return "FacultyCourseNavigationAction [test=" + test + "]";
	}
}
