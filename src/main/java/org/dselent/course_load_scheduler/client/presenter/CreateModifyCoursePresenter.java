package org.dselent.course_load_scheduler.client.presenter;

public interface CreateModifyCoursePresenter extends BasePresenter {
	public void addSection();
	public void removeSection();
	public void createModifyCourseCancel();
	public void createModifyCourseSubmit();
	public void clearForm();
	public void clearSectionForm();
}
