package com.usc.services.back;

import java.util.List;

import com.usc.daos.Operator;

/**
 * ��̨����Ա�������ֽӿ�
 * @author MZ
 *
 */
public interface IManger
{
	boolean checkManger(Operator operator);//������Ա��¼�û�
	boolean updatePass(Operator operator,String newPass);//�޸�����
	boolean checkIsbnIsExist(String  isbn);//��ͼ������ISBNΨһ����֤
	boolean checkBarCodeIsExist(String barcode);//����������������Ψһ����֤
}
