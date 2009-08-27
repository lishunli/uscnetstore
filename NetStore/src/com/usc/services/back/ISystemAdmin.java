package com.usc.services.back;

import com.usc.daos.Commodity;
import com.usc.daos.Sale;

/**
 * 系统管理员System administrator
 * 提供系统管理员的接口
 * @author MZ
 *
 */
public interface ISystemAdmin
{
	int getProductID(int productTypeID,int entityID);//根据产品类型ID和实物ID来获得产品ID
	int getCommodityID(int productTypeID,int entityID);//根据产品类型ID和实物ID来获得商品ID
	void setProductPFlag(int productTypeID,int entityID,int flag);//根据产品类型ID和实物ID来设置产品发布标志位
	int getOperatorID(String operatorName);//根据操作员姓名来唯一获得ID
	float getDiscount(int productTypeID,int entityID);//根据产品类型ID和实物ID来获取折扣
	float getSalePrice(int productTypeID,int entityID);//根据产品类型ID和实物ID来获取促销价
	int getPriority(int productTypeID,int entityID);//根据产品类型ID和实物ID来获取优先级
	void setsaleFlag(int productTypeID,int entityID,int flag);//根据产品类型ID和实物ID来设置商品促销标志位
	void saveSale(Sale s);//保存促销商品，要注意此时会对优先级进行处理
	int getMaxPriority();//获得最大的优先级
}
