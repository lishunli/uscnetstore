package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��̨�˳�Action
 * @author MZ
 *
 */
public class BackExitAction extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		ActionContext.getContext().getSession().remove("manger");//session�Ƴ�
		return SUCCESS;
	}
	

}
