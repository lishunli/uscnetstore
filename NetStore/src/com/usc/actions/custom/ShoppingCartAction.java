package com.usc.actions.custom;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.daos.Shoppingcart;
import com.usc.daos.ShoppingcartDAO;

public class ShoppingCartAction extends ActionSupport {

	//商品名  定价  优惠价  数量
	private ShoppingcartDAO shoppingcart;

	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		String customName = custom.getCustomName();
		List<Shoppingcart> list = shoppingcart.findByCustomName(customName);
		Map request = (Map)ActionContext.getContext().get("request"); 
		request.put("Shoppingcart", list);
		return "success";
	}

	public ShoppingcartDAO getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingcartDAO shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	
	

	
}
