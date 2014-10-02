package com.bookmark.middele.test;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.bookmarks.domain.BookMark;
import com.bookmarks.services.BookMarkService;




public class BookMarkServiceTest {
	
	BookMark bookMark;
	
	Long accountID = (long) 12345;
	
	@Mock
	BookMarkService bookMarkService;
	
	@Before
	public void before() throws Exception{
		
			bookMark = new BookMark();
			bookMark.setAccountID(12345);
			bookMark.setBookmark("http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm");
			bookMark.setBookmarkID(54321);
			bookMark.setCreationDate(new Date());
			 when(bookMarkService.getBookMark(12345)).thenReturn(bookMark);
			
		 }
	
	@Test
	public void BookMarkserviceTest() throws Exception {
		
		
		BookMark createdBookMark = bookMarkService.getBookMark(accountID);
		
	}
	
	
	
	
		
	}
	


