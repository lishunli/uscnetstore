package com.usc.actions.back;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.daos.ProducttypeDAO;
import com.usc.services.back.IManger;

public class BookEntryAction extends ActionSupport
{
	private Book book;//ͼ��,ͨ��Struts2����
	private File upload;//�ϴ���ͼƬ
	private int[] PTypeID;//type�����飬��ȡ����������ѡ���ֵ
	private IManger manger;// �ӿ�ʵ�ֶ���ͨ��Springע��
	private BookDAO bookDao;//ͼ��dao��ͨ��Springע��
	private ProducttypeDAO pTypeDao;//ProducttypeDAO��ͨ��Springע��
	private Products product;//��Ʒ��ͨ��Springע��
	private ProductsDAO pDao;//��ƷDAO��ͨ��Springע��

	
	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
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

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setPTypeDao(ProducttypeDAO typeDao)
	{
		pTypeDao = typeDao;
	}

	public void setProduct(Products product)
	{
		this.product = product;
	}

	public void setPDao(ProductsDAO dao)
	{
		pDao = dao;
	}

	/**
	 * �������֤
	productTypeID  //����Ϊ0�����Ϊ0��ʾ��ѡ��
	bookName //����Ϊ��
	publisher //����Ϊ��
	isbn //����Ϊ�� �� �̶���ʽ ����Ψһ
	publishedPrice//����Ϊ����Ϊfloat���ͣ������жϣ�
	publishedTime//����Ϊ�գ�����Ϊ��ʱ�����������ڸ�ʽ
	productsPflag//��ʼʱ����Ϊ0
	upload//ͼƬ���ϴ���һ���Ĵ�С�͸�ʽ���ƣ�����Ϊ�գ������֤��Struts�������ļ���
	 * 
	 */
	
	
	@Override
	public void validate()
	{
		if(null != book)//��������ֵ��Ϊ��
		{
			if(null == book.getIsbn() || "".equals(book.getIsbn().trim()))//isbn ����Ϊ�� ����Ψһ    �� �̶���ʽ
			{ 
				this.addFieldError("book.isbn", "ISBN����Ϊ��");
			}
			else if(manger.checkIsbnIsExist(book.getIsbn().trim()))//isbn ����Ϊ�� ����Ψһ    �� �̶���ʽ
			{
				this.addFieldError("book.isbn", "ISBN�Ѵ��ڣ��˲�Ʒ��¼��");
			}
			if(null == book.getBookName() || "".equals(book.getBookName().trim()))//BookName����Ϊ��
			{
				this.addFieldError("book.bookName", "ͼ��������Ϊ��");
			}
			if(null == book.getPublishedPrice())//���۲���Ϊ�գ���ʽͨ��Struts�Ѿ���֤��������Ϣ��message.properties�ļ��У�
			{
				this.addFieldError("book.publishedPrice", "���۲���Ϊ��");
			}
			if(null == book.getPublisher() || "".equals(book.getPublisher().trim()))//�����粻��Ϊ��
			{
				this.addFieldError("book.publisher", "�����粻��Ϊ��");
			}
			if(0== PTypeID[0])//û��ѡ�����
			{
				this.addFieldError("PTypeID", "��ѡ�����");
			}
			else if(1 != PTypeID[0])//�����ͱ���1Ϊͼ�飬Ҳ����ѡ������Ͳ���ͼ��Ļ�
			{
				this.addFieldError("PTypeID", "��ѡ��ͼ�����");
			}
			//publishedTime//����Ϊ�գ�����Ϊ��ʱ�����������ڸ�ʽ����ʽͨ��Struts�Ѿ���֤��������Ϣ��message.properties�ļ��У�
			
		}
	}

	@Override
	public String execute() throws Exception
	{
		if(null != book)//��������ֵ��Ϊ��
		{
			if(null != upload)
			{
				FileInputStream fin = new FileInputStream(upload);//File ת InputStream
				Blob blob = Hibernate.createBlob(fin);//InputStream ת Blob
				book.setPicture(blob);
			}
			int i=0;
			for(;i<PTypeID.length;i++)
			{
				if(PTypeID[i] == 0)//Ϊ0��ʾû�������ˣ�����ǰһ��������С������
					break;
			}
			book.setProductTypeID(PTypeID[i-1]);//ǰһ��������С������
			book.setProductsPflag(0);//��ʼʱ����Ϊ0
			bookDao.save(book);//¼��ͼ�飬ͬʱҪ���Ʒ���в�������
			product.setProductTypeId(PTypeID[0]);//���ò�Ʒ���еĲ�Ʒ����ID��Ϊ������ID
			for(Book b : bookDao.findByIsbn(book.getIsbn().trim()))//ͨ��ISBN�ҵ���book����ȡbookID
			{
				product.setEntityId(b.getBookId());//�ѻ�ȡ��bookID��Ϊʵ��ID���ý�
			}
			pDao.save(product);//����Ϊ��Ʒ
			return SUCCESS;
		}
		return INPUT;
	}
}
