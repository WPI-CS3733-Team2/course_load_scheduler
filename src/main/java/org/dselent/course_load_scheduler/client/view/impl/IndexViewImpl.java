package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
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
	MenuItem coursesMenuItem;
	@UiField
	MenuItem usersMenuItem;
	@UiField
	MenuItem requestsMenuItem;
	@UiField 
	MenuBar navigationMenu;
	
	public IndexViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
		
		accountMenuItem.setScheduledCommand(new Command() {
			@Override
			public void execute() {	
			}
		});
		
		schedulesMenuItem.setScheduledCommand(new Command() {
			@Override
			public void execute() {	
			}
		});
		
		coursesMenuItem.setScheduledCommand(new Command() {
			@Override
			public void execute() {
				final Injector injector = Injector.INSTANCE;
				
				IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
				IndexView indexView = indexPresenter.getView();		

				boolean faculty = true;
				
				BasePresenter coursePresenter;
				
				if(faculty) {
					coursePresenter = injector.getFacultyCoursePresenter();
				}
				else {
					coursePresenter = injector.getAdminCoursePresenter();
				}
				
				coursePresenter.go(indexView.getViewRootPanel());
				
			}
		});
		
		usersMenuItem.setScheduledCommand(new Command() {
			@Override
			public void execute() {	
			}
		});
		
		requestsMenuItem.setScheduledCommand(new Command() {
			@Override
			public void execute() {	
			}
		});
		
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
	
	/*@UiHandler("accountMenuItem")
	void onAccountMenuItemClick(ClickEvent event) {

	}
	
	@UiHandler("schedulesMenuItem")
	void onSchedulesMenuItemClick(ClickEvent event) {
		
	}
	
	@UiHandler("coursesMenuItem")
	void onCoursesMenuItemClick(ClickEvent event) {
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();		

		boolean faculty = true;
		
		BasePresenter coursePresenter;
		
		if(faculty) {
			coursePresenter = injector.getFacultyCoursePresenter();
		}
		else {
			coursePresenter = injector.getAdminCoursePresenter();
		}
		
		coursePresenter.go(indexView.getViewRootPanel());
	}
	
	@UiHandler("requestsMenuItem")
	void onRequestsMenuItemClick(ClickEvent event) {
		
	}*/

}
