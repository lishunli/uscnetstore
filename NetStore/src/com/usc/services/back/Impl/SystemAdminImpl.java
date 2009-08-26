package com.usc.services.back.Impl;

import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.services.back.ISystemAdmin;



/**
 * 系统管理员System administrator
 * 提供系统管理员的接口的实现
 * @author MZ
 *
 */
public class SystemAdminImpl implements ISystemAdmin
{
	private Book book;//图书，通过Spring注入
	private Digital digital;//数码，通过Spring注入
	private BookDAO bookDao;//图书DAO，通过Spring注入
	private DigitalDAO digitalDao;//数码DAO，通过Spring注入
	private ProductsDAO productDao;//产品DAO，通过Spring注入
	private OperatorDAO operDao;//操作员DAO，通过Spring注入

	public void setBook(Book book)
	{
		this.book = book;
	}

	public void setDigital(Digital digital)
	{
		this.digital = digital;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	public void setProductDao(ProductsDAO productDao)
	{
		this.productDao = productDao;
	}

	public void setOperDao(OperatorDAO operDao)
	{
		this.operDao = operDao;
	}

	/**
	 * 根据操作员姓名来唯一获得ID
	 */
	public int getOperatorID(String operatorName)
	{
		for(Operator oper :operDao.findByOperatorName(operatorName))
		{
			return oper.getOperatorId();
		}
		return 0;
	}

	/**
	 * 根据产品类型ID和实物ID来获得产品ID
	 */
	public int getProductID(int productTypeID, int entityID)
	{
		for(Products pro:productDao.findByEntityId(entityID))
		{
			if(pro.getProductTypeId()== productTypeID)
				return pro.getProductsId();
		}
		return 0;
	}

	/**
	 * 根据产品类型ID和实物ID来设置产品发布标志位
	 */
	public void setProductPFlag(int productTypeID, int entityID)
	{
		if(1 == productTypeID)
		{
			book=bookDao.findById(entityID);//找到book
			book.setProductsPflag(1);//设置发布标志位
			bookDao.merge(book);//更新book
		}
		else if(2 == productTypeID)
		{
			digital=digitalDao.findById(entityID);//找到数码
			digital.setProductsPflag(1);//设置发布标志位
			digitalDao.merge(digital);//更新数码
		}
	}
	
}
