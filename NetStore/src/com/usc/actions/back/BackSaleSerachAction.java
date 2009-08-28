package com.usc.actions.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.BookExtra;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.DigitalExtra;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;

public class BackSaleSerachAction extends ActionSupport
{
	private String type;
	private String productsName;
	private BookDAO bookDao;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private SaleDAO saleDao;
	private List<BookExtra> bookExtraList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraList = new ArrayList<DigitalExtra>();

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getProductsName()
	{
		return productsName;
	}

	public void setProductsName(String productsName)
	{
		this.productsName = productsName;
	}

	public List<BookExtra> getBookExtraList()
	{
		return bookExtraList;
	}

	public List<DigitalExtra> getDigitalExtraList()
	{
		return digitalExtraList;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}

	@Override
	public String execute() throws Exception
	{
		if (null != type)
		{
			Map request = (Map) ActionContext.getContext().get("request");
			bookExtraList.clear();
			digitalExtraList.clear();//���List����ֹList�ۻ�
			if ("ͼ��".equals(type.trim()))
			{
				for (Book book : bookDao.findByLikeCommonBookName(productsName
						.trim()))//��ͨ��Ʒ���ѷ�����ģ������
				{
					for (Commodity commodity : commodityDao
							.findByProductsID(sysAdmin.getProductID(1, book
									.getBookId())))//ͨ����ƷID�ҵ���Ʒ
					{
						if (commodity.getSaleFlag() == 1)// �������Ǵ�����Ʒ
						{
							BookExtra bookExtra = new BookExtra();//ʵ������չBook�Ķ���
							BeanUtils.copyProperties(bookExtra, book);//��copy
							for(Sale sale : saleDao.findByCommodityId(commodity.getCommodityId()))
							{
								bookExtra.setSalePrice(sale.getSalePrice());//���ô�����
								bookExtra.setPriority(sale.getPriority());//�������ȼ�
							}
							bookExtraList.add(bookExtra);
						}
					}
				}
				request.put("bookSale", bookExtraList);//�Ž�List
			} else if ("����".equals(type.trim()))
			{
				for (Digital digital : digitalDao
						.findByLikeCommonDigitalName(productsName.trim()))
				{
					for (Commodity commodity : commodityDao
							.findByProductsID(sysAdmin.getProductID(2, digital
									.getDigitalId())))
					{
						if (commodity.getSaleFlag() == 1)// �������Ǵ�����Ʒ
						{
							DigitalExtra digitalExtra = new DigitalExtra();//ʵ������չBook�Ķ���
							BeanUtils.copyProperties(digitalExtra, digital);//��copy
							for(Sale sale : saleDao.findByCommodityId(commodity.getCommodityId()))
							{
								digitalExtra.setSalePrice(sale.getSalePrice());//���ô�����
								digitalExtra.setPriority(sale.getPriority());//�������ȼ�
							}
							digitalExtraList.add(digitalExtra);
						}
					}
				}
				request.put("digitalSale", digitalExtraList);//�Ž�List
			}
		}
		return SUCCESS;
	}
}
