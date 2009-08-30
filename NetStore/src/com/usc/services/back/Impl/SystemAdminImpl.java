package com.usc.services.back.Impl;

import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * ϵͳ����ԱSystem administrator �ṩϵͳ����Ա�Ľӿڵ�ʵ��
 * 
 * @author MZ
 * 
 */
public class SystemAdminImpl implements ISystemAdmin
{
	private Book book;// ͼ�飬ͨ��Springע��
	private Digital digital;// ���룬ͨ��Springע��
	private BookDAO bookDao;// ͼ��DAO��ͨ��Springע��
	private DigitalDAO digitalDao;// ����DAO��ͨ��Springע��
	private ProductsDAO productDao;// ��ƷDAO��ͨ��Springע��
	private OperatorDAO operDao;// ����ԱDAO��ͨ��Springע��
	private SaleDAO saleDao;// ����DAO��ͨ��Springע��
	private CommodityDAO commodityDao;// ��ƷDAO��ͨ��Springע��

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

	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	/**
	 * ���ݲ���Ա������Ψһ���ID
	 */
	public int getOperatorID(String operatorName)
	{
		for (Operator oper : operDao.findByOperatorName(operatorName))
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
		for (Products pro : productDao.findByEntityId(entityID))
		{
			if (pro.getProductTypeId() == productTypeID)
				return pro.getProductsId();
		}
		return 0;
	}

	/**
	 * ���ݲ�Ʒ����ID��ʵ��ID�����ò�Ʒ������־λ
	 */
	public void setProductPFlag(int productTypeID, int entityID, int flag)
	{
		if (1 == productTypeID)
		{
			book = bookDao.findById(entityID);// �ҵ�book
			book.setProductsPflag(flag);// ���÷�����־λ
			bookDao.merge(book);// ����book
		} else if (2 == productTypeID)
		{
			digital = digitalDao.findById(entityID);// �ҵ�����
			digital.setProductsPflag(flag);// ���÷�����־λ
			digitalDao.merge(digital);// ��������
		}
	}

	/**
	 * ���ݲ�Ʒ����ID��ʵ��ID����ȡ�ۿ�
	 */
	public float getDiscount(int productTypeID, int entityID)
	{
		/**
		 * 1.ͨ��ʵ��ID�ͷ���ID�ҵ���ƷID 2.ͨ����ƷID����Ʒ�����ҵ���Ʒ 3.������Ʒ���ۿ�
		 */

		for (Commodity commodity : commodityDao.findByProductsID(this
				.getProductID(productTypeID, entityID)))
		{
			return commodity.getDiscount();
		}
		return 0;
	}

	/**
	 * ���ݲ�Ʒ����ID��ʵ��ID����ȡ���ȼ�
	 */
	public int getPriority(int productTypeID, int entityID)
	{
		/**
		 * 1.ͨ��ʵ��ID�ͷ���ID�ҵ���ƷID 2.ͨ����ƷID����Ʒ�����ҵ���Ʒ 3.ͨ����ƷID�ڴ��������ҵ�������Ʒ
		 * 4.���ش�����Ʒ�����ȼ�
		 */
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				return sale.getPriority();
			}
		}
		return 0;
	}

	/**
	 * ���ݲ�Ʒ����ID��ʵ��ID����ȡ������
	 */
	public float getSalePrice(int productTypeID, int entityID)
	{
		/**
		 * 1.ͨ��ʵ��ID�ͷ���ID�ҵ���ƷID 2.ͨ����ƷID����Ʒ�����ҵ���Ʒ 3.ͨ����ƷID�ڴ��������ҵ�������Ʒ
		 * 4.���ش�����Ʒ�Ĵ�����
		 */
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				return sale.getSalePrice();
			}
		}
		return 0;
	}

	/**
	 * ���������Ʒ��Ҫע���ʱ������ȼ����д���
	 */
	public void saveSale(Sale s)
	{
		if (!saleDao.findByPriority(s.getPriority()).isEmpty())// �ڴ����������ҵ������ȼ�
		{
			for (Sale sale : saleDao.findByPriority(s.getPriority()))
			{
				sale.setPriority(getMaxPriority() + 1);
				saleDao.merge(sale);
			}
		}
		saleDao.save(s);
	}

	/**
	 * ���ݲ�Ʒ����ID��ʵ��ID��������Ʒ������־λ�ʹӴ�������ɾ��
	 */
	public void setsaleFlag(int productTypeID, int entityID, int flag)
	{
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			commodity.setSaleFlag(flag);// ���ô�����Ʒ��־λ
			commodityDao.merge(commodity);// ����
			for(Sale sale :saleDao.findByCommodityId(commodity.getCommodityId()))
			{
				saleDao.delete(sale);//�Ӵ�������ɾ��
			}
		}
	}

	/**
	 * ����������ȼ�+1
	 */
	public int getMaxPriority()
	{
		int MaxPriority = 0;
		for (Sale sale : saleDao.findAll())
		{
			if (sale.getPriority() > MaxPriority)
				MaxPriority = sale.getPriority();
		}
		return MaxPriority;
	}

	/**
	 * ���ݲ�Ʒ����ID��ʵ��ID�������ƷID
	 */
	public int getCommodityID(int productTypeID, int entityID)
	{
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			return commodity.getCommodityId();
		}
		return 0;
	}

	//��ö���
	public float getPublishedPrice(int commodityID)
	{
		int productId = commodityDao.findById(commodityID).getProductsID();
		int  ProductTypeID = productDao.findById(productId).getProductTypeId();
		int EntityID = productDao.findById(productId).getEntityId();		 
		 Book book  = bookDao.findByTypeEntityId(ProductTypeID, EntityID);
		 Digital digital = digitalDao.findByTypeEntityId(ProductTypeID, EntityID);
		 if(book!=null)
			 return book.getPublishedPrice();
		 else return digital.getPublishedPrice();
	}
	
	public String getCommodityName(int commodityID)
	{
		int productId = commodityDao.findById(commodityID).getProductsID();
		int  ProductTypeID = productDao.findById(productId).getProductTypeId();
		int EntityID = productDao.findById(productId).getEntityId();		 
		 Book book  = bookDao.findByTypeEntityId(ProductTypeID, EntityID);
		 Digital digital = digitalDao.findByTypeEntityId(ProductTypeID, EntityID);
		 if(book!=null)
			 return book.getBookName();
		 else
			 return digital.getDigitalName();
	}
	
	
	/**
	 * �ۿ� ���ȼ� �޸Ĵ�����
	 */
	public void mergeSale(int type, int entityID, float salePrice, int priority)
	{

		/**
		 * 1.ͨ��ʵ��ID�ͷ���ID�ҵ���ƷID 2.ͨ����ƷID����Ʒ�����ҵ���Ʒ 3.ͨ����ƷID�ڴ��������ҵ�������Ʒ
		 * 4.�޸Ĵ�����Ʒ�Ĵ����ۺ����ȼ�
		 */
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				type, entityID)))
		{
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				if (!saleDao.findByPriority(priority).isEmpty())// �ڴ����������ҵ������ȼ�
				{
					for (Sale s : saleDao.findByPriority(priority))
					{
						s.setPriority(getMaxPriority() + 1);
						saleDao.merge(s);
					}
				}
				sale.setSalePrice(salePrice);
				sale.setPriority(priority);
				saleDao.merge(sale);
			}

		}
	}

}
