package com.usc.actions.custom;

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
import com.usc.services.back.ISystemAdmin;

/**
 * 首页面的初始化操作，获得加载页面的数据
 * 
 * @author MZ
 * 
 *         2009-8-28下午03:34:19
 */
public class InitAction extends ActionSupport
{
	private BookDAO bookDao;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private List<BookExtra> bookExtraCommonList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraCommonList = new ArrayList<DigitalExtra>();
	private List<BookExtra> bookExtraSaleList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraSaleList = new ArrayList<DigitalExtra>();

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

	@Override
	public String execute() throws Exception
	{
		Map request = (Map) ActionContext.getContext().get("request");
		bookExtraCommonList.clear();
		digitalExtraCommonList.clear();
		bookExtraSaleList.clear();
		digitalExtraSaleList.clear();
		for (Book book : bookDao.findByLikeCommonBookName(""))
		{
			for (Commodity commodity : commodityDao.findByProductsID(sysAdmin
					.getProductID(1, book.getBookId())))
			{
				if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
				{
					BookExtra bookExtra = new BookExtra();// 实例化扩展Book的对象
					BeanUtils.copyProperties(bookExtra, book);// 类copy
					bookExtra.setDiscount(sysAdmin.getDiscount(1, book
							.getBookId()));// 设置折扣
					// bookExtra.setSalePrice(sysAdmin.getSalePrice(1,
					// book.getBookId()));//设置促销价
					// bookExtra.setPriority(sysAdmin.getPriority(1,
					// book.getBookId()));//设置优先级
					bookExtra.setPrivilegePrice(bookExtra.getDiscount()
							* bookExtra.getPublishedPrice() / 100);// 设置会员价
					bookExtraCommonList.add(bookExtra);
				} else
				// 促销商品
				{
					BookExtra bookExtra = new BookExtra();// 实例化扩展Book的对象
					BeanUtils.copyProperties(bookExtra, book);// 类copy
					// bookExtra.setDiscount(sysAdmin.getDiscount(1,
					// book.getBookId()));// 设置折扣
					bookExtra.setSalePrice(sysAdmin.getSalePrice(1, book
							.getBookId()));// 设置促销价
					bookExtra.setPriority(sysAdmin.getPriority(1, book
							.getBookId()));// 设置优先级
					bookExtra.setPrivilegePrice(bookExtra.getSalePrice());// 设置会员价
					bookExtraSaleList.add(bookExtra);
				}
			}
		}
//		for(BookExtra bookE : bookExtraCommonList)
//		{
//			System.out.println("bookE.getBookName:"+bookE.getBookName());
//		}
//		for(BookExtra bookE : bookExtraSaleList)
//		{
//			System.out.println("bookE.getBookName:"+bookE.getBookName());
//		}
		request.put("bookCommonInit", bookExtraCommonList);
		request.put("bookSaleInit", bookExtraSaleList);

		for (Digital digital : digitalDao.findByLikeCommonDigitalName(""))
		{
			for (Commodity commodity : commodityDao.findByProductsID(sysAdmin
					.getProductID(2, digital.getDigitalId())))
			{
				if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
				{
					DigitalExtra digitalExtra = new DigitalExtra();
					BeanUtils.copyProperties(digitalExtra, digital);
					digitalExtra.setDiscount(sysAdmin.getDiscount(2,
							digitalExtra.getDigitalId()));// 设置折扣
					digitalExtra.setPrivilegePrice(digitalExtra.getDiscount()
							* digitalExtra.getPublishedPrice() / 100);// 设置会员价
					digitalExtraCommonList.add(digitalExtra);
				} else
				{
					DigitalExtra digitalExtra = new DigitalExtra();
					BeanUtils.copyProperties(digitalExtra, digital);
					digitalExtra.setSalePrice(sysAdmin.getSalePrice(2,
							digitalExtra.getDigitalId()));// 设置促销价
					digitalExtra.setPriority(sysAdmin.getPriority(2,
							digitalExtra.getDigitalId()));// 设置优先级
					digitalExtra.setPrivilegePrice(digitalExtra.getSalePrice());// 设置会员价
					digitalExtraSaleList.add(digitalExtra);
				}
			}
		}
		request.put("digitalCommonInit", digitalExtraCommonList);
		request.put("digitalSaleInit", digitalExtraSaleList);
		return SUCCESS;
	}
}
