package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.IndexView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuBar;

public class IndexViewImpl extends BaseViewImpl<IndexPresenter> implements IndexView
{
	private static IndexViewImplUiBinder uiBinder = GWT.create(IndexViewImplUiBinder.class);

	interface IndexViewImplUiBinder extends UiBinder<Widget, IndexViewImpl> {}
	
	@UiField
	HTMLPanel mainPanel;

	@UiField
	Image loadingImage;

	@UiField
	PopupPanel glassLoadingPanel;
	@UiField
	MenuItem accountMenuItem;
	@UiField
	MenuItem schedulesMenuItem;
	@UiField
	MenuItem viewScheduleMenuItem;
	@UiField
	MenuItem searchScheduleMenuItem;
	@UiField
	MenuItem createScheduleMenuItem;
	@UiField
	MenuItem coursesMenuItem;
	@UiField
	MenuItem usersMenuItem;
	@UiField
	MenuItem requestsMenuItem;
	@UiField 
	MenuBar navigationMenu;
	
	public MenuItem getAccountMenuItem() {
		return accountMenuItem;
	}

	public void setAccountMenuItem(MenuItem accountMenuItem) {
		this.accountMenuItem = accountMenuItem;
	}
	
	public void setAccountCommand(Command cmd) {
		this.accountMenuItem.setScheduledCommand(cmd);
	}

	public MenuItem getSchedulesMenuItem() {
		return schedulesMenuItem;
	}

	public void setSchedulesMenuItem(MenuItem schedulesMenuItem) {
		this.schedulesMenuItem = schedulesMenuItem;
	}
	
	public void setSchedulesCommand(Command cmd) {
		this.schedulesMenuItem.setScheduledCommand(cmd);
	}

	public MenuItem getViewScheduleMenuItem() {
		return viewScheduleMenuItem;
	}

	public void setViewScheduleMenuItem(MenuItem viewScheduleMenuItem) {
		this.viewScheduleMenuItem = viewScheduleMenuItem;
	}
	
	public void setViewScheduleCommand(Command cmd) {
		this.viewScheduleMenuItem.setScheduledCommand(cmd);
	}

	public MenuItem getSearchScheduleMenuItem() {
		return searchScheduleMenuItem;
	}

	public void setSearchScheduleMenuItem(MenuItem searchScheduleMenuItem) {
		this.searchScheduleMenuItem = searchScheduleMenuItem;
	}
	
	public void setSearchScheduleCommand(Command cmd) {
		this.searchScheduleMenuItem.setScheduledCommand(cmd);
	}

	public MenuItem getCreateScheduleMenuItem() {
		return createScheduleMenuItem;
	}

	public void setCreateScheduleMenuItem(MenuItem createScheduleMenuItem) {
		this.createScheduleMenuItem = createScheduleMenuItem;
	}
	
	public void setCreateScheduleCommand(Command cmd) {
		this.createScheduleMenuItem.setScheduledCommand(cmd);
	}

	public MenuItem getCoursesMenuItem() {
		return coursesMenuItem;
	}

	public void setCoursesMenuItem(MenuItem coursesMenuItem) {
		this.coursesMenuItem = coursesMenuItem;
	}
	
	public void setCoursesCommand(Command cmd) {
		this.coursesMenuItem.setScheduledCommand(cmd);
	}

	public MenuItem getUsersMenuItem() {
		return usersMenuItem;
	}

	public void setUsersMenuItem(MenuItem usersMenuItem) {
		this.usersMenuItem = usersMenuItem;
	}
	
	public void setUsersCommand(Command cmd) {
		this.usersMenuItem.setScheduledCommand(cmd);
	}
	
	

	public MenuItem getRequestsMenuItem() {
		return requestsMenuItem;
	}

	public void setRequestsMenuItem(MenuItem requestsMenuItem) {
		this.requestsMenuItem = requestsMenuItem;
	}
	
	public void setRequestsCommand(Command cmd) {
		this.requestsMenuItem.setScheduledCommand(cmd);
	}

	public IndexViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));		
	}

	@Override
	public HTMLPanel getMainPanel()
	{
		return mainPanel;
	}

	@Override
	public void setMainPanel(HTMLPanel mainPanel)
	{
		this.mainPanel = mainPanel;
	}

	@Override
	public void setPresenter(IndexPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@Override
	public PopupPanel getGlassLoadingPanel()
	{
		return glassLoadingPanel;
	}
	
	@Override
	public Image getLoadingImage()
	{
		return loadingImage;
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return mainPanel;
	}
}
