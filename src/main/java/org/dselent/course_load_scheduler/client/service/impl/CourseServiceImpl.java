package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.AddSectionsAction;
import org.dselent.course_load_scheduler.client.action.ModifyCourseAction;
import org.dselent.course_load_scheduler.client.action.RemoveSectionsAction;
import org.dselent.course_load_scheduler.client.action.ViewCalendarAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.callback.AddCourseCallback;
import org.dselent.course_load_scheduler.client.callback.AddSectionsCallback;
import org.dselent.course_load_scheduler.client.callback.ModifyCourseCallback;
import org.dselent.course_load_scheduler.client.callback.RemoveSectionsCallback;
import org.dselent.course_load_scheduler.client.callback.ViewAdminCalendarCallback;
import org.dselent.course_load_scheduler.client.callback.ViewAdminCourseCallback;
import org.dselent.course_load_scheduler.client.callback.ViewAdminSectionCallback;
import org.dselent.course_load_scheduler.client.callback.ViewFacultyCalendarCallback;
import org.dselent.course_load_scheduler.client.callback.ViewFacultyCourseCallback;
import org.dselent.course_load_scheduler.client.callback.ViewFacultySectionCallback;
import org.dselent.course_load_scheduler.client.event.AddCourseEvent;
import org.dselent.course_load_scheduler.client.event.AddSectionsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCalendarEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.AdminSectionEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCalendarEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.event.ModifyCourseEvent;
import org.dselent.course_load_scheduler.client.event.RemoveSectionsEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.CourseService;
import org.dselent.course_load_scheduler.client.translator.impl.AddCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.AddSectionsTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CalendarTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.ModifyCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.RemoveSectionsTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SectionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class CourseServiceImpl extends BaseServiceImpl implements CourseService
{
	public CourseServiceImpl()
	{
		
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(FacultyCourseEvent.TYPE, this);
		eventBusRegistration.put(FacultyCourseEvent.TYPE, registration);

		registration = eventBus.addHandler(FacultySectionEvent.TYPE, this);
		eventBusRegistration.put(FacultySectionEvent.TYPE, registration);
		
		registration = eventBus.addHandler(FacultyCalendarEvent.TYPE, this);
		eventBusRegistration.put(FacultyCalendarEvent.TYPE, registration);
		
		registration = eventBus.addHandler(AdminCourseEvent.TYPE, this);
		eventBusRegistration.put(AdminCourseEvent.TYPE, registration);

		registration = eventBus.addHandler(AdminSectionEvent.TYPE, this);
		eventBusRegistration.put(AdminSectionEvent.TYPE, registration);

		registration = eventBus.addHandler(AdminCalendarEvent.TYPE, this);
		eventBusRegistration.put(AdminCalendarEvent.TYPE, registration);
		
		registration = eventBus.addHandler(AddCourseEvent.TYPE, this);
		eventBusRegistration.put(AddCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(AddSectionsEvent.TYPE, this);
		eventBusRegistration.put(AddSectionsEvent.TYPE, registration);
		
		registration = eventBus.addHandler(RemoveSectionsEvent.TYPE, this);
		eventBusRegistration.put(RemoveSectionsEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ModifyCourseEvent.TYPE, this);
		eventBusRegistration.put(ModifyCourseEvent.TYPE, registration);
	}
	
	@Override
	public void onFacultyCourse(FacultyCourseEvent evt)
	{
		ViewCourseAction action = evt.getAction();
		CourseTranslatorImpl facultyCourseTranslator = new CourseTranslatorImpl();
		JSONObject json = facultyCourseTranslator.translateToJson(action);
		ViewFacultyCourseCallback courseCallback = new ViewFacultyCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_COURSES, courseCallback, json);
		request.send();
	}

	@Override
	public void onFacultySection(FacultySectionEvent evt)
	{
		ViewSectionAction action = evt.getAction();
		SectionTranslatorImpl facultyCourseTranslator = new SectionTranslatorImpl();
		JSONObject json = facultyCourseTranslator.translateToJson(action);
		ViewFacultySectionCallback courseCallback = new ViewFacultySectionCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_SECTIONS, courseCallback, json);
		request.send();
	}
	
	@Override
	public void onFacultyCalendar(FacultyCalendarEvent evt)
	{
		ViewCalendarAction action = evt.getAction();
		CalendarTranslatorImpl calendarTranslator = new CalendarTranslatorImpl();
		JSONObject json = calendarTranslator.translateToJson(action);
		ViewFacultyCalendarCallback calendarCallback = new ViewFacultyCalendarCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_CALENDARS, calendarCallback, json);
		request.send();
	}
	
	@Override
	public void onAdminCourse(AdminCourseEvent evt)
	{
		ViewCourseAction action = evt.getAction();
		CourseTranslatorImpl courseTranslator = new CourseTranslatorImpl();
		JSONObject json = courseTranslator.translateToJson(action);
		ViewAdminCourseCallback courseCallback = new ViewAdminCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_COURSES, courseCallback, json);
		request.send();
	}

	@Override
	public void onAdminSection(AdminSectionEvent evt)
	{
		ViewSectionAction action = evt.getAction();
		SectionTranslatorImpl sectionTranslator = new SectionTranslatorImpl();
		JSONObject json = sectionTranslator.translateToJson(action);
		ViewAdminSectionCallback courseCallback = new ViewAdminSectionCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_SECTIONS, courseCallback, json);
		request.send();
	}
	
	@Override
	public void onAdminCalendar(AdminCalendarEvent evt)
	{
		ViewCalendarAction action = evt.getAction();
		CalendarTranslatorImpl calendarTranslator = new CalendarTranslatorImpl();
		JSONObject json = calendarTranslator.translateToJson(action);
		ViewAdminCalendarCallback calendarCallback = new ViewAdminCalendarCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_CALENDARS, calendarCallback, json);
		request.send();
	}
	
	@Override
	public void onAddCourse(AddCourseEvent evt) {
		AddCourseAction action = evt.getAction();
		AddCourseTranslatorImpl addCourseTranslator = new AddCourseTranslatorImpl();
		JSONObject json = addCourseTranslator.translateToJson(action);
		AddCourseCallback addCourseCallback = new AddCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.ADD_COURSE, addCourseCallback, json);
		request.send();
	}
	
	@Override
	public void onAddSections(AddSectionsEvent evt) {
		AddSectionsAction action = evt.getAction();
		AddSectionsTranslatorImpl addSectionsTranslator = new AddSectionsTranslatorImpl();
		JSONObject json = addSectionsTranslator.translateToJson(action);
		AddSectionsCallback addSectionsCallback = new AddSectionsCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.ADD_SECTIONS, addSectionsCallback, json);
		request.send();
	}
	
	@Override
	public void onRemoveSections(RemoveSectionsEvent evt) {
		RemoveSectionsAction action = evt.getAction();
		RemoveSectionsTranslatorImpl removeSectionsTranslator = new RemoveSectionsTranslatorImpl();
		JSONObject json = removeSectionsTranslator.translateToJson(action);
		RemoveSectionsCallback addSectionsCallback = new RemoveSectionsCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.REMOVE_SECTIONS, addSectionsCallback, json);
		request.send();
	}
	
	@Override
	public void onModifyCourse(ModifyCourseEvent evt) {
		ModifyCourseAction action = evt.getAction();
		ModifyCourseTranslatorImpl ModifyCourseTranslator = new ModifyCourseTranslatorImpl();
		JSONObject json = ModifyCourseTranslator.translateToJson(action);
		ModifyCourseCallback addSectionsCallback = new ModifyCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.MODIFY_COURSE, addSectionsCallback, json);
		request.send();
	}
}
