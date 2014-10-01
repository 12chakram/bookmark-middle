package com.bookmark.middele.test;



import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.junit.Test;

import com.bookmarks.servlet.BookMarkServlet;

public class BookMarkServeltTest {
	
	 @Test
	    public void testServlet() throws Exception {
		 
		  BookMarkServlet servlet =  new BookMarkServlet(); 
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    
	        
	        when(request.getParameter("accountid")).thenReturn("12345");
	        PrintWriter writer = new PrintWriter("somefile.txt");
	        when(response.getWriter()).thenReturn(writer);

	        servlet.doGet(request,response);

	        verify(request, atLeast(1)).getParameter("accountid"); // only if you want to verify username was called...
	        writer.flush(); // it may not have been flushed yet...
	        
	        JSONObject store = new JSONObject(response); 
	         
	        System.out.println(store.get("bookmark"));
	       
	    }

}
