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
/*Author : Niranjan
version : 1.0
date: 10/11/2021*/

public class Client {

	public static void main(String[] args)
			throws AuthorNotFoundException, BookNotFoundException, CategoryNotFoundException {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("jdbc.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Select the operation to be performed");
		System.out.println(
				"1: Add Book 2.Update Book 3.Delete Book 4.View Book by id 5. View all the books 6. View Books by author 7.View books by category");
		int choice = sc.nextInt();
		BookInter bookInter = new BookImpl();
		switch (choice) {
		case 1:
			for (int i = 0; i < 2; i++) {
				Book book = new Book();
				System.out.println("Enter title: ");
				String title = sc.next();
				book.setTitle(title);
				System.out.println("Enter author: ");
				String author = sc.next();
				book.setAuthor(author);
				System.out.println("Enter category: ");
				String category = sc.next();
				book.setCategory(category);
				System.out.println("Enter book id: ");
				int bookId = sc.nextInt();
				book.setBookId(bookId);
				System.out.println("Enter price: ");
				int price = sc.nextInt();
				book.setPrice(price);
				bookInter.addBook(book);
			}
			System.out.println("Book added successfully");
			break;
		case 2:
			try {
				System.out.println("Enter the Book id to update: ");
				int bookIdToUpdate = sc.nextInt();
				System.out.println("Enter the price");
				int price = sc.nextInt();
				bookInter.updateBook(bookIdToUpdate, price);
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;

		case 3:
			try {
				System.out.println("Enter the Book id to delete the record: ");
				int bookIdToDelete = sc.nextInt();
				bookInter.deleteBook(bookIdToDelete);
				System.out.println("Book deleted successfully");
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				System.out.println("Enter the Book Id: ");
				int bookId = sc.nextInt();
				System.out.println(bookInter.getBookById(bookId));
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			bookInter.getAllBooks().forEach(System.out::println);
			break;
		case 6:
			try {
				System.out.println("Enter author: ");
				String author = sc.next();
				bookInter.getBookbyAuthor(author).forEach(System.out::println);
			} catch (AuthorNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 7:
			try {
				System.out.println("Enter category: ");
				String category = sc.next();
				bookInter.getBookbycategory(category).forEach(System.out::println);
			} catch (CategoryNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

		sc.close();

	}

}
