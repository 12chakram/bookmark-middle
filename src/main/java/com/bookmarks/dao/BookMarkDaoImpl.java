package com.bookmarks.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.bookmarks.domain.BookMark;
import com.bookmarks.util.ConnectionFactory;

public class BookMarkDaoImpl implements BookMarkDao{

	Connection connection =null;
	 Statement statement = null;
	
	
	@Override
	public BookMark getbookMark(long bookMarkID) throws Exception {
		// TODO Auto-generated method stub
		try{
			connection = ConnectionFactory.getConnection();
		}catch(Exception exception){
			throw exception;
		}
		
		statement = connection.createStatement();
	      String sql = "SELECT accountID, bookmarkID, creationDate, bookmark FROM BOOKMARKS";
	      ResultSet rs = statement.executeQuery(sql);
		
	      //Set into BookMark Object values
          BookMark bookMark = new BookMark();
          
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         long accountID  = rs.getInt("accountID");
	         long bookmarkID = rs.getInt("bookmarkID");
	         Date creationDate = rs.getDate("creationDate");
	         String completebookmark = rs.getString("bookmark");

	          bookMark.setAccountID(accountID);
	          bookMark.setBookmarkID(bookmarkID);
	          bookMark.setCreationDate(creationDate);
	          bookMark.setBookmark(completebookmark);
	      }
		return bookMark;
		
	}

}
