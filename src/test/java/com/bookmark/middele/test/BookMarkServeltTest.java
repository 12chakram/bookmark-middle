package com.bookmark.middele.test;



import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.bookmark.middele.util.TestConnection;
import com.bookmarks.servlet.BookMarkServlet;
import com.bookmarks.util.ConnectionFactory;

public class BookMarkServeltTest {

	@Mock
	Connection connection;
	
	@Mock
	ConnectionFactory connectionFactory;
	
	@Before
	 public void openDbConnection(){
		 
		try {
			connection = TestConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	
	
	 @Test
	    public void testServlet() throws Exception {
		 
		  BookMarkServlet servlet =  new BookMarkServlet(); 
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    
	          connectionFactory = mock(ConnectionFactory.class);
	        when(request.getParameter("accountid")).thenReturn("12345");
	        PrintWriter writer = new PrintWriter("somefile.txt");
	        when(response.getWriter()).thenReturn(writer);
	        when(connectionFactory.getConnection()).thenReturn(connection);

	        servlet.doGet(request,response);

	        verify(request, atLeast(1)).getParameter("accountid"); // only if you want to verify username was called...
	        writer.flush(); // it may not have been flushed yet...
	        
	       
	    }

}
