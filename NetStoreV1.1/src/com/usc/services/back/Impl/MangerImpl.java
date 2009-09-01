package com.usc.services.back.Impl;

import com.usc.daos.BookDAO;
import com.usc.daos.DigitalDAO;
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
	private DigitalDAO digitalDAO;

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setOperDao(OperatorDAO operDao)
	{
		this.operDao = operDao;
	}

	public void setDigitalDAO(DigitalDAO digitalDAO)
	{
		this.digitalDAO = digitalDAO;
	}

	/**
	 * ������Ա��¼�û�
	 */
	public boolean checkManger(Operator operator)
	{
		// �˹���Ա��������
		// �����������Ĺ���Ա���Ƿ�����ƥ�䣨���������ˣ�
		for (Operator oper : operDao.findByOperatorName(operator
				.getOperatorName().trim()))
		{
			if (oper.getOperatorPass().equals(operator.getOperatorPass()))
				return true;// ���������붼��ƥ�䣬������
		}
		return false;
	}

	/**
	 * �޸�����
	 */
	public boolean updatePass(Operator operator, String newPass)
	{

		// �����������Ĺ���Ա���Ƿ�����ƥ�䣨���������ˣ�
		for (Operator oper : operDao.findByOperatorName(operator
				.getOperatorName().trim()))
		{
			if (oper.getOperatorPass().equals(operator.getOperatorPass()))
			{
				oper.setOperatorPass(newPass);// ����������
				operDao.merge(oper);// �޸�
				return true;// �޸ĳɹ���������
			}
		}

		return false;
	}

	/**
	 * ��ͼ������ISBNΨһ����֤
	 */
	public boolean checkIsbnIsExist(String isbn)
	{
		if (!bookDao.findByIsbn(isbn).isEmpty())// ������Ҳ��Ψһ��������
			return true;
		return false;
	}

	/**
	 * ����������������Ψһ����֤
	 */
	public boolean checkBarCodeIsExist(String barcode)
	{
		if (!digitalDAO.findByBarcode(barcode).isEmpty())// ������Ҳ��Ψһ��������
			return true;
		return false;
	}

}
