package com.usc.daos;

/**
 * Shoppingcart entity. @author MyEclipse Persistence Tools
 */

public class Shoppingcart implements java.io.Serializable
{

	// Fields

	private Integer shoppingCartId;
	private Custom custom;
	private Commodity commodity;
	private Float shoppingPrice;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Shoppingcart()
	{
	}

	/** minimal constructor */
	public Shoppingcart(Float shoppingPrice, Integer quantity)
	{
		this.shoppingPrice = shoppingPrice;
		this.quantity = quantity;
	}

	/** full constructor */
	public Shoppingcart(Custom custom, Commodity commodity,
			Float shoppingPrice, Integer quantity)
	{
		this.custom = custom;
		this.commodity = commodity;
		this.shoppingPrice = shoppingPrice;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getShoppingCartId()
	{
		return this.shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId)
	{
		this.shoppingCartId = shoppingCartId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Commodity getCommodity()
	{
		return this.commodity;
	}

	public void setCommodity(Commodity commodity)
	{
		this.commodity = commodity;
	}

	public Float getShoppingPrice()
	{
		return this.shoppingPrice;
	}

	public void setShoppingPrice(Float shoppingPrice)
	{
		this.shoppingPrice = shoppingPrice;
	}

	public Integer getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

}