package com.usc.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * ������Hibernate��ORӳ���ļ������ɱ�
 * @author Administrator
 *
 */
public class CreateDB {
	/**
	 * ����Hibernate�����ļ���ӳ���ļ�������Ӧ���ݿ������ɱ�
	 */
	public void createTable() {
		try {
			System.out.println("��ʼ�����ݿ�ʼ......");
			// ��ȡhibernate.cfg.xml�ļ���
			// ������.configure()ʱ��Ĭ�϶�ȡhibernate.properties�����ļ�
			Configuration cfg = new Configuration().configure();

			// ���������У��������� oracle_sid = test�����ܳɹ���

			// һ�����࣬ ����hibernate.cfg.xml�ж���ı�
			SchemaExport export = new SchemaExport(cfg);
			export.create(true, true); // ����ڶ�������Ϊtrue�Ļ������ԭ���ı�ɾ���ؽ���

			System.out.println("��ʼ�����ݿ�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CreateDB db = new CreateDB();
		db.createTable();

	}

}
