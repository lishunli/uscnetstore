package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.services.back.ISystemAdmin;

/**
 * 修改促销商品（促销价或优先级）
 * @author MZ
 *
 */
public class MergeSaleAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	private float salePrice;// 促销价
	private int priority;//优先级
	
	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	
	@Override
	public String execute() throws Exception
	{
		sysAdmin.mergeSale(type, entityID, salePrice, priority);
		return SUCCESS;
	}

}
