package com.usc.services.back;

/**
 * ϵͳ����ԱSystem administrator
 * �ṩϵͳ����Ա�Ľӿ�
 * @author MZ
 *
 */
public interface ISystemAdmin
{
	int getProductID(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ò�ƷID
	void setProductPFlag(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID�����ò�Ʒ������־λ
	int getOperatorID(String operatorName);//���ݲ���Ա������Ψһ���ID
	float getDiscount(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ȡ�ۿ�
	float getSalePrice(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ȡ������
	int getPriority(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ȡ���ȼ�
}
