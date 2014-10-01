package com.bookmarks.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.bookmarks.domain.BookMark;
import com.bookmarks.services.BookMarkService;
import com.bookmarks.services.BookMarkServiceImpl;

@WebServlet("/bookmark")
public class BookMarkServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		BookMarkService service = new BookMarkServiceImpl();
		BookMark bookmark= null;
		try {
			bookmark = service.getBookMark(Long.valueOf(request.getParameter("accountid")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String complteBookMark = mapper.writeValueAsString(bookmark);
		
		System.out.println(complteBookMark);
		
		response.getWriter().write(complteBookMark);
		response.getWriter().flush();
		response.getWriter().close();
		
		
		
	}

}
