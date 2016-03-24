package com.jersey.series.spring.hibernate.service;

import in.benchresources.cdm.book.BookListType;
import in.benchresources.cdm.book.BookType;

public interface BookService {

	// Basic CRUD operations for Book Service

	public String createOrSaveBookInfo(BookType bookType);
	public BookType getBookInfo(int bookId);
	public String updateBookInfo(BookType bookType);
	public String deleteBookInfo(int bookId);
	public BookListType getAllBookInfo();
}