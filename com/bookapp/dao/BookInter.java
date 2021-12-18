/*Author : Niranjan
version : 1.0
date: 10/11/2021*/

package com.bookapp.dao;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public interface BookInter {
	        //called by admin
			void addBook(Book book);
			boolean deleteBook(int bookId) throws BookNotFoundException;
			Book getBookById(int bookId) throws BookNotFoundException;
			void updateBook(int bookId,int price) throws BookNotFoundException;
			
			// called by customer
			List<Book> getAllBooks();
			List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException;;
			List<Book> getBookbycategory(String category)throws CategoryNotFoundException;;
}
