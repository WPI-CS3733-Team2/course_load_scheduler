package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.BasePresenterImpl;


//For navigating to another page
public class NavigateAction {
	private BasePresenterImpl presenterImpl;
	
	public NavigateAction(BasePresenterImpl presenterImpl) {
		this.presenterImpl = presenterImpl;
	}
	
	public BasePresenterImpl getPresenterImpl()
	{
		return presenterImpl;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("NavigateAction [presenterImpl=");
		builder.append(presenterImpl);
		builder.append("]");
		return builder.toString();
	}
}
