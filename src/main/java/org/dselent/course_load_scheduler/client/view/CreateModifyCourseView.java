package org.dselent.course_load_scheduler.client.view;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.user.client.ui.TextBox;

public interface CreateModifyCourseView extends BaseView<CreateModifyCoursePresenter> {
	
	public CellTable<Section> getSectionTable();

	public void setSectionTable(CellTable<Section> sectionTable);
	
	public void addRowsToSectionTable(List<Section> sections);
	
	public void setSectionTableSelectionModel(SelectionModel<Section> selectionModel);
		
	public TextBox getCourseNameTextBox();

	public void setCourseNameTextBox(TextBox courseNameTextBox);
	
	public void setCourseNameTextBoxText(String text);

	public TextBox getCourseNumberTextBox();

	public void setCourseNumberTextBox(TextBox courseNumberTextBox);

	public void setCourseNumberTextBoxText(String text);
	
	public TextBox getFrequencyTextBox();

	public void setFrequencyTextBox(TextBox frequencyTextBox);

	public void setFrequencyTextBoxText(String text);
	
	public TextBox getSectionNameTextBox();

	public void setSectionNameTextBox(TextBox sectionNameTextBox);
	
	public void setSectionNameTextBoxText(String text);

	public TextBox getCrnTextBox();

	public void setCrnTextBox(TextBox crnTextBox);

	public void setCrnTextBoxText(String text);
	
	public TextBox getTypeTextBox();

	public void setTypeTextBox(TextBox typeTextBox);

	public void setTypeTextBoxText(String text);
	
	public TextBox getPopTextBox();

	public void setPopTextBox(TextBox popTextBox);

	public void setPopTextBoxText(String text);
	
	public TextBox getYearTextBox();

	public void setYearTextBoxText(String text);

	public TextBox getTermTextBox();

	public void setTermTextBoxText(String text);

	public TextBox getStartTimeTextBox();

	public void setStartTimeTextBoxText(String text);

	public TextBox getEndTimeTextBox();

	public void setEndTimeTextBoxText(String text);

	public TextBox getDaysTextBox();

	public void setDaysTextBoxText(String text);

	
	public void showErrorMessages(String errorMessages);

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();
	
}
