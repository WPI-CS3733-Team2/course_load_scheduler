package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.model.FacultyCourse;
import org.dselent.course_load_scheduler.client.presenter.FacultyCourseMappingPresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseMappingView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FacultyCourseMappingViewImpl extends BaseViewImpl<FacultyCourseMappingPresenter> implements FacultyCourseMappingView {
//public class FacultyCourseMappingViewImpl extends Composite {

	private static FacultyCourseMappingImplUiBinder uiBinder = GWT.create(FacultyCourseMappingImplUiBinder.class);

	interface FacultyCourseMappingImplUiBinder extends UiBinder<Widget, FacultyCourseMappingViewImpl> {
	}

	public FacultyCourseMappingViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initColumns();
	}
	
	@UiField
	Label facultyListLabel;
	
	@UiField
	CellTable facultyCellTable;
	
	@UiField
	VerticalPanel verticalPanel;
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}

	public Label getFacultyListLabel() {
		return facultyListLabel;
	}

	public void setFacultyListLabel(Label facultyListLabel) {
		this.facultyListLabel = facultyListLabel;
	}

	public CellTable getFacultyCellTable() {
		return facultyCellTable;
	}

	public void setFacultyCellTable(CellTable facultyCellTable) {
		this.facultyCellTable = facultyCellTable;
	}
	
	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}

	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}

	@Override
	public HasWidgets getViewRootPanel()
	{
		return verticalPanel;
	}

	
	@Override
	public void setPresenter(FacultyCourseMappingPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	public void initColumns() {
		TextColumn<FacultyCourse> firstNameColumn = new TextColumn<FacultyCourse>() {
			@Override
			public String getValue(FacultyCourse faculty) {
				return faculty.getFirstName();
			}
		};
		//firstNameColumn.setSortable(true);
		this.facultyCellTable.addColumn(firstNameColumn, "First Name");
		
		TextColumn<FacultyCourse> lastNameColumn = new TextColumn<FacultyCourse>() {
			@Override
			public String getValue(FacultyCourse faculty) {
				return faculty.getLastName();
			}
		};
		//lastNameColumn.setSortable(true);
		this.facultyCellTable.addColumn(lastNameColumn, "Last Name");
		
		TextColumn<FacultyCourse> coursesColumn = new TextColumn<FacultyCourse>() {
			@Override
			public String getValue(FacultyCourse faculty) {
				return faculty.makePresenterString();
			}
		};
		//firstNameColumn.setSortable(true);
		this.facultyCellTable.addColumn(coursesColumn, "Assigned Courses");
		
	}

}
