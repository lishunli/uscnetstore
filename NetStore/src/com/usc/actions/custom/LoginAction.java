package com.usc.actions.custom;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.Impl.BeforeMainImpl;

public class LoginAction extends ActionSupport {

	private BeforeMainImpl beforemainimpl;
	
	private Custom custom;
	
	private String customPass;
	


	@Override
	public String execute() throws Exception {
		Custom c = (Custom)beforemainimpl.findbyCustomName(custom.getCustomName()).iterator().next();
	 if(beforemainimpl.findbyCustomName(custom.getCustomName())!=null && c.getCustomPass().equals(customPass.trim()))
		 return "success";
	 else return "error";
		
	}

	public BeforeMainImpl getBeforemainimpl() {
		return beforemainimpl;
	}

	public void setBeforemainimpl(BeforeMainImpl beforemainimpl) {
		this.beforemainimpl = beforemainimpl;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public String getCustomPass() {
		return customPass;
	}

	public void setCustomPass(String customPass) {
		this.customPass = customPass;
	}
}
