package org.dselent.course_load_scheduler.client.presenter.impl;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.event.SendAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.event.InvalidAccountDetailsEvent;
import org.dselent.course_load_scheduler.client.event.RequestInboxNavigationEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEvent;
import org.dselent.course_load_scheduler.client.action.CreateScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.FacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.action.InvalidAccountDetailsAction;
import org.dselent.course_load_scheduler.client.action.RequestInboxNavigationAction;
import org.dselent.course_load_scheduler.client.action.SearchScheduleNavigationAction;
import org.dselent.course_load_scheduler.client.action.SendAccountDetailsAction;
import org.dselent.course_load_scheduler.client.action.UserSearchPageAction;
import org.dselent.course_load_scheduler.client.event.UserSearchPageEvent;
import org.dselent.course_load_scheduler.client.event.ViewScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HasWidgets;


public class IndexPresenterImpl extends BasePresenterImpl implements IndexPresenter
{
	private IndexView view;

	@Inject
	public IndexPresenterImpl(IndexView view)
	{
		this.view = view;
		view.setPresenter(this);
		
		view.setAccountCommand(new Command() {
			@Override
			public void execute() {
				// TODO disable all buttons
				showLoadScreen();
				int userId = Injector.INSTANCE.getGlobalData().getUserInfo().getUsersId();
				SendAccountDetailsAction add = new SendAccountDetailsAction(userId);
				SendAccountDetailsEvent ade = new SendAccountDetailsEvent(add, getView().getViewRootPanel());
				eventBus.fireEvent(ade);
			}
		});
		
		view.setViewScheduleCommand(new Command() {
			@Override
			public void execute() {
				HasWidgets container = getView().getViewRootPanel();
				ViewScheduleNavigationAction vsna = new ViewScheduleNavigationAction();
				ViewScheduleNavigationEvent vsne = new ViewScheduleNavigationEvent(vsna, container);
				eventBus.fireEvent(vsne); 
			}
		});
		
		view.setSearchScheduleCommand(new Command() {
			@Override
			public void execute() {	
				SearchScheduleNavigationAction ssna = new SearchScheduleNavigationAction();
				SearchScheduleNavigationEvent ssne = new SearchScheduleNavigationEvent(ssna);
				eventBus.fireEvent(ssne); 
			}
		});
		
		view.setCreateScheduleCommand(new Command() {
			@Override
			public void execute() {	
				HasWidgets container = getView().getViewRootPanel();
				CreateScheduleNavigationAction csna = new CreateScheduleNavigationAction();
				CreateScheduleNavigationEvent csne = new CreateScheduleNavigationEvent(csna, container);
				eventBus.fireEvent(csne); 
				
			}
		});
		
		view.setCoursesCommand(new CustomCommand(view) {
			@Override
			public void execute() {
				final Injector injector = Injector.INSTANCE;
				
				String userRole = injector.getAccountDetailsPresenter().getUserType();
				
				// Used to simulate being an admin
				boolean testing = false;
				HasWidgets container = view.getViewRootPanel();
				
				if (userRole.equals("Admin") || testing) {
					ViewCourseAction vca = new ViewCourseAction();
					AdminCourseEvent ace = new AdminCourseEvent(vca);
					eventBus.fireEvent(ace);
				} 
				else {
					ViewCourseAction vca = new ViewCourseAction();
					FacultyCourseEvent fce = new FacultyCourseEvent(vca, container);
					eventBus.fireEvent(fce);
				}
			}
		});
		
		view.setUsersCommand(new Command() {
			@Override
			public void execute() {	
				UserSearchPageAction uspa = new UserSearchPageAction();
				UserSearchPageEvent uspe = new UserSearchPageEvent(uspa);
				eventBus.fireEvent(uspe);
			}
		});
		
		view.setRequestsCommand(new Command() {
			@Override
			public void execute() {	
				RequestInboxNavigationAction rina = new RequestInboxNavigationAction();
				RequestInboxNavigationEvent rine = new RequestInboxNavigationEvent(rina);
				eventBus.fireEvent(rine);
			}
		});
		
		view.setFacultyCourseCommand(new Command() {
			@Override
			public void execute() {
				showLoadScreen();
				HasWidgets container = getView().getViewRootPanel();
				FacultyCourseNavigationAction fcna = new FacultyCourseNavigationAction();
				FacultyCourseNavigationEvent fcne = new FacultyCourseNavigationEvent(fcna, container);
				eventBus.fireEvent(fcne); 
			}
		});
		

	}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind() {
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidEvent.TYPE, this);
		eventBusRegistration.put(InvalidEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveLoginEvent.TYPE, this);
		eventBusRegistration.put(ReceiveLoginEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public IndexView getView()
	{
		return view;
	}
	
	@Override
	public void showLoadScreen()
	{
		// thank you stackoverflow
		// https://stackoverflow.com/questions/23017908/gwt-set-the-visibility-of-widget-using-css-visibility-property
		view.getLoadingImage().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
		view.getGlassLoadingPanel().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}
	
	@Override
	public void hideLoadScreen()
	{
		view.getLoadingImage().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
		view.getGlassLoadingPanel().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
	
	@Override
	public void showMenuBar()
	{
		view.getNavigationMenu().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}
	
	@Override
	public void hideMenuBar()
	{
		view.getNavigationMenu().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
	
	
	@Override
	public void onInvalidAccountDetails(InvalidAccountDetailsEvent evt)
	{
		hideLoadScreen();

		// TODO ENABLE BUTTONS (currently not disabled anyway)
		
		InvalidAccountDetailsAction iada = evt.getAction();
		view.showErrorMessages(iada.toString());
	}
	
	private class CustomCommand implements Command {

		IndexView view;
		
		public CustomCommand(IndexView view) {
			this.view = view;
		}
		
		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//Generic error messages for a response failure.
	@Override
	public void onInvalid(InvalidEvent evt) {
		view.showErrorMessages("Action could not be completed.");
	}
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt) {
		ReceiveLoginAction rla = evt.getAction();

		UserInfo userInfo = rla.getUserInfo();//Injector.INSTANCE.getGlobalData().getUserInfo();
		
		if(userInfo.getUserRolesId() == 2) {
			view.getUsersMenuItem().setVisible(false);
			view.getUsersMenuItem().setEnabled(false);
		}
	}
}