package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserCreatePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserSearchPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;

public interface UserCreateView extends BaseView<UserCreatePresenter>{
	TextBox getWpiIdBox();
	TextBox getUsernameBox();
	TextBox getFirstNameBox();
	TextBox getLastNameBox();
	TextBox getEmailBox();
	ListBox getUserRole();
	Button getFinalizeCreateButton();
	void showErrorMessages(String errorMessages);
}
