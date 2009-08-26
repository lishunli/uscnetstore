package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ºóÌ¨ÍË³öAction
 * @author MZ
 *
 */
public class BackExitAction extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		ActionContext.getContext().getSession().remove("manger");//sessionÒÆ³ý
		return SUCCESS;
	}
	

}
