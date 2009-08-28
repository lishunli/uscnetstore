package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.services.back.ISystemAdmin;

/**
 * �޸Ĵ�����Ʒ�������ۻ����ȼ���
 * 
 * @author MZ
 *
 * 2009-8-28����09:44:12
 */
public class MergeSaleAction extends ActionSupport
{
	private int entityID;// ʵ��ID
	private int type;// ���ͣ�1Ϊͼ�飬2Ϊ����
	private float salePrice;// ������
	private int priority;//���ȼ�
	
	private ISystemAdmin sysAdmin;// ϵͳ����Աʵ��ʵ��������ͨ��Springע��
	
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

	public float getSalePrice()
	{
		return salePrice;
	}

	public void setSalePrice(float salePrice)
	{
		this.salePrice = salePrice;
	}

	public int getPriority()
	{
		return priority;
	}

	public void setPriority(int priority)
	{
		this.priority = priority;
	}

	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}

	@Override
	public String execute() throws Exception
	{
		sysAdmin.mergeSale(type, entityID, salePrice, priority);
		return SUCCESS;
	}

}
