package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		Connection connection = ModelDAO.openConnection(); //to get the connection object
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertBookQuery); //this returns prepared statement object
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setInt(4, book.getBookId());
			statement.setInt(5, book.getPrice());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();
		}		
				
	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try  {
			statement = connection.prepareStatement(deleteBookQuery);
			statement.setInt(1, bookid);
			int count = statement.executeUpdate();
			if (count == 0)
				throw new BookNotFoundException("Book not found with this id");
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();
		}
		return true;
	}

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		Book book = null;
		try  {
			statement = connection.prepareStatement(getBookQuery);
			statement.setInt(1, bookId);
			ResultSet rs = statement.executeQuery();
			if (rs != null) {
			while (rs.next())  {
				book = new Book();
				book.setBookId(rs.getInt("bookid"));
			    book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getInt("price"));
			}
			
			if (book == null)  {
				throw new BookNotFoundException("Book not found with this id");
			}
	
		}
		}
		catch (SQLException e)  {
			
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return book;
	}

	@Override
	public void updateBook(int bookId, int price) throws BookNotFoundException{
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updatePrice);
			statement.setInt(1, price);
			statement.setInt(2, bookId);
			int count = statement.executeUpdate();
			if (count == 0)  {
				throw new BookNotFoundException("Book not found with this id");
			}
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)  {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}
		}	
	}

	@Override
	public List<Book> getAllBooks() {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try  {
			statement = connection.prepareStatement(getAllBooksQuery);
			ResultSet rs = statement.executeQuery();
			while (rs.next())  {
				String title = rs.getString(1);
				String author = rs.getString(2);
				String category = rs.getString(3);
				int bookId = rs.getInt(4);
				int price = rs.getInt(5);
				Book book = new Book(title, author, category, bookId, price);
				bookList.add(book);
			}
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();
		}
		return bookList;
	}

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try  {
			statement = connection.prepareStatement(getBookByAuthorQuery);
			statement.setString(1, author);
			ResultSet rs = statement.executeQuery();
			while (rs.next())  {
				String title = rs.getString(1);
				String bookAuthor = rs.getString(2);
				String category = rs.getString(3);
				int bookId = rs.getInt(4);
				int price = rs.getInt(5);
				Book book = new Book(title, bookAuthor, category, bookId, price);
				bookList.add(book);
			}
	        if (bookList.isEmpty())  {
	        	throw new AuthorNotFoundException("Book not found with this author name");
	        }
			
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return bookList;
	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try  {
			statement = connection.prepareStatement(getBookByCategoryQuery);
			statement.setString(1, category);
			ResultSet rs = statement.executeQuery();
			while (rs.next())  {
				String title = rs.getString(1);
				String author = rs.getString(2);
				String bookCategory = rs.getString(3);
				int bookId = rs.getInt(4);
				int price = rs.getInt(5);
				Book book = new Book(title, author, bookCategory, bookId, price);
				bookList.add(book);
			}
			if (bookList.isEmpty())  {
				throw new CategoryNotFoundException("Book not found of this category");
			}
		}
		catch (SQLException e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return bookList;
	}

}
