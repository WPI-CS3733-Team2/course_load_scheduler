package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SearchScheduleAction;
import org.dselent.course_load_scheduler.client.event.SearchScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SearchScheduleNavigationEvent;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class SearchSchedulePresenterImpl extends BasePresenterImpl implements SearchSchedulePresenter
{
	private IndexPresenter parentPresenter;
	private SearchScheduleView view;

	@Inject
	public SearchSchedulePresenterImpl(IndexPresenter parentPresenter, SearchScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
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
		registration = eventBus.addHandler(SearchScheduleNavigationEvent.TYPE, this);
		eventBusRegistration.put(SearchScheduleNavigationEvent.TYPE, registration);
		
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public SearchScheduleView getView()
	{
		return view;
	}
	
	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	public void results() {
		final String queryTerm = view.getSearchBar().getText().trim();
		String searchBy = "";
		if (view.getByFaculty().getValue()) {
			searchBy = "faculty";
		}
		else if (view.getByCourse().getValue()){
			searchBy = "course";
		}
		else if (view.getBySemester().getValue()) {
			searchBy = "semester";
		}
		else if (view.getByScheduleName().getValue()) {
			searchBy = "name";
		}
	      
		SearchScheduleAction ssa = new SearchScheduleAction(queryTerm, searchBy);
		SearchScheduleEvent sse = new SearchScheduleEvent(ssa);
		eventBus.fireEvent(sse);
	}
	
	@Override
	public void onSearchScheduleNavigation(SearchScheduleNavigationEvent evt) {
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
}
