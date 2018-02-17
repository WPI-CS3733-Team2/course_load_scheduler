package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.SearchSchedulePresenter;
import org.dselent.course_load_scheduler.client.view.SearchScheduleView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RadioButton;

//public class SearchScheduleViewImpl extends Composite {
public class SearchScheduleViewImpl extends BaseViewImpl<SearchSchedulePresenter> implements SearchScheduleView {

	private static SearchScheduleImplUiBinder uiBinder = GWT.create(SearchScheduleImplUiBinder.class);
	@UiField TextBox searchBar;
	@UiField RadioButton byFaculty;
	@UiField RadioButton byCourse;
	@UiField RadioButton bySemester;
	@UiField RadioButton byScheduleName;
	@UiField VerticalPanel verticalPanel;

	interface SearchScheduleImplUiBinder extends UiBinder<Widget, SearchScheduleViewImpl> {
	}

	public SearchScheduleViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		searchBar.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	            if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	              presenter.results();
	            }
	          }
	        });
	}
	
	public RadioButton getBySemester() {
		return bySemester;
	}

	public void setBySemester(RadioButton bySemester) {
		this.bySemester = bySemester;
	}


	public RadioButton getByScheduleName() {
		return byScheduleName;
	}

	public void setByScheduleName(RadioButton byScheduleName) {
		this.byScheduleName = byScheduleName;
	}

	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}

	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}


	public TextBox getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(TextBox searchBar) {
		this.searchBar = searchBar;
	}

	public RadioButton getByFaculty() {
		return byFaculty;
	}

	public void setByFaculty(RadioButton byFaculty) {
		this.byFaculty = byFaculty;
	}

	public RadioButton getByCourse() {
		return byCourse;
	}

	public void setByCourse(RadioButton byCourse) {
		this.byCourse = byCourse;
	}

	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return verticalPanel;
	}

	
	@Override
	public void setPresenter(SearchSchedulePresenter presenter)
	{
		this.presenter = presenter;
	}
	
}
