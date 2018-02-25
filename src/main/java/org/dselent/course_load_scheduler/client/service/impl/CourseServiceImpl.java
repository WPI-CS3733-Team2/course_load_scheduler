package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.AddSectionsAction;
import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.callback.AddCourseCallback;
import org.dselent.course_load_scheduler.client.callback.AddSectionsCallback;
import org.dselent.course_load_scheduler.client.callback.ViewAdminCourseCallback;
import org.dselent.course_load_scheduler.client.callback.ViewAdminSectionCallback;
import org.dselent.course_load_scheduler.client.callback.ViewFacultyCourseCallback;
import org.dselent.course_load_scheduler.client.callback.ViewFacultySectionCallback;
import org.dselent.course_load_scheduler.client.event.AddCourseEvent;
import org.dselent.course_load_scheduler.client.event.AddSectionsEvent;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.event.AdminSectionEvent;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.CourseService;
import org.dselent.course_load_scheduler.client.translator.impl.AddCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.AddSectionsTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CourseTranslatorImpl;
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
		
		registration = eventBus.addHandler(AdminCourseEvent.TYPE, this);
		eventBusRegistration.put(AdminCourseEvent.TYPE, registration);

		registration = eventBus.addHandler(AdminSectionEvent.TYPE, this);
		eventBusRegistration.put(AdminSectionEvent.TYPE, registration);
		
		registration = eventBus.addHandler(AddCourseEvent.TYPE, this);
		eventBusRegistration.put(AddCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(AddSectionsEvent.TYPE, this);
		eventBusRegistration.put(AddSectionsEvent.TYPE, registration);
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
}
