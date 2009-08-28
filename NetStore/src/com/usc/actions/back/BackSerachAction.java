package com.usc.actions.back;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.BookDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;

/**
 * ��̨ģ������
 * 
 * @author MZ
 *
 * 2009-8-28����09:43:59
 */
public class BackSerachAction extends ActionSupport
{
	private String type;
	private String productsName;
	private BookDAO bookDao;
	private DigitalDAO digitalDao;

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

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	@Override
	public void validate()
	{
	}

	@Override
	public String execute() throws Exception
	{
		
		if (null != type)
		{
			Map request = (Map) ActionContext.getContext().get("request");
			if ("ͼ��".equals(type.trim()))
			{
				request.put("bookSerach", bookDao.findByLikeBookName(productsName.trim()));
			} else if ("����".equals(type.trim()))
			{
				request.put("digitalSerach",digitalDao.findByLikeDigitalName(productsName.trim()));
			}
		}
		return SUCCESS;
	}

}
