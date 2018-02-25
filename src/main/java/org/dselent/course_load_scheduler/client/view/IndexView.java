package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;

public interface IndexView extends BaseView<IndexPresenter>
{
	public MenuItem getAccountMenuItem();
	public void setAccountMenuItem(MenuItem accountMenuItem);
	public void setAccountCommand(Command cmd);
	public MenuItem getSchedulesMenuItem();
	public void setSchedulesMenuItem(MenuItem schedulesMenuItem);
	public void setSchedulesCommand(Command cmd);
	public MenuItem getViewScheduleMenuItem();
	public void setViewScheduleMenuItem(MenuItem viewScheduleMenuItem);
	public void setViewScheduleCommand(Command cmd);
	public MenuItem getSearchScheduleMenuItem();
	public void setSearchScheduleMenuItem(MenuItem searchScheduleMenuItem);
	public void setSearchScheduleCommand(Command cmd);
	public MenuItem getCreateScheduleMenuItem();
	public void setCreateScheduleMenuItem(MenuItem createScheduleMenuItem);
	public void setCreateScheduleCommand(Command cmd);
	public MenuItem getCoursesMenuItem();
	public void setCoursesMenuItem(MenuItem coursesMenuItem);
	public void setCoursesCommand(Command cmd);
	public MenuItem getUsersMenuItem();
	public void setUsersMenuItem(MenuItem usersMenuItem);
	public void setUsersCommand(Command cmd);
	public MenuItem getRequestsMenuItem();
	public void setRequestsMenuItem(MenuItem requestsMenuItem);
	public void setRequestsCommand(Command cmd);
	HTMLPanel getMainPanel();
	void setMainPanel(HTMLPanel mainPanel);
	PopupPanel getGlassLoadingPanel();
	Image getLoadingImage();
	MenuItem getFacultyCourseMenuItem();
	void setFacultyCourseMenuItem(MenuItem facultyCourseMenuItem);
	public void setFacultyCourseCommand(Command command);
	public MenuBar getNavigationMenu();
	void showErrorMessages(String errorMessages);

}
