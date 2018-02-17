package org.dselent.course_load_scheduler.client.view.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ViewCourseAction;
import org.dselent.course_load_scheduler.client.event.AdminCourseEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;
import org.dselent.course_load_scheduler.client.view.IndexView;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HTMLPanel;

public class CreateModifyCourseViewImpl extends BaseViewImpl<CreateModifyCoursePresenter>
		implements CreateModifyCourseView {

	@UiField
	Button removeSectionBtn;
	@UiField
	Button addSectionBtn;
	@UiField
	Button closeBtn;
	@UiField
	Button submitBtn;
	@UiField
	TextBox courseNameTextBox;
	@UiField
	TextBox courseNumberTextBox;
	@UiField
	TextBox sectionNameTextBox;
	@UiField
	TextBox crnTextBox;
	@UiField
	TextBox typeTextBox;
	@UiField
	TextBox popTextBox;
	@UiField
	TextBox freqTextBox;
	@UiField
	HTMLPanel createModifyPanel;
	@UiField
	CellTable<Section> sectionTable;

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

	interface CreateModifyCourseViewImplUiBinder extends UiBinder<Widget, CreateModifyCourseViewImpl> {
	}

	private static CreateModifyCourseViewImplUiBinder uiBinder = GWT.create(CreateModifyCourseViewImplUiBinder.class);

	@Override
	public void showErrorMessages(String errorMessages) {
		Window.alert(errorMessages);
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return createModifyPanel;
	}

	public TextBox getCourseNameTextBox() {
		return courseNameTextBox;
	}

	public void setCourseNameTextBox(TextBox courseNameTextBox) {
		this.courseNameTextBox = courseNameTextBox;
	}

	public void setCourseNameTextBoxText(String text) {
		this.courseNameTextBox.setText(text);
	}

	public TextBox getCourseNumberTextBox() {
		return courseNumberTextBox;
	}

	public void setCourseNumberTextBox(TextBox courseNumberTextBox) {
		this.courseNumberTextBox = courseNumberTextBox;
	}

	public void setCourseNumberTextBoxText(String text) {
		this.courseNumberTextBox.setText(text);
	}

	public TextBox getSectionNameTextBox() {
		return sectionNameTextBox;
	}

	public void setSectionNameTextBox(TextBox sectionNameTextBox) {
		this.sectionNameTextBox = sectionNameTextBox;
	}
	
	public void setSectionNameTextBoxText(String text) {
		this.sectionNameTextBox.setText(text);
	}

	public TextBox getCrnTextBox() {
		return crnTextBox;
	}

	public void setCrnTextBox(TextBox crnTextBox) {
		this.crnTextBox = crnTextBox;
	}
	
	public void setCrnTextBoxText(String text) {
		this.crnTextBox.setText(text);
	}

	public TextBox getTypeTextBox() {
		return typeTextBox;
	}

	public void setTypeTextBox(TextBox typeTextBox) {
		this.typeTextBox = typeTextBox;
	}
	
	public void setTypeTextBoxText(String text) {
		this.typeTextBox.setText(text);
	}

	public TextBox getPopTextBox() {
		return popTextBox;
	}

	public void setPopTextBox(TextBox popTextBox) {
		this.popTextBox = popTextBox;
	}
	
	public void setPopTextBoxText(String text) {
		this.popTextBox.setText(text);
	}

	public TextBox getFreqTextBox() {
		return freqTextBox;
	}

	public void setFreqTextBox(TextBox freqTextBox) {
		this.freqTextBox = freqTextBox;
	}
	
	public void setFreqTextBoxText(String text) {
		this.freqTextBox.setText(text);
	}

	public CreateModifyCourseViewImpl() {
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

		TextColumn<Section> frequencyColumn = new TextColumn<Section>() {
			@Override
			public String getValue(Section object) {
				return Integer.toString(object.getFrequency());
			}
		};
		sectionTable.addColumn(frequencyColumn, "Frequency");
	}

	@UiHandler("removeSectionBtn")
	void onRemoveSectionBtnClick(ClickEvent event) {
		this.presenter.removeSection();
	}

	@UiHandler("addSectionBtn")
	void onAddSectionBtnClick(ClickEvent event) {
		this.presenter.addSection();
	}

	@UiHandler("closeBtn")
	void onCloseBtnClick(ClickEvent event) {
		this.presenter.createModifyCourseCancel();
	}

	@UiHandler("submitBtn")
	void onSubmitBtnClick(ClickEvent event) {
		this.presenter.createModifyCourseSubmit();
	}

	@Override
	public void setPresenter(CreateModifyCoursePresenter presenter) {
		this.presenter = presenter;
	}

}
