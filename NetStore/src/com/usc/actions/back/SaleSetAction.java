package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * ����Ϊ������Ʒ
 * @author MZ
 *
 */
public class SaleSetAction extends ActionSupport
{
	private int entityID;// ʵ��ID
	private int type;// ���ͣ�1Ϊͼ�飬2Ϊ����
	private float salePrice;// ������
	private int priority;//���ȼ�
	
	private ISystemAdmin sysAdmin;// ϵͳ����Աʵ��ʵ��������ͨ��Springע��
	private Commodity commodity;// ��Ʒ����ͨ��Springע��
	private CommodityDAO commodityDao;// ��Ʒ����DAO��ͨ��Springע��
	private Sale sale;//������Ʒ����ͨ��Springע��
	private SaleDAO saleDao;//������Ʒ����DAO��ͨ��Springע��
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
	public int getPriority()
	{
		return priority;
	}
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	public Sale getSale()
	{
		return sale;
	}
	public void setSale(Sale sale)
	{
		this.sale = sale;
	}
	public void setSalePrice(float salePrice)
	{
		this.salePrice = salePrice;
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
	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}
	
	@Override
	public String execute() throws Exception
	{
		//1.�������־λ
		//2.д�˵���������
		sysAdmin.setsaleFlag(type, entityID, 1);
		sale.setCommodityId(sysAdmin.getCommodityID(type, entityID));
		sale.setOperatorID(sysAdmin.getOperatorID(ActionContext.getContext().getSession().get("manger").toString()));
		sale.setSalePrice(salePrice);
		sale.setPriority(priority);
		sysAdmin.saveSale(sale);
		return SUCCESS;
	}
	
}
