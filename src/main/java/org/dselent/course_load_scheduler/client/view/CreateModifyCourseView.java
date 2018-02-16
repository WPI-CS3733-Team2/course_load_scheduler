package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;

public interface CreateModifyCourseView extends BaseView<CreateModifyCoursePresenter> {
	
	public FlowPanel getSectionsGridPanel();

	public void setSectionsGridPanel(FlowPanel sectionsGridPanel);
	
	public void addTableToSectionsGridPanel(CellTable<Section> ct);
	
	public void clearSectionsGridPanel();
	
	public TextBox getCourseNameTextBox();

	public void setCourseNameTextBox(TextBox courseNameTextBox);
	
	public void setCourseNameTextBoxText(String text);

	public TextBox getCourseNumberTextBox();

	public void setCourseNumberTextBox(TextBox courseNumberTextBox);

	public void setCourseNumberTextBoxText(String text);
	
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
	
	public TextBox getFreqTextBox();
	
	public void setFreqTextBox(TextBox freqTextBox);
	
	public void setFreqTextBoxText(String text);
	
	public void showErrorMessages(String errorMessages);

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();
	
}
