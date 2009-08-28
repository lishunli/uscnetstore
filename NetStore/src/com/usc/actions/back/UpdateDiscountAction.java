package com.usc.actions.back;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * �޸Ĳ�Ʒ�ۿ�
 * 
 * @author MZ
 *
 * 2009-8-28����09:45:00
 */
public class UpdateDiscountAction extends ActionSupport
{
	private int entityID;// ʵ��ID
	private int type;// ���ͣ�1Ϊͼ�飬2Ϊ����
	private float discount;// �ۿ�

	private ISystemAdmin sysAdmin;// ϵͳ����Աʵ��ʵ��������ͨ��Springע��
	private Commodity commodity;// ��Ʒ����ͨ��Springע��
	private CommodityDAO commodityDao;// ��Ʒ����DAO��ͨ��Springע��


	public int getType()
	{
		return type;
	}

	public int getEntityID()
	{
		return entityID;
	}

	public void setEntityID(int entityID)
	{
		this.entityID = entityID;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public float getDiscount()
	{
		return discount;
	}

	public void setDiscount(float discount)
	{
		this.discount = discount;
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
		/**
		 * 1.��ò�ƷID
		 * 2.ͨ����ƷID�����Ʒ��Ӧ��Ψһ��
		 * 3.���ô���Ʒ���ۿ�
		 * 4.�޸Ĵ���Ʒ
		 */
		for(Commodity commodity : commodityDao.findByProductsID(sysAdmin.getProductID(type, entityID)))
		{
			commodity.setDiscount(discount);
			commodityDao.merge(commodity);
		}
		return SUCCESS;
	}

}
