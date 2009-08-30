package com.usc.services.custom;

import java.util.List;

import com.usc.daos.Book;
import com.usc.daos.BookExtra;
import com.usc.daos.Digital;
import com.usc.daos.DigitalExtra;

/**
 * ������ӿ�
 *
 * @author MZ
 *
 * 2009-8-30����10:53:29
 */
public interface IMain {
	List<BookExtra> AdvancedBookSearchCommon(String bookName,String author,String isbn,String publisher);//ͼ��߼�����
	List<BookExtra> AdvancedBookSearchSale(String bookName,String author,String isbn,String publisher);//ͼ��߼�����
	List<DigitalExtra> AdvancedSearchDigitalCommon(String digitalName,String brand);	//����߼�����
	List<DigitalExtra> AdvancedSearchDigitalSale(String digitalName,String brand);	//����߼�����
}
