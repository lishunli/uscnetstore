package com.usc.services.back;

/**
 * 系统管理员System administrator
 * 提供系统管理员的接口
 * @author MZ
 *
 */
public interface ISystemAdmin
{
	int getProductID(int productTypeID,int entityID);//根据产品类型ID和实物ID来获得产品ID
	void setProductPFlag(int productTypeID,int entityID);//根据产品类型ID和实物ID来设置产品发布标志位
	int getOperatorID(String operatorName);//根据操作员姓名来唯一获得ID
	float getDiscount(int productTypeID,int entityID);//根据产品类型ID和实物ID来获取折扣
	float getSalePrice(int productTypeID,int entityID);//根据产品类型ID和实物ID来获取促销价
	int getPriority(int productTypeID,int entityID);//根据产品类型ID和实物ID来获取优先级
}
