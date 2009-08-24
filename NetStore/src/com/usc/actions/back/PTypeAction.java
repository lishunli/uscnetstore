package com.usc.actions.back;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Producttype;
import com.usc.daos.ProducttypeDAO;

public class PTypeAction extends ActionSupport
{
	private List<Producttype> pType;//类型
	private ProducttypeDAO pTypeDao;//ProducttypeDAO
	
	public void setPTypeDao(ProducttypeDAO typeDao)
	{
		pTypeDao = typeDao;
	}

	public List<Producttype> getPType()
	{
		return pType;
	}
	
	@SuppressWarnings("unchecked")
	public void getAllPType()
	{
		pType = pTypeDao.findAll();//返回所有的产品类型
//		for(Producttype pT : pType)
//		{
//			System.out.println(pT.getProductTypeName());
//		}
	}
}
