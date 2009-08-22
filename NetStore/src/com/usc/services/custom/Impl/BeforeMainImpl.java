package com.usc.services.custom.Impl;

import java.util.List;

import com.usc.daos.Custom;
import com.usc.daos.CustomDAO;
import com.usc.services.custom.IBeforeMain;

public class BeforeMainImpl implements IBeforeMain {

	private CustomDAO customdao;
	
	public void saveCustom(Custom custom) {
		customdao.save(custom);
	}
	
	public List<Custom> findbyCustomName(String customName) {
		if(customdao.findByCustomName(customName).size()>0)
			return (List<Custom>)customdao.findByCustomName(customName);
		else return null;
		
	}

	public CustomDAO getCustomdao() {
		return customdao;
	}

	public void setCustomdao(CustomDAO customdao) {
		this.customdao = customdao;
	}

	

}
