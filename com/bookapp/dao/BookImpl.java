package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter{
       String insertBookQuery = "insert into book values(?,?,?,?,?)";
       String deleteBookQuery = "delete from book where bookid = ?";
       String getBookQuery = "select * from book where bookid = ?";
       String updatePrice = "update book set price=? where bookid=?";
       String getAllBooksQuery = "Select * from book";
       String getBookByAuthorQuery = "select * from book where author=?";
       String getBookByCategoryQuery = "select * from book where category=?";
       
	@Override
	public void addBook(Book book) {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insertBookQuery);
			st.setString(1, book.getTitle());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getCategory());
			st.setInt(4, book.getBookid());
			st.setInt(5, book.getPrice());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		st.execute();
		
	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try  {
			st = connection.prepareStatement(deleteBookQuery);
			st.setInt(1, bookid);
			st.execute();
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try  {
			st = connection.prepareStatement(getBookQuery);
			st.setInt(1, bookid);
			ResultSet rs = st.executeQuery();
			if (rs != null) {
			while (rs.next())  {
				String title = rs.getString(1);
				String author = rs.getString(2);
				String category = rs.getString(3);
				String bookId = rs.getString(4);
				String price = rs.getString(5);
				System.out.println(title + "\t" + author + "\t" + category + "\t" + bookId + "\t" + price);
			}
			rs.close();
		}
			else {
		          throw new BookNotFoundException();
			}
		}
		catch (SQLException e)  {
			
		}
		return null;
	}

	@Override
	public boolean updateBook(int bookid, int price) {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(updatePrice);
	        st.setInt(1, price);
	        st.setInt(2, bookid);
	        st.execute();
	        st.close();
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
        
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try  {
			st = connection.prepareStatement(getAllBooksQuery);
			ResultSet rs = st.executeQuery();
			while (rs.next())  {
				String title = rs.getString(1);
				String author = rs.getString(2);
				String category = rs.getString(3);
				String bookId = rs.getString(4);
				String price = rs.getString(5);
				System.out.println(title + "\t" + author + "\t" + category + "\t" + bookId + "\t" + price);
			}
			rs.close();
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try  {
			st = connection.prepareStatement(getBookByAuthorQuery);
			st.setString(1, author);
			ResultSet rs = st.executeQuery();
			if (rs != null) {
			while (rs.next())  {
				String title = rs.getString(1);
				String bookAuthor = rs.getString(2);
				String category = rs.getString(3);
				String bookId = rs.getString(4);
				String price = rs.getString(5);
				System.out.println(title + "\t" + bookAuthor + "\t" + category + "\t" + bookId + "\t" + price);
			}
			rs.close();
		}
			else {
		          throw new AuthorNotFoundException();
			}
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		try  {
			st = connection.prepareStatement(getBookByCategoryQuery);
			st.setString(1, category);
			ResultSet rs = st.executeQuery();
			if (rs != null) {
			while (rs.next())  {
				String title = rs.getString(1);
				String author = rs.getString(2);
				String bookCategory = rs.getString(3);
				String bookId = rs.getString(4);
				String price = rs.getString(5);
				System.out.println(title + "\t" + author + "\t" + bookCategory + "\t" + bookId + "\t" + price);
			}
			rs.close();
		}
			else {
		          throw new CategoryNotFoundException();
			}
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		return null;
	}

}
