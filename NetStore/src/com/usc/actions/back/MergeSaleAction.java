package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.services.back.ISystemAdmin;

/**
 * �޸Ĵ�����Ʒ�������ۻ����ȼ���
 * @author MZ
 *
 */
public class MergeSaleAction extends ActionSupport
{
	private int entityID;// ʵ��ID
	private int type;// ���ͣ�1Ϊͼ�飬2Ϊ����
	private float salePrice;// ������
	private int priority;//���ȼ�
	
	private ISystemAdmin sysAdmin;// ϵͳ����Աʵ��ʵ��������ͨ��Springע��
	
	@Override
	public String execute() throws Exception
	{
		sysAdmin.mergeSale(type, entityID, salePrice, priority);
		return SUCCESS;
	}

}
