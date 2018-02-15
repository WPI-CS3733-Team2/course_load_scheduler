package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.TerminateAccountEvent;
import org.dselent.course_load_scheduler.client.event.NavigateEvent;
import org.dselent.course_load_scheduler.client.event.SearchUserEvent;
import org.dselent.course_load_scheduler.client.event.CreateUserEvent;
import org.dselent.course_load_scheduler.client.event.CreateScheduleEvent;

/**
 * Adapter class for convenience
 * All classes that need to implement an event handler can extend from this class
 * This allows for presenters or other classes not to implement a large number of handler interfaces
 * Need to register all event handling functions with this class by implementing the handler and
 * overriding with an empty method
 * 
 * @author dselent
 * 
 */
public abstract class EventHandlerAdapter
implements InvalidLoginEventHandler, SendLoginEventHandler, NavigateEventHandler, SearchUserEventHandler, 
	CreateUserEventHandler, TerminateAccountEventHandler, CreateScheduleEventHandler
{
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {}
	
	@Override
	public void onSendLogin(SendLoginEvent evt) {}
	
	@Override
	public void onNavigate(NavigateEvent evt) {}
	
	@Override
	public void onSearchUser(SearchUserEvent evt) {}
	
	@Override
	public void onCreateUser(CreateUserEvent evt) {}
	
	@Override
	public void onTerminateAccount(TerminateAccountEvent evt) {}
	
	@Override
	public void onCreateSchedule(CreateScheduleEvent evt) {}
}
