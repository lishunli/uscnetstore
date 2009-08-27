package com.usc.services.back;

import com.usc.daos.Commodity;
import com.usc.daos.Sale;

/**
 * ϵͳ����ԱSystem administrator
 * �ṩϵͳ����Ա�Ľӿ�
 * @author MZ
 *
 */
public interface ISystemAdmin
{
	int getProductID(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ò�ƷID
	int getCommodityID(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID�������ƷID
	void setProductPFlag(int productTypeID,int entityID,int flag);//���ݲ�Ʒ����ID��ʵ��ID�����ò�Ʒ������־λ
	int getOperatorID(String operatorName);//���ݲ���Ա������Ψһ���ID
	float getDiscount(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ȡ�ۿ�
	float getSalePrice(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ȡ������
	int getPriority(int productTypeID,int entityID);//���ݲ�Ʒ����ID��ʵ��ID����ȡ���ȼ�
	void setsaleFlag(int productTypeID,int entityID,int flag);//���ݲ�Ʒ����ID��ʵ��ID��������Ʒ������־λ
	void saveSale(Sale s);//���������Ʒ��Ҫע���ʱ������ȼ����д���
	int getMaxPriority();//����������ȼ�
	void mergeSale(int type,int intentityID,float salePrice,int priority);// ʵ��ID// ���ͣ�1Ϊͼ�飬2Ϊ����// �ۿ�//���ȼ� �޸Ĵ�����
}
