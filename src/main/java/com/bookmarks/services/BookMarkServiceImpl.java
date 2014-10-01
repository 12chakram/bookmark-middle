package com.bookmarks.services;

import com.bookmarks.dao.BookMarkDao;
import com.bookmarks.dao.BookMarkDaoImpl;
import com.bookmarks.domain.BookMark;


public class BookMarkServiceImpl implements BookMarkService {

	@Override
	public BookMark getBookMark(long accountID) throws Exception {
		BookMarkDao bookmarkdao = new BookMarkDaoImpl();
		// TODO Auto-generated method stub
		return bookmarkdao.getbookMark(accountID);
	}}
