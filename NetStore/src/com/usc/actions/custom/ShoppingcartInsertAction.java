package com.usc.actions.custom;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Custom;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Shoppingcart;
import com.usc.daos.ShoppingcartDAO;
import com.usc.services.back.Impl.SystemAdminImpl;

public class ShoppingcartInsertAction extends ActionSupport {

	
	//产品分类Id  实物Id
	private Shoppingcart shoppingcart;
	
	private ShoppingcartDAO shoppingcartdao;

	private BookDAO bookdao;
	
	private DigitalDAO digitaldao;
	
	private SystemAdminImpl admin;
	
	private int productTypeID;
	
	private int entityID;
	
	
	
	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		Book book = bookdao.findByTypeEntityId(productTypeID, entityID);
		Digital digital = digitaldao.findByTypeEntityId(productTypeID, entityID);
		if(book!=null)
		{
			shoppingcart=new Shoppingcart();
			shoppingcart.setCommodityId(admin.getCommodityID(productTypeID, entityID));
			shoppingcart.setCustomName(custom.getCustomName());
			shoppingcart.setShoppingPrice(admin.getDiscount(productTypeID, entityID)*book.getPublishedPrice());
		    shoppingcart.setQuantity(1);
		    shoppingcartdao.save(shoppingcart);
		}
		else 
		{
			shoppingcart=new Shoppingcart();
			shoppingcart.setCommodityId(admin.getCommodityID(productTypeID, entityID));
			shoppingcart.setCustomName(custom.getCustomName());
			shoppingcart.setShoppingPrice(admin.getDiscount(productTypeID, entityID)*digital.getPublishedPrice());
		    shoppingcart.setQuantity(1);
		    shoppingcartdao.save(shoppingcart);
		}
		return "success";
	}


	
	

	public Shoppingcart getShoppingcart() {
		return shoppingcart;
	}



	public void setShoppingcart(Shoppingcart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}





	public BookDAO getBookdao() {
		return bookdao;
	}





	public void setBookdao(BookDAO bookdao) {
		this.bookdao = bookdao;
	}





	public DigitalDAO getDigitaldao() {
		return digitaldao;
	}





	public void setDigitaldao(DigitalDAO digitaldao) {
		this.digitaldao = digitaldao;
	}





	public SystemAdminImpl getAdmin() {
		return admin;
	}





	public void setAdmin(SystemAdminImpl admin) {
		this.admin = admin;
	}





	public int getProductTypeID() {
		return productTypeID;
	}





	public void setProductTypeID(int productTypeID) {
		this.productTypeID = productTypeID;
	}





	public int getEntityID() {
		return entityID;
	}





	public void setEntityID(int entityID) {
		this.entityID = entityID;
	}





	public ShoppingcartDAO getShoppingcartdao() {
		return shoppingcartdao;
	}





	public void setShoppingcartdao(ShoppingcartDAO shoppingcartdao) {
		this.shoppingcartdao = shoppingcartdao;
	}






	
	
	
}
