package com.usc.actions.back;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.ProducttypeDAO;
import com.usc.services.back.IManger;

public class BookEntryAction extends ActionSupport
{
	private Book book;//图书
	private BookDAO bookDao;//图书dao
	private File upload;//上传的图片
	private ProducttypeDAO pTypeDao;//ProducttypeDAO
	private int[] PTypeID;//type
	private IManger manger;// 接口实现对象，通过Spring注入
	
	public void setPTypeDao(ProducttypeDAO typeDao)
	{
		pTypeDao = typeDao;
	}

	public File getUpload()
	{
		return upload;
	}

	public void setUpload(File upload)
	{
		this.upload = upload;
	}


	public int[] getPTypeID()
	{
		return PTypeID;
	}

	public void setPTypeID(int[] typeID)
	{
		PTypeID = typeID;
	}

	public void setManger(IManger manger)
	{
		this.manger = manger;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	@Override
	public void validate()
	{
		if(null != book)
		{
			if(null == book.getBookName() || "".equals(book.getBookName().trim()))
			{
				this.addFieldError("book.bookName", "图书名不能为空");
			}
//			System.out.println("ISBN:"+book.getIsbn());
//			System.out.println("PTypeID:"+PTypeID);
		}
	}

	@Override
	public String execute() throws Exception
	{
		if(null != book)
		{
			
			System.out.println("book.....");
//			try
//			{
//				if(null == upload)
//					System.out.println("upload file is null ");
			if(null != upload)
			{
//				System.out.println("upload.....");
				FileInputStream fin = new FileInputStream(upload);
				Blob blob = Hibernate.createBlob(fin);
				book.setPicture(blob);
			}
//			} catch (Exception e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			int i=0;
			for(;i<PTypeID.length;i++)
			{
				if(PTypeID[i] == 0)
					break;
			}
//			System.out.println(PTypeID[i-1]);
			book.setProductTypeID(PTypeID[i-1]);
			book.setProductsPflag(0);
			bookDao.save(book);
			
			return SUCCESS;
		}
		// TODO Auto-generated method stub
		return INPUT;
	}
}
