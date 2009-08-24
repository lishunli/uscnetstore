package com.usc.services.back.Impl;

import com.usc.daos.BookDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.services.back.IManger;

/**
 * ��̨����Ա�������ֽӿڵ�ʵ��
 * 
 * @author MZ
 * 
 */
public class MangerImpl implements IManger
{
	private OperatorDAO operDao;// ��̨����ԱDAO
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
	 * ������Ա��¼�û�
	 */
	public boolean checkManger(Operator operator)
	{
		// �˹���Ա��������
		if (!operDao.findByOperatorName(operator.getOperatorName().trim())
				.isEmpty())
		{
			// �����������Ĺ���Ա���Ƿ�����ƥ�䣨���������ˣ�
			for (Operator oper : operDao.findByOperatorName(operator
					.getOperatorName().trim()))
			{
				if (oper.getOperatorPass().equals(operator.getOperatorPass()))
					return true;//���������붼��ƥ�䣬������
			}
		}
		return false;
	}

	/**
	 * �޸�����
	 */
	public boolean updatePass(Operator operator, String newPass)
	{
		if (!operDao.findByOperatorName(operator.getOperatorName().trim())
				.isEmpty())
		{
			// �����������Ĺ���Ա���Ƿ�����ƥ�䣨���������ˣ�
			for (Operator oper : operDao.findByOperatorName(operator
					.getOperatorName().trim()))
			{
				if (oper.getOperatorPass().equals(operator.getOperatorPass()))
				{
					operDao.delete(oper);
					operator.setOperatorPass(newPass);
					operator.setOperatorSex(oper.getOperatorSex());
					operator.setOperatorType(oper.getOperatorType());//����operator
					operDao.merge(operator);//�����µ��û�
					return true;//�޸ĳɹ���������
				}
			}
		}
		return false;
	}

}
