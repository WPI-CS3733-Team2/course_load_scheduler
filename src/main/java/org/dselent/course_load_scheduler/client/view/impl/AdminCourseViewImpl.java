package org.dselent.course_load_scheduler.client.view.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Section;
import org.dselent.course_load_scheduler.client.presenter.AdminCoursePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.CreateModifyCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.view.AdminCourseView;
import org.dselent.course_load_scheduler.client.view.IndexView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

public class AdminCourseViewImpl extends BaseViewImpl<AdminCoursePresenter> implements AdminCourseView {

	private static AdminCourseViewImplUiBinder uiBinder = GWT.create(AdminCourseViewImplUiBinder.class);
	@UiField
	Button addCourseBtn;
	@UiField
	TextBox searchCourseTxtBox;
	@UiField
	HTMLPanel adminCoursePanel;
	@UiField
	Grid allCoursesGrid;

	AdminCoursePresenter presenter;

	public TextBox getSearchCourseTxtBox() {
		return searchCourseTxtBox;
	}

	public void setSearchCourseTxtBox(TextBox searchCourseTxtBox) {
		this.searchCourseTxtBox = searchCourseTxtBox;
	}

	public HTMLPanel getAdminCoursePanel() {
		return adminCoursePanel;
	}

	public void setAdminCoursePanel(HTMLPanel adminCoursePanel) {
		this.adminCoursePanel = adminCoursePanel;
	}

	public AdminCourseViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		List<Section> sections = new ArrayList<>();
		List<Course> courses = new ArrayList<>();
		allCoursesGrid.insertRow(0);
		allCoursesGrid.resizeColumns(1);

		Section section1 = new Section();
		section1.setSectionName("C01");
		section1.setCrn(12345);
		section1.setType("Lecture");
		section1.setFrequency(4);
		section1.setExpectedPopulation(50);

		Section section2 = new Section();
		section2.setSectionName("C02");
		section2.setCrn(12346);
		section2.setType("Lab");
		section2.setFrequency(4);
		section2.setExpectedPopulation(50);

		sections.add(section1);
		sections.add(section2);

		Course course1 = new Course();
		course1.setCourseName("Software Engineering");
		course1.setCourseNumber("3733");
		course1.setSections(sections);

		courses.add(course1);
		courses.add(course1);
		courses.add(course1);

		for (int i = 0; i < courses.size(); i++) {
			DecoratorPanel coursePanel = new DecoratorPanel();
			Grid layout = new Grid(1, 3);

			FlowPanel courseInfoPanel = new FlowPanel();

			VerticalPanel courseName = new VerticalPanel();
			courseName.add(new Label(courses.get(i).getCourseName()));

			VerticalPanel courseNumber = new VerticalPanel();
			courseNumber.add(new Label(courses.get(i).getCourseNumber()));

			courseInfoPanel.add(courseName);
			courseInfoPanel.add(courseNumber);

			CellTable<Section> courseSections = new CellTable<Section>();

			TextColumn<Section> nameColumn = new TextColumn<Section>() {
				@Override
				public String getValue(Section object) {
					return object.getSectionName();
				}
			};
			courseSections.addColumn(nameColumn, "Name");

			TextColumn<Section> crnColumn = new TextColumn<Section>() {
				@Override
				public String getValue(Section object) {
					return Integer.toString(object.getCrn());
				}
			};
			courseSections.addColumn(crnColumn, "CRN");

			TextColumn<Section> typeColumn = new TextColumn<Section>() {
				@Override
				public String getValue(Section object) {
					return object.getType();
				}
			};
			courseSections.addColumn(typeColumn, "Type");

			TextColumn<Section> populationColumn = new TextColumn<Section>() {
				@Override
				public String getValue(Section object) {
					return Integer.toString(object.getExpectedPopulation());
				}
			};
			courseSections.addColumn(populationColumn, "Population");

			TextColumn<Section> frequencyColumn = new TextColumn<Section>() {
				@Override
				public String getValue(Section object) {
					return Integer.toString(object.getFrequency());
				}
			};
			courseSections.addColumn(frequencyColumn, "Frequency");

			courseSections.setRowCount(courses.get(i).getSections().size(), true);
			courseSections.setRowData(0, courses.get(i).getSections());
			courseSections.setWidth("100%");

			Button modifyCourseButton = new Button("Modify");
			modifyCourseButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					final Injector injector = Injector.INSTANCE;

					IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
					IndexView indexView = indexPresenter.getView();

					CreateModifyCoursePresenterImpl createModifyCoursePresenter = injector
							.getCreateModifyCoursePresenter();

					createModifyCoursePresenter.go(indexView.getViewRootPanel());
				}
			});

			layout.setWidget(0, 0, courseInfoPanel);
			layout.setWidget(0, 1, courseSections);
			layout.setWidget(0, 2, modifyCourseButton);

			coursePanel.add(layout);

			int newRow = allCoursesGrid.getRowCount();
			allCoursesGrid.insertRow(newRow);
			allCoursesGrid.setWidget(newRow, 0, coursePanel);
		}

	}

	interface AdminCourseViewImplUiBinder extends UiBinder<Widget, AdminCourseViewImpl> {
	}

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
		return adminCoursePanel;
	}

	@Override
	public void setPresenter(AdminCoursePresenter presenter) {
		this.presenter = presenter;
	}

	/*
	 * @UiHandler("modifyCourseBtn") void onModifyCourseBtnClick(ClickEvent event) {
	 * final Injector injector = Injector.INSTANCE;
	 * 
	 * IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); //
	 * on-demand injection IndexView indexView = indexPresenter.getView();
	 * 
	 * CreateModifyCoursePresenterImpl createModifyCoursePresenter =
	 * injector.getCreateModifyCoursePresenter();
	 * 
	 * createModifyCoursePresenter.go(indexView.getViewRootPanel()); }
	 */

	@UiHandler("addCourseBtn")
	void onAddCourseBtnClick(ClickEvent event) {
		final Injector injector = Injector.INSTANCE;

		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		IndexView indexView = indexPresenter.getView();

		CreateModifyCoursePresenterImpl createModifyCoursePresenter = injector.getCreateModifyCoursePresenter();

		createModifyCoursePresenter.go(indexView.getViewRootPanel());
	}
}
