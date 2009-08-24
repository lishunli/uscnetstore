package com.usc.services.back.Impl;

import com.usc.daos.BookDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.services.back.IManger;

/**
 * 后台管理员公共部分接口的实现
 * 
 * @author MZ
 * 
 */
public class MangerImpl implements IManger
{
	private OperatorDAO operDao;// 后台管理员DAO
	private BookDAO bookDao;
	
	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setOperDao(OperatorDAO operDao)
	{
		this.operDao = operDao;
	}

	/**
	 * 检查管理员登录用户
	 */
	public boolean checkManger(Operator operator)
	{
		// 此管理员姓名存在
		if (!operDao.findByOperatorName(operator.getOperatorName().trim())
				.isEmpty())
		{
			// 遍历此姓名的管理员，是否密码匹配（重名现象了）
			for (Operator oper : operDao.findByOperatorName(operator
					.getOperatorName().trim()))
			{
				if (oper.getOperatorPass().equals(operator.getOperatorPass()))
					return true;//姓名和密码都能匹配，返回真
			}
		}
		return false;
	}

	/**
	 * 修改密码
	 */
	public boolean updatePass(Operator operator, String newPass)
	{
		if (!operDao.findByOperatorName(operator.getOperatorName().trim())
				.isEmpty())
		{
			// 遍历此姓名的管理员，是否密码匹配（重名现象了）
			for (Operator oper : operDao.findByOperatorName(operator
					.getOperatorName().trim()))
			{
				if (oper.getOperatorPass().equals(operator.getOperatorPass()))
				{
					operDao.delete(oper);
					operator.setOperatorPass(newPass);
					operator.setOperatorSex(oper.getOperatorSex());
					operator.setOperatorType(oper.getOperatorType());//设置operator
					operDao.merge(operator);//插入新的用户
					return true;//修改成功，返回真
				}
			}
		}
		return false;
	}

}
