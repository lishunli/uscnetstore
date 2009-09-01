package com.usc.actions.back;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * ��������
 * 
 * @author MZ
 *
 * 2009-8-28����09:44:40
 */
public class UnPublisheAction extends ActionSupport
{
	private int entityID;// ʵ��ID
	private int type;// ���ͣ�1Ϊͼ�飬2Ϊ����
	
	private ISystemAdmin sysAdmin;// ϵͳ����Աʵ��ʵ��������ͨ��Springע��
	private Commodity commodity;// ��Ʒ����ͨ��Springע��
	private CommodityDAO commodityDao;// ��Ʒ����DAO��ͨ��Springע��
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
	public void setCommodity(Commodity commodity)
	{
		this.commodity = commodity;
	}
	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}
	
	@Override
	public String execute() throws Exception
	{
		sysAdmin.setProductPFlag(type, entityID, 0);//���ò�Ʒ������־λ0
		/**
		 * ɾ���ѷ����Ĳ�Ʒ����Ʒ����
		 */
		/**
		 * 1.�������ͺ�ʵ��ID���ҵ���ƷID
		 * 2.ͨ����ƷID�ҵ���ƷID��Ӧ��Ψһ��
		 * 3.ɾ������Ʒ
		 */
		for(Commodity commodity : commodityDao.findByProductsID(sysAdmin.getProductID(type, entityID)))
		{
			commodityDao.delete(commodity);
		}
		return SUCCESS;
	}

	
}
