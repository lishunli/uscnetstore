package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 设为普通商品
 * @author MZ
 *
 */
public class UnSaleAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	public int getEntityID()
	{
		return entityID;
	}
	public void setEntityID(int entityID)
	{
		this.entityID = entityID;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}
	
	@Override
	public String execute() throws Exception
	{
		sysAdmin.setsaleFlag(type, entityID, 0);
		return SUCCESS;
	}
	
}
