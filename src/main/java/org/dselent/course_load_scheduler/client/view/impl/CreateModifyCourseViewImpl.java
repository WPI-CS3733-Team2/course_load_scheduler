package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.CreateModifyCoursePresenter;
import org.dselent.course_load_scheduler.client.view.CreateModifyCourseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HTMLPanel;

public class CreateModifyCourseViewImpl extends BaseViewImpl<CreateModifyCoursePresenter> implements CreateModifyCourseView {

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
	DataGrid<?> sectionsTable;	
	@UiField
	HTMLPanel createModifyPanel;
	
	interface CreateModifyCourseViewImplUiBinder extends UiBinder<Widget, CreateModifyCourseViewImpl> {
	}
	
	private static CreateModifyCourseViewImplUiBinder uiBinder = GWT.create(CreateModifyCourseViewImplUiBinder.class);
	
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
	public HasWidgets getViewRootPanel()
	{
		return createModifyPanel;
	}
	
	public TextBox getCourseNameTextBox() {
		return courseNameTextBox;
	}

	public void setCourseNameTextBox(TextBox courseNameTextBox) {
		this.courseNameTextBox = courseNameTextBox;
	}

	public TextBox getCourseNumberTextBox() {
		return courseNumberTextBox;
	}

	public void setCourseNumberTextBox(TextBox courseNumberTextBox) {
		this.courseNumberTextBox = courseNumberTextBox;
	}

	public TextBox getSectionNameTextBox() {
		return sectionNameTextBox;
	}

	public void setSectionNameTextBox(TextBox sectionNameTextBox) {
		this.sectionNameTextBox = sectionNameTextBox;
	}

	public TextBox getCrnTextBox() {
		return crnTextBox;
	}

	public void setCrnTextBox(TextBox crnTextBox) {
		this.crnTextBox = crnTextBox;
	}

	public TextBox getTypeTextBox() {
		return typeTextBox;
	}

	public void setTypeTextBox(TextBox typeTextBox) {
		this.typeTextBox = typeTextBox;
	}

	public TextBox getPopTextBox() {
		return popTextBox;
	}

	public void setPopTextBox(TextBox popTextBox) {
		this.popTextBox = popTextBox;
	}

	public TextBox getFreqTextBox() {
		return freqTextBox;
	}

	public void setFreqTextBox(TextBox freqTextBox) {
		this.freqTextBox = freqTextBox;
	}


	public CreateModifyCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("removeSectionBtn")
	void onRemoveSectionBtnClick(ClickEvent event) {
	}
	
	@UiHandler("addSectionBtn")
	void onAddSectionBtnClick(ClickEvent event) {
	}
	
	@UiHandler("closeBtn")
	void onCloseBtnClick(ClickEvent event) {
	}
	
	@UiHandler("submitBtn")
	void onSubmitBtnClick(ClickEvent event) {
	}

	@Override
	public void setPresenter(CreateModifyCoursePresenter presenter) {
		// TODO Auto-generated method stub
		
	}

}
