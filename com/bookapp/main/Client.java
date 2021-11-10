package com.bookapp.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.bookapp.dao.ModelDAO;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;

public class Client {

	public static void main(String[] args) throws AuthorNotFoundException, BookNotFoundException, CategoryNotFoundException {
		//String createtablequery = "create table book(title varchar(20), author varchar(20), category varchar(20), bookid integer, price integer)";
		Properties properties = new Properties();
		try  {
			properties.load(new FileReader("jdbc.properties"));
		}
		catch (FileNotFoundException e1)  {
			e1.printStackTrace();
		}
		catch (IOException e1)  {
			e1.printStackTrace();
		}
//		String url = (String)properties.getProperty("driver");
//		String username = (String)properties.getProperty("username");
//		String password = (String)properties.getProperty("password");
		//String sql = "create table student(studname varchar(20), studid integer, age integer)";
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try  {
//        	Class.forName("com.mysql.jdbc.Driver").newInstance();
//        	connection = DriverManager.getConnection(url, username, password);
//            statement = connection.prepareStatement(createtablequery);
//            statement.execute();
//        	
//        }
//        catch(InstantiationException | IllegalAccessException | ClassNotFoundException e)  {
//        	e.printStackTrace();
//        }
//        catch (SQLException e) {
//        	e.printStackTrace();
//        }
//        finally  {
//        	try {
//        		if (statement != null)
//        		statement.close();
//        		if (connection != null)
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//        }
          
        BookInter bookInter = new BookImpl();
        Scanner sc = new Scanner(System.in);
//        for (int i=0; i<5; i++)  {
//        	Book book = new Book();
//            System.out.println("Enter title: ");
//            String title = sc.next();
//            book.setTitle(title);
//            System.out.println("Enter author: ");
//            String author = sc.next();
//            book.setAuthor(author);
//            System.out.println("Enter category: ");
//            String category = sc.next();
//            book.setCategory(category);
//            System.out.println("Enter book id: ");
//            int bookId = sc.nextInt();
//            book.setBookid(bookId);
//            System.out.println("Enter price: ");
//            int price = sc.nextInt();
//            book.setPrice(price);
//            bookInter.addBook(book);
//        }
        //System.out.println("Enter the Book id to delete the record: ");
        //int bookIdToDelete = sc.nextInt();
       //bookInter.deleteBook(bookIdToDelete);
        
//        System.out.println("Enter the Book Id: ");
//        int bookId = sc.nextInt();
//        bookInter.getBookById(bookId);
          
//        System.out.println("Enter the Book id to update: ");
//        int bookIdToUpdate = sc.nextInt();
//        System.out.println("Enter the price");
//        int price = sc.nextInt();
//        bookInter.updateBook(bookIdToUpdate, price);
       bookInter.getAllBooks();
	}

}
