package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;

/**
 * 发布产品
 * @author MZ
 *
 */
public class PublisheAction extends ActionSupport
{
	private int bookId;
	private int type;
	private float discount;

	public int getBookId()
	{
		return bookId;
	}

	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public float getDiscount()
	{
		return discount;
	}

	public void setDiscount(float discount)
	{
		this.discount = discount;
	}

//		System.out.println("bookId:"+bookId+"type:"+type+"discount:"+discount);
	
	@Override
	public String execute() throws Exception
	{
		return super.execute();
	}
}
