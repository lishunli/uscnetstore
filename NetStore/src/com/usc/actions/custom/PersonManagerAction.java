package com.usc.actions.custom;

import javax.servlet.ServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public  class PersonManagerAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		ServletRequest request = null;
		
		request.setAttribute("f",request.getAttribute("f"));
		return "success";
	}
	
	

}
