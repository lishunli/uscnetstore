package com.usc.services.custom.Impl;

import java.util.List;

import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.services.custom.IMain;

public class MainImpl implements IMain {

	private BookDAO bookdao;
	
	private DigitalDAO digitaldao;
	
/*	public List<Book> FuzzySearchBooks(String fuzzy) {
		
		return bookdao.FuzzySearchBooks(fuzzy);
	}

	public List<Digital> FuzzySearchDigitals(String fuzzy) {
		
		return digitaldao.FuzzySearchDigitals(fuzzy);
	}*/

	public BookDAO getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookDAO bookdao) {
		this.bookdao = bookdao;
	}

	public DigitalDAO getDigitaldao() {
		return digitaldao;
	}

	public void setDigitaldao(DigitalDAO digitaldao) {
		this.digitaldao = digitaldao;
	}

}
