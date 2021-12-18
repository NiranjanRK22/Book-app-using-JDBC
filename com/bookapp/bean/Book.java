package com.bookapp.bean;
/**
 * This is a Book model class having constructor, getter and setter methods and toString
 * @author NiranjanRamakrishna
 * @version 1.0
 */
public class Book {
	
	String title;
	String author;
	String category;
	int bookId;
	int price;

	/**
	 * 
	 */
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param author
	 * @param category
	 * @param bookid
	 * @param price
	 */
	public Book(String title, String author, String category, int bookId, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookId = bookId;
		this.price = price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookid the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", bookId=" + bookId
				+ ", price=" + price + "]";
	}

}
