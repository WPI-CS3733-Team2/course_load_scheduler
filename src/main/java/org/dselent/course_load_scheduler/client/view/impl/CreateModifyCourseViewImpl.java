package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.gin.Injector;
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
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.FlowPanel;

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
	FlowPanel sectionsGridPanel;

	public FlowPanel getSectionsGridPanel() {
		return sectionsGridPanel;
	}

	public void setSectionsGridPanel(FlowPanel sectionsGridPanel) {
		this.sectionsGridPanel = sectionsGridPanel;
	}
	
	public void addTableToSectionsGridPanel(CellTable<Section> ct) {
		sectionsGridPanel.add(ct);
	}
	
	public void clearSectionsGridPanel() {
		sectionsGridPanel.clear();
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
		this.crnTextBox.setText(text);
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
		this.presenter.clearForm();

		final Injector injector = Injector.INSTANCE;

		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();

		AdminCoursePresenterImpl adminCoursePresenter = injector.getAdminCoursePresenter();

		adminCoursePresenter.go(indexView.getViewRootPanel());
	}

	@UiHandler("submitBtn")
	void onSubmitBtnClick(ClickEvent event) {
		this.presenter.clearForm();
		
		final Injector injector = Injector.INSTANCE;

		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();

		AdminCoursePresenterImpl adminCoursePresenter = injector.getAdminCoursePresenter();

		adminCoursePresenter.go(indexView.getViewRootPanel());
	}

	@Override
	public void setPresenter(CreateModifyCoursePresenter presenter) {
		this.presenter = presenter;
	}

}
