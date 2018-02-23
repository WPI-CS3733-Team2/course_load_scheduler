package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.FacultyCourseNavigationAction;
import org.dselent.course_load_scheduler.client.callback.FacultyCourseNavigationCallback;
import org.dselent.course_load_scheduler.client.callback.SendLoginCallback;
import org.dselent.course_load_scheduler.client.event.FacultyCourseNavigationEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.FacultyCourseMappingService;
import org.dselent.course_load_scheduler.client.translator.impl.FacultyCourseNavigationActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.LoginActionTranslatorImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class FacultyCourseMappingServiceImpl extends BaseServiceImpl implements FacultyCourseMappingService
{
	public FacultyCourseMappingServiceImpl()
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
		registration = eventBus.addHandler(FacultyCourseNavigationEvent.TYPE, this);
		eventBusRegistration.put(FacultyCourseNavigationEvent.TYPE, registration);
	}
	
	@Override
	public void onFacultyCourseNavigation(FacultyCourseNavigationEvent evt) {
		FacultyCourseNavigationAction action = evt.getAction();
		FacultyCourseNavigationActionTranslatorImpl facultyCourseNavigationActionTranslator = new FacultyCourseNavigationActionTranslatorImpl();
		JSONObject json = facultyCourseNavigationActionTranslator.translateToJson(action);
		FacultyCourseNavigationCallback facultyCourseNavigationCallback = new FacultyCourseNavigationCallback(eventBus, evt.getContainer());
	
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.FACULTY_COURSE_MAP, facultyCourseNavigationCallback, json);
		request.send();
	}
}
