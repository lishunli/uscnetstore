package com.usc.daos;

import java.sql.Blob;

public class DigitalExtra
{
	private Integer digitalId;//数码ID
	private String digitalName;//数码名称
	private String manufacturer;//厂家
	private String brand; //品牌
	private String modelNumber;//型号
	private String barcode;//条形码
	private Float publishedPrice;// 定价
	private Float discount;// 折扣
	private Float salePrice;//特价
	private Integer priority; //优先级
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
