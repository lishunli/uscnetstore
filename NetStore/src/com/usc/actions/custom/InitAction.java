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
 * ��ҳ��ĳ�ʼ����������ü���ҳ�������
 * 
 * @author MZ
 * 
 *         2009-8-28����03:34:19
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
				if (commodity.getSaleFlag() == 0)// �����������Ǵ�����Ʒ
				{
					BookExtra bookExtra = new BookExtra();// ʵ������չBook�Ķ���
					BeanUtils.copyProperties(bookExtra, book);// ��copy
					bookExtra.setDiscount(sysAdmin.getDiscount(1, book
							.getBookId()));// �����ۿ�
					// bookExtra.setSalePrice(sysAdmin.getSalePrice(1,
					// book.getBookId()));//���ô�����
					// bookExtra.setPriority(sysAdmin.getPriority(1,
					// book.getBookId()));//�������ȼ�
					bookExtra.setPrivilegePrice(bookExtra.getDiscount()
							* bookExtra.getPublishedPrice() / 100);// ���û�Ա��
					bookExtraCommonList.add(bookExtra);
				} else
				// ������Ʒ
				{
					BookExtra bookExtra = new BookExtra();// ʵ������չBook�Ķ���
					BeanUtils.copyProperties(bookExtra, book);// ��copy
					// bookExtra.setDiscount(sysAdmin.getDiscount(1,
					// book.getBookId()));// �����ۿ�
					bookExtra.setSalePrice(sysAdmin.getSalePrice(1, book
							.getBookId()));// ���ô�����
					bookExtra.setPriority(sysAdmin.getPriority(1, book
							.getBookId()));// �������ȼ�
					bookExtra.setPrivilegePrice(bookExtra.getSalePrice());// ���û�Ա��
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
				if (commodity.getSaleFlag() == 0)// �����������Ǵ�����Ʒ
				{
					DigitalExtra digitalExtra = new DigitalExtra();
					BeanUtils.copyProperties(digitalExtra, digital);
					digitalExtra.setDiscount(sysAdmin.getDiscount(2,
							digitalExtra.getDigitalId()));// �����ۿ�
					digitalExtra.setPrivilegePrice(digitalExtra.getDiscount()
							* digitalExtra.getPublishedPrice() / 100);// ���û�Ա��
					digitalExtraCommonList.add(digitalExtra);
				} else
				{
					DigitalExtra digitalExtra = new DigitalExtra();
					BeanUtils.copyProperties(digitalExtra, digital);
					digitalExtra.setSalePrice(sysAdmin.getSalePrice(2,
							digitalExtra.getDigitalId()));// ���ô�����
					digitalExtra.setPriority(sysAdmin.getPriority(2,
							digitalExtra.getDigitalId()));// �������ȼ�
					digitalExtra.setPrivilegePrice(digitalExtra.getSalePrice());// ���û�Ա��
					digitalExtraSaleList.add(digitalExtra);
				}
			}
		}
		request.put("digitalCommonInit", digitalExtraCommonList);
		request.put("digitalSaleInit", digitalExtraSaleList);
		return SUCCESS;
	}
}
