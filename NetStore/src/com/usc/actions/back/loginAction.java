package com.usc.actions.back;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Operator;
import com.usc.services.back.IManger;

public class loginAction extends ActionSupport
{
	private Operator operator;
	private IManger manger; 
	
	public Operator getOperator()
	{
		return operator;
	}
	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}
	public void setManger(IManger manger)
	{
		this.manger = manger;
	}
	@Override
	public void validate()
	{
		if(null == operator.getOperatorName() || "".equals(operator.getOperatorName().trim()))
		{
			this.addFieldError("operator.operatorName", "姓名不能为空");
		}
		if(null == operator.getOperatorPass() || "".equals(operator.getOperatorPass().trim()))
		{
			this.addFieldError("operator.operatorPass", "密码不能为空");
		}
//		System.out.println("validate");
//		System.out.println(operator.getOperatorName());
		// TODO Auto-generated method stub
//		super.validate();
	}
	
	@Override
	public String execute() throws Exception
	{
		
		if(!manger.checkManger(operator))
		{
			this.addFieldError("operator.operatorName", "管理员登录失败，姓名或密码错误");
			return INPUT;
		}
		else
			return SUCCESS;
//		System.out.println("execute");
		// TODO Auto-generated method stub
		
		
//		ActionContext.getContext().getSession();
//		Map request = (Map) ActionContext.getContext().get("request");

//		request.put("list", service.findAll());
//		return super.execute();
	}
}
