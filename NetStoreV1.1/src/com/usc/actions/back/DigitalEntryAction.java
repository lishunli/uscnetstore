package com.usc.actions.back;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.daos.ProducttypeDAO;
import com.usc.services.back.IManger;

/**
 * ����¼��
 * @author MZ
 *
 */
public class DigitalEntryAction extends ActionSupport
{
	private Digital digital;//ͼ��,ͨ��Struts2����
	private File upload;//�ϴ���ͼƬ
	private int[] PTypeID;//type�����飬��ȡ����������ѡ���ֵ
	private IManger manger;// �ӿ�ʵ�ֶ���ͨ��Springע��
	private DigitalDAO digitalDao;//ͼ��dao��ͨ��Springע��
	private ProducttypeDAO pTypeDao;//ProducttypeDAO��ͨ��Springע��
	private Products product;//��Ʒ��ͨ��Springע��
	private ProductsDAO pDao;//��ƷDAO��ͨ��Springע��

	/**
	 * �������֤
	productTypeID  //����Ϊ0�����Ϊ0��ʾ��ѡ��
	digitalName //����Ϊ��
	brand //Ʒ�Ʋ���Ϊ��
	barcode ����Ϊ�� �� �̶���ʽ ����Ψһ
	publishedPrice//���� ����Ϊ����Ϊfloat���ͣ������жϣ�
	productsPflag//��ʼʱ����Ϊ0
	upload//ͼƬ���ϴ���һ���Ĵ�С�͸�ʽ���ƣ�����Ϊ�գ������֤��Struts�������ļ���
	 * 
	 */
	
	
	@Override
	public void validate()
	{
		if(null != digital)//��������ֵ��Ϊ��
		{
			if(null == digital.getBarcode() || "".equals(digital.getBarcode().trim()))//������ ����Ϊ�� ����Ψһ    �� �̶���ʽ
			{ 
				this.addFieldError("digital.barcode", "�����벻��Ϊ��");
			}
			else if(manger.checkBarCodeIsExist(digital.getBarcode().trim()))//������ ����Ϊ�� ����Ψһ    �� �̶���ʽ
			{
				this.addFieldError("digital.barcode", "�������Ѵ��ڣ��˲�Ʒ��¼��");
			}
			if(null == digital.getDigitalName() || "".equals(digital.getDigitalName().trim()))//digitalName����Ϊ��
			{
				this.addFieldError("digital.digitalName", "�������Ʋ���Ϊ��");
			}
			if(null == digital.getPublishedPrice())//���۲���Ϊ�գ���ʽͨ��Struts�Ѿ���֤��������Ϣ��message.properties�ļ��У�
			{
				this.addFieldError("digital.publishedPrice", "���۲���Ϊ��");
			}
			if(null == digital.getBrand() || "".equals(digital.getBrand().trim()))//brand Ʒ�Ʋ���Ϊ��
			{
				this.addFieldError("digital.brand", "Ʒ�Ʋ���Ϊ��");
			}
			if(0== PTypeID[0])//û��ѡ�����
			{
				this.addFieldError("PTypeID", "��ѡ�����");
			}
			else if(2 != PTypeID[0])//�����ͱ���2Ϊ���룬Ҳ����ѡ������Ͳ�������Ļ�
			{
				this.addFieldError("PTypeID", "��ѡ���������");
			}
			
		}
	}


	@Override
	public String execute() throws Exception
	{
		if(null != digital)//��������ֵ��Ϊ��
		{
			if(null != upload)
			{
				FileInputStream fin = new FileInputStream(upload);//File ת InputStream
				Blob blob = Hibernate.createBlob(fin);//InputStream ת Blob
				digital.setPhoto(blob);
			}
			int i=0;
			for(;i<PTypeID.length;i++)
			{
				if(PTypeID[i] == 0)//Ϊ0��ʾû�������ˣ�����ǰһ��������С������
					break;
			}
			digital.setProductTypeID(PTypeID[i-1]);//ǰһ��������С������
			digital.setProductsPflag(0);//��ʼʱ����Ϊ0
			digitalDao.save(digital);//¼�����룬ͬʱҪ���Ʒ���в�������
			product.setProductTypeId(PTypeID[0]);//���ò�Ʒ���еĲ�Ʒ����ID��Ϊ������ID
			for(Digital d : digitalDao.findByBarcode(digital.getBarcode().trim()))//ͨ��Barcode�ҵ���digital����ȡdigitalID
			{
				product.setEntityId(d.getDigitalId());//�ѻ�ȡ��digitalID��Ϊʵ��ID���ý�
			}
			pDao.save(product);//����Ϊ��Ʒ
			return SUCCESS;
		}
		return INPUT;
	}
	
	
	public Digital getDigital()
	{
		return digital;
	}

	public void setDigital(Digital digital)
	{
		this.digital = digital;
	}

	public File getUpload()
	{
		return upload;
	}

	public void setUpload(File upload)
	{
		this.upload = upload;
	}

	public int[] getPTypeID()
	{
		return PTypeID;
	}

	public void setPTypeID(int[] typeID)
	{
		PTypeID = typeID;
	}

	public void setManger(IManger manger)
	{
		this.manger = manger;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	public void setPTypeDao(ProducttypeDAO typeDao)
	{
		pTypeDao = typeDao;
	}

	public void setProduct(Products product)
	{
		this.product = product;
	}

	public void setPDao(ProductsDAO dao)
	{
		pDao = dao;
	}

}
