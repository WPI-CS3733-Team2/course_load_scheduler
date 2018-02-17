package org.dselent.course_load_scheduler.client.presenter;

public interface RequestCoursePresenter extends BasePresenter {
	public void requestCourseCancel();
	public void requestCourseSubmit();
	public void clearForm();
}
