package com.bookmarks.services;

import com.bookmarks.domain.BookMark;


public interface BookMarkService {
	
	public BookMark getBookMark(long accountID) throws Exception;

}
