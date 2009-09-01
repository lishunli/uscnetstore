package com.usc.daos;

import java.sql.Blob;
import java.util.Date;


public class BookExtra
{
	private Integer bookId;//ͼ��ID
	private String bookName;//ͼ������ 
	private String author;//����
	private String publisher; //������  
	private String isbn;//ISBN
	private Float publishedPrice;//����
	private Float discount;// �ۿ�
	private Float salePrice;//�ؼ�
	private Integer priority; //���ȼ�
	private Integer productTypeName;//����
	private Date publishingTime;//����ʱ��
	private Date publisheTime;//����ʱ��
	private String version;//�汾
	private String catalog;//Ŀ¼
	private Blob picture;//��Ƭ
	private String briefIntroduction;//���ݼ��
	private Float privilegePrice;//��Ա�ۣ��п����Ƕ���*�ۿۣ��п�����vip
	
	public Integer getBookId()
	{
		return bookId;
	}
	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	public Float getPublishedPrice()
	{
		return publishedPrice;
	}
	public void setPublishedPrice(Float publishedPrice)
	{
		this.publishedPrice = publishedPrice;
	}
	public Float getDiscount()
	{
		return discount;
	}
	public void setDiscount(Float discount)
	{
		this.discount = discount;
	}
	public Float getSalePrice()
	{
		return salePrice;
	}
	public void setSalePrice(Float salePrice)
	{
		this.salePrice = salePrice;
	}
	public Integer getPriority()
	{
		return priority;
	}
	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}
	public Integer getProductTypeName()
	{
		return productTypeName;
	}
	public void setProductTypeName(Integer productTypeName)
	{
		this.productTypeName = productTypeName;
	}
	public Date getPublishingTime()
	{
		return publishingTime;
	}
	public void setPublishingTime(Date publishingTime)
	{
		this.publishingTime = publishingTime;
	}
	public Date getPublisheTime()
	{
		return publisheTime;
	}
	public void setPublisheTime(Date publisheTime)
	{
		this.publisheTime = publisheTime;
	}
	public String getVersion()
	{
		return version;
	}
	public void setVersion(String version)
	{
		this.version = version;
	}
	public String getCatalog()
	{
		return catalog;
	}
	public void setCatalog(String catalog)
	{
		this.catalog = catalog;
	}
	public Blob getPicture()
	{
		return picture;
	}
	public void setPicture(Blob picture)
	{
		this.picture = picture;
	}
	public String getBriefIntroduction()
	{
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction)
	{
		this.briefIntroduction = briefIntroduction;
	}
	public Float getPrivilegePrice()
	{
		return privilegePrice;
	}
	public void setPrivilegePrice(Float privilegePrice)
	{
		this.privilegePrice = privilegePrice;
	}
	
	
}
