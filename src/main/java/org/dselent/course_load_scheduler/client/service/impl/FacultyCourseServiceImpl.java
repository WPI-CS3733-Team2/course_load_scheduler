package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.action.ViewSectionAction;
import org.dselent.course_load_scheduler.client.callback.ViewCourseCallback;
import org.dselent.course_load_scheduler.client.callback.ViewSectionCallback;
import org.dselent.course_load_scheduler.client.event.FacultyCourseEvent;
import org.dselent.course_load_scheduler.client.event.FacultySectionEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.FacultyCourseService;
import org.dselent.course_load_scheduler.client.translator.impl.FacultyCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.FacultySectionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class FacultyCourseServiceImpl extends BaseServiceImpl implements FacultyCourseService
{
	public FacultyCourseServiceImpl()
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
	}
	
	@Override
	public void onFacultyCourse(FacultyCourseEvent evt)
	{
		ViewCourseAction action = evt.getAction();
		FacultyCourseTranslatorImpl facultyCourseTranslator = new FacultyCourseTranslatorImpl();
		JSONObject json = facultyCourseTranslator.translateToJson(action);
		ViewCourseCallback courseCallback = new ViewCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_COURSES, courseCallback, json);
		request.send();
	}

	@Override
	public void onFacultySection(FacultySectionEvent evt)
	{
		ViewSectionAction action = evt.getAction();
		FacultySectionTranslatorImpl facultyCourseTranslator = new FacultySectionTranslatorImpl();
		JSONObject json = facultyCourseTranslator.translateToJson(action);
		ViewSectionCallback courseCallback = new ViewSectionCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.VIEW_SECTIONS, courseCallback, json);
		request.send();
	}
}
