package com.usc.actions.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.Bean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.BookExtra;
import com.usc.daos.DigitalExtra;
import com.usc.services.back.ISystemAdmin;
import com.usc.services.back.ISystemAdmin;

/**
 * ��̨��ͨ��Ʒ����
 * @author MZ
 *
 */
public class FuzzySearchAction extends ActionSupport
{	
	private int s;
	private String Search;
	private BookDAO bookDao ;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private List<BookExtra> bookExtraList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraList =  new ArrayList<DigitalExtra>();
	





	public String getSearch() {
		return Search;
	}


	public void setSearch(String search) {
		Search = search;
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

	@Override
	public String execute() throws Exception
	{
		bookExtraList.clear();
		digitalExtraList.clear();
			Map request = (Map) ActionContext.getContext().get("request");
			if (s==1)
			{
				for(Book book: bookDao.findByLikeCommonBookName(Search.trim()))
				{
					BookExtra bookExtra = new BookExtra(); 
					BeanUtils.copyProperties(bookExtra, book);
					bookExtra.setDiscount(sysAdmin.getDiscount(1, book.getBookId()));
					bookExtra.setSalePrice(sysAdmin.getSalePrice(1, book.getBookId()));
					bookExtra.setPriority(sysAdmin.getPriority(1, book.getBookId()));
					bookExtraList.add(bookExtra);
				}
				request.put("bookCommon",bookExtraList);
			} else if (s==2) {
				try {
					{
						for (Digital digital : digitalDao
								.findByLikeCommonDigitalName(Search.trim())) {
							DigitalExtra digitalExtra = new DigitalExtra();
							BeanUtils.copyProperties(digitalExtra, digital);
							digitalExtra.setDiscount(sysAdmin.getDiscount(1,
									digitalExtra.getDigitalId()));
							digitalExtra.setSalePrice(sysAdmin.getSalePrice(1,
									digitalExtra.getDigitalId()));
							digitalExtra.setPriority(sysAdmin.getPriority(1,
									digitalExtra.getDigitalId()));
							digitalExtraList.add(digitalExtra);
						}
						request.put("digitalCommon", digitalExtraList);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		return SUCCESS;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

}
