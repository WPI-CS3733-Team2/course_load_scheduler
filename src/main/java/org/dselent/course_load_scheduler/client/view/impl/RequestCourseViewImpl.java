package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.RequestCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.FacultyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.RequestCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.RequestCourseView;

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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

public class RequestCourseViewImpl extends BaseViewImpl<RequestCoursePresenter> implements RequestCourseView {

	private static RequestCourseViewImplUiBinder uiBinder = GWT.create(RequestCourseViewImplUiBinder.class);
	@UiField(provided=true) CellTable<Object> sectionTable = new CellTable<Object>();
	@UiField Button submitBtn;
	@UiField HTMLPanel requestCoursePanel;
	@UiField SimpleCheckBox termCheckBox;
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
	@UiField Grid checkBoxGrid;
	@UiField Label courseNameLabel;
	@UiField Label courseNumberLabel;
	
	public CellTable<Object> getSectionTable() {
		return sectionTable;
	}

	public void setSectionTable(CellTable<Object> sectionTable) {
		this.sectionTable = sectionTable;
	}
	
	public SimpleCheckBox getTermCheckBox() {
		return termCheckBox;
	}

	public void setTermCheckBox(SimpleCheckBox termCheckBox) {
		this.termCheckBox = termCheckBox;
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

	RequestCoursePresenter presenter;

	interface RequestCourseViewImplUiBinder extends UiBinder<Widget, RequestCourseViewImpl> {
	}

	public RequestCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
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
		returnToFacultyCourseView();
	}
	
	@UiHandler("cancelBtn")
	void onCancelBtnClick(ClickEvent event) {
		returnToFacultyCourseView();
	}
	
	public void returnToFacultyCourseView() {
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();		

		FacultyCoursePresenterImpl facultyCoursePresenter = injector.getFacultyCoursePresenter();
		
		facultyCoursePresenter.go(indexView.getViewRootPanel());
	}
}
