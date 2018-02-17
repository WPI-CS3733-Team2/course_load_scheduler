package org.dselent.course_load_scheduler.client.view;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionModel;

public interface RequestCourseView extends BaseView<RequestCoursePresenter> {
		
	public Label getCourseNameLabel();
	public void setCourseNameLabel(Label courseNameLabel);
	public void setCourseNameLabelText(String courseName);
	public Label getCourseNumberLabel();
	public void setCourseNumberLabel(Label courseNumberLabel);
	public void setCourseNumberLabelText(String courseNumber);
	public CellTable<Section> getSectionTable();
	public void setSectionTable(CellTable<Section> sectionTable);
	public void addRowsToSectionTable(List<Section> sections);
	public void setSectionTableSelectionModel(SelectionModel<Section> selectionModel);
	public CheckBox getEightToNineCB();
	public void setEightToNineCB(CheckBox eightToNineCB);
	public CheckBox getNineToTenCB();
	public void setNineToTenCB(CheckBox nineToTenCB);
	public CheckBox getTenToElevenCB();
	public void setTenToElevenCB(CheckBox tenToElevenCB);
	public CheckBox getElevenToTwelveCB();
	public void setElevenToTwelveCB(CheckBox elevenToTwelveCB);
	public CheckBox getTwelveToOneCB();
	public void setTwelveToOneCB(CheckBox twelveToOneCB);
	public CheckBox getOneToTwoCB();
	public void setOneToTwoCB(CheckBox oneToTwoCB);
	public CheckBox getTwoToThreeCB();
	public void setTwoToThreeCB(CheckBox twoToThreeCB);
	public CheckBox getThreeToFourCB();
	public void setThreeToFourCB(CheckBox threeToFourCB);
	public CheckBox getFourToFiveCB();
	public void setFourToFiveCB(CheckBox fourToFiveCB);
	public CheckBox getFiveToSixCB();
	public void setFiveToSixCB(CheckBox fiveToSixCB);
	public void uncheckAllCB();
	public void showErrorMessages(String errorMessages);
	public Widget getWidgetContainer();
	public HasWidgets getViewRootPanel();
}
