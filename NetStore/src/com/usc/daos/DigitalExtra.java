package com.usc.daos;

import java.sql.Blob;

public class DigitalExtra
{
	private Integer digitalId;//����ID
	private String digitalName;//��������
	private String manufacturer;//����
	private String brand; //Ʒ��
	private String modelNumber;//�ͺ�
	private String barcode;//������
	private Float publishedPrice;// ����
	private Float discount;// �ۿ�
	private Float salePrice;//�ؼ�
	private Integer priority; //���ȼ�
	public Integer getDigitalId()
	{
		return digitalId;
	}
	public void setDigitalId(Integer digitalId)
	{
		this.digitalId = digitalId;
	}
	public String getDigitalName()
	{
		return digitalName;
	}
	public void setDigitalName(String digitalName)
	{
		this.digitalName = digitalName;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public String getModelNumber()
	{
		return modelNumber;
	}
	public void setModelNumber(String modelNumber)
	{
		this.modelNumber = modelNumber;
	}
	public String getBarcode()
	{
		return barcode;
	}
	public void setBarcode(String barcode)
	{
		this.barcode = barcode;
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
	
}
