package com.usc.actions.custom;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.Impl.BeforeMainImpl;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BeforeMainImpl beforemainimpl;

	private Custom custom;

	private String customPass;

	private String customNameorEmail;
	
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		if (beforemainimpl.findbyCustomName(customNameorEmail) != null)
			custom = (Custom) beforemainimpl
					.findbyCustomName(customNameorEmail).iterator().next();
		else if (beforemainimpl.findByEmail(customNameorEmail) != null)
			custom = (Custom) beforemainimpl.findByEmail(customNameorEmail)
					.iterator().next();
		if (customNameorEmail != null
				&& !customNameorEmail.equals("")
				&& custom != null
				&& custom.getCustomPass().equals(
						beforemainimpl.encoderByMd5(customNameorEmail.trim())))
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("Custom", custom);
			return "success";
		}
			else
			return "error";

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

	public String getCustomNameorEmail() {
		return customNameorEmail;
	}

	public void setCustomNameorEmail(String customNameorEmail) {
		this.customNameorEmail = customNameorEmail;
	}


	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
