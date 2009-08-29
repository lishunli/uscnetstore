package com.usc.services.custom.Impl;

import com.usc.daos.Custom;
import com.usc.daos.CustomDAO;
import com.usc.daos.Suggestion;
import com.usc.services.custom.IPersonManage;

public class IPersonManageImpl implements IPersonManage {
	
	private CustomDAO customdao;
	
	public void changeCustomInfo(Custom custom,String realName,String sex,String address,String postCode,String mobile,String phone)
	{
		customdao.changeCustomInfo(custom, realName, sex, address, postCode, mobile, phone);
	}

	
	public void changeCustomPassword(Custom custom, String newPassword) {
		customdao.changeCustomPassword(custom, newPassword);
		
	}


	public void changeCustomEmail(Custom custom, String email) {
		customdao.changeCustomEmail(custom, email);
		
	}



	public void UTransfor(Custom custom1, String custom2Name, float Unumber) {
//		customdao.UTransfor(custom1, custom2Name, Unumber);
		
	}



	public CustomDAO getCustomdao() {
		return customdao;
	}

	public void setCustomdao(CustomDAO customdao) {
		this.customdao = customdao;
	}


	public void saveSuggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		
	}


}
