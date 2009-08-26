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
 * ϵͳ����ԱSystem administrator
 * �ṩϵͳ����Ա�Ľӿڵ�ʵ��
 * @author MZ
 *
 */
public class SystemAdminImpl implements ISystemAdmin
{
	private Book book;//ͼ�飬ͨ��Springע��
	private Digital digital;//���룬ͨ��Springע��
	private BookDAO bookDao;//ͼ��DAO��ͨ��Springע��
	private DigitalDAO digitalDao;//����DAO��ͨ��Springע��
	private ProductsDAO productDao;//��ƷDAO��ͨ��Springע��
	private OperatorDAO operDao;//����ԱDAO��ͨ��Springע��

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
	 * ���ݲ���Ա������Ψһ���ID
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
	 * ���ݲ�Ʒ����ID��ʵ��ID����ò�ƷID
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
	 * ���ݲ�Ʒ����ID��ʵ��ID�����ò�Ʒ������־λ
	 */
	public void setProductPFlag(int productTypeID, int entityID)
	{
		if(1 == productTypeID)
		{
			book=bookDao.findById(entityID);//�ҵ�book
			book.setProductsPflag(1);//���÷�����־λ
			bookDao.merge(book);//����book
		}
		else if(2 == productTypeID)
		{
			digital=digitalDao.findById(entityID);//�ҵ�����
			digital.setProductsPflag(1);//���÷�����־λ
			digitalDao.merge(digital);//��������
		}
	}
	
}
