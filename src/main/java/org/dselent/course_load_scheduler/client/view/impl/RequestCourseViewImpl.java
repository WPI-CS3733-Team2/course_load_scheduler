package org.dselent.course_load_scheduler.client.view.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;
import org.dselent.course_load_scheduler.client.view.RequestCourseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;

public class RequestCourseViewImpl extends BaseViewImpl<RequestCoursePresenter> implements RequestCourseView {

	private static RequestCourseViewImplUiBinder uiBinder = GWT.create(RequestCourseViewImplUiBinder.class);
	@UiField(provided=true) CellTable<Section> sectionTable = new CellTable<Section>();
	@UiField Button submitBtn;
	@UiField HTMLPanel requestCoursePanel;
	@UiField CheckBox eightToNineCB;
	@UiField CheckBox nineToTenCB;
	@UiField CheckBox tenToElevenCB;
	@UiField CheckBox elevenToTwelveCB;
	@UiField CheckBox twelveToOneCB;
	@UiField CheckBox oneToTwoCB;
	@UiField CheckBox twoToThreeCB;
	@UiField CheckBox threeToFourCB;
	@UiField CheckBox fourToFiveCB;
	@UiField CheckBox fiveToSixCB;
	@UiField Button cancelBtn;
	@UiField Label courseNameLabel;
	
	public Label getCourseNameLabel() {
		return courseNameLabel;
	}

	public void setCourseNameLabel(Label courseNameLabel) {
		this.courseNameLabel = courseNameLabel;
	}
	
	public void setCourseNameLabelText(String courseName) {
		this.courseNameLabel.setText(courseName);
	}

	public Label getCourseNumberLabel() {
		return courseNumberLabel;
	}

	public void setCourseNumberLabel(Label courseNumberLabel) {
		this.courseNumberLabel = courseNumberLabel;
	}
	
	public void setCourseNumberLabelText(String courseNumber) {
		this.courseNumberLabel.setText(courseNumber);
	}

	@UiField Label courseNumberLabel;
	
	public CellTable<Section> getSectionTable() {
		return sectionTable;
	}

	public void setSectionTable(CellTable<Section> sectionTable) {
		this.sectionTable = sectionTable;
	}
	
	public void addRowsToSectionTable(List<Section> sections) {
		int rowCount = sectionTable.getRowCount();
		sectionTable.setRowCount(rowCount + sections.size(), true);
		sectionTable.setRowData(rowCount, sections);
	}

	public void setSectionTableSelectionModel(SelectionModel<Section> selectionModel) {
		sectionTable.setSelectionModel(selectionModel);
	}
	
	public CheckBox getEightToNineCB() {
		return eightToNineCB;
	}

	public void setEightToNineCB(CheckBox eightToNineCB) {
		this.eightToNineCB = eightToNineCB;
	}

	public CheckBox getNineToTenCB() {
		return nineToTenCB;
	}

	public void setNineToTenCB(CheckBox nineToTenCB) {
		this.nineToTenCB = nineToTenCB;
	}

	public CheckBox getTenToElevenCB() {
		return tenToElevenCB;
	}

	public void setTenToElevenCB(CheckBox tenToElevenCB) {
		this.tenToElevenCB = tenToElevenCB;
	}

	public CheckBox getElevenToTwelveCB() {
		return elevenToTwelveCB;
	}

	public void setElevenToTwelveCB(CheckBox elevenToTwelveCB) {
		this.elevenToTwelveCB = elevenToTwelveCB;
	}

	public CheckBox getTwelveToOneCB() {
		return twelveToOneCB;
	}

	public void setTwelveToOneCB(CheckBox twelveToOneCB) {
		this.twelveToOneCB = twelveToOneCB;
	}

	public CheckBox getOneToTwoCB() {
		return oneToTwoCB;
	}

	public void setOneToTwoCB(CheckBox oneToTwoCB) {
		this.oneToTwoCB = oneToTwoCB;
	}

	public CheckBox getTwoToThreeCB() {
		return twoToThreeCB;
	}

	public void setTwoToThreeCB(CheckBox twoToThreeCB) {
		this.twoToThreeCB = twoToThreeCB;
	}

	public CheckBox getThreeToFourCB() {
		return threeToFourCB;
	}

	public void setThreeToFourCB(CheckBox threeToFourCB) {
		this.threeToFourCB = threeToFourCB;
	}

	public CheckBox getFourToFiveCB() {
		return fourToFiveCB;
	}

	public void setFourToFiveCB(CheckBox fourToFiveCB) {
		this.fourToFiveCB = fourToFiveCB;
	}

	public CheckBox getFiveToSixCB() {
		return fiveToSixCB;
	}

	public void setFiveToSixCB(CheckBox fiveToSixCB) {
		this.fiveToSixCB = fiveToSixCB;
	}
	
	public void uncheckAllCB() {
		eightToNineCB.setValue(false);
		nineToTenCB.setValue(false);
		tenToElevenCB.setValue(false);
		elevenToTwelveCB.setValue(false);
		twelveToOneCB.setValue(false);
		oneToTwoCB.setValue(false);
		twoToThreeCB.setValue(false);
		threeToFourCB.setValue(false);
		fourToFiveCB.setValue(false);
		fiveToSixCB.setValue(false);
	}

	RequestCoursePresenter presenter;

	interface RequestCourseViewImplUiBinder extends UiBinder<Widget, RequestCourseViewImpl> {
	}

	public RequestCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		sectionTable.setRowCount(0);
		TextColumn<Section> nameColumn = new TextColumn<Section>() {
			@Override
			public String getValue(Section object) {
				return object.getSectionName();
			}
		};
		sectionTable.addColumn(nameColumn, "Name");

		TextColumn<Section> crnColumn = new TextColumn<Section>() {
			@Override
			public String getValue(Section object) {
				return Integer.toString(object.getCrn());
			}
		};
		sectionTable.addColumn(crnColumn, "CRN");

		TextColumn<Section> typeColumn = new TextColumn<Section>() {
			@Override
			public String getValue(Section object) {
				return object.getType();
			}
		};
		sectionTable.addColumn(typeColumn, "Type");

		TextColumn<Section> populationColumn = new TextColumn<Section>() {
			@Override
			public String getValue(Section object) {
				return Integer.toString(object.getExpectedPopulation());
			}
		};
		sectionTable.addColumn(populationColumn, "Population");
		sectionTable.setWidth("500px");
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}

	@Override
	public void setPresenter(RequestCoursePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return requestCoursePanel;
	}
	
	@UiHandler("submitBtn")
	void onSubmitBtnClick(ClickEvent event) {
		this.presenter.requestCourseSubmit();
	}
	
	@UiHandler("cancelBtn")
	void onCancelBtnClick(ClickEvent event) {
		this.presenter.requestCourseCancel();
	}
	
}
