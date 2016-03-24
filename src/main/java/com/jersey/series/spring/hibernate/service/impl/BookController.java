package com.jersey.series.spring.hibernate.service.impl;

import in.benchresources.cdm.book.BookListType;
import in.benchresources.cdm.book.BookType;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jersey.series.spring.hibernate.dao.service.BookDAO;
import com.jersey.series.spring.hibernate.model.Book;
import com.jersey.series.spring.hibernate.service.BookService;

@Controller
@Path("/bookservice")
public class BookController implements BookService {

	@Autowired
	private BookDAO bookDAO;

	// Basic CRUD operations for Book Service

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/addbook
	@POST
	@Path("addbook")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public String createOrSaveBookInfo(BookType bookType) {

		// unwrap bookType and set in Model object Book
		Book newBook = new Book();
		newBook.setBookId(bookType.getBookId());
		newBook.setBookName(bookType.getBookName());
		newBook.setAuthor(bookType.getAuthor());
		newBook.setCategory(bookType.getCategory());
		return bookDAO.insertNewBookInfo(newBook);
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/getbook/1
	@GET
	@Path("getbook/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BookType getBookInfo(@PathParam("id") int bookId) {

		// retrieve book information based on the id supplied in the formal argument
		Book getBook = bookDAO.getBookInfo(bookId);

		BookType bookType = new BookType();
		bookType.setBookId(getBook.getBookId());
		bookType.setBookName(getBook.getBookName());
		bookType.setAuthor(getBook.getAuthor());
		bookType.setCategory(getBook.getCategory());
		return bookType;
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/updatebook
	@PUT
	@Path("updatebook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateBookInfo(BookType bookType) {

		// unwrap bookType and set in Model object Book
		Book modifyBook = new Book();
		modifyBook.setBookId(bookType.getBookId());
		modifyBook.setBookName(bookType.getBookName());
		modifyBook.setAuthor(bookType.getAuthor());
		modifyBook.setCategory(bookType.getCategory());

		// update book info & return SUCCESS message
		return bookDAO.updateBookInfo(modifyBook);
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/deletebook/5
	@DELETE
	@Path("deletebook/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteBookInfo(@PathParam("id") int bookId) {

		// delete book info & return SUCCESS message
		Book removeBook = new Book();
		removeBook.setBookId(bookId);
		return bookDAO.removeBookInfo(removeBook);
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/getallbook
	@GET
	@Path("getallbook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BookListType getAllBookInfo() {

		List<Book> lstBook = bookDAO.getAllBookInfo();

		// create a object of type BookListType which takes book objects in its list
		BookListType bookListType = new BookListType();

		for(Book book : lstBook){
			BookType bookType = new BookType();
			bookType.setBookId(book.getBookId());
			bookType.setBookName(book.getBookName());
			bookType.setAuthor(book.getAuthor());
			bookType.setCategory(book.getCategory());
			bookListType.getBookType().add(bookType); // add to bookListType
		}
		return bookListType;
	}
}