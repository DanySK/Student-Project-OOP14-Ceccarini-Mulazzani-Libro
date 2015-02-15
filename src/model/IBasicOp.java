package model;

import java.util.List;

import exceptions.MissingBookException;
/**
 * 
 * @author Chiara Ceccarini
 *
 */

public interface IBasicOp {
	
	/**
	 * 
	 * @param book, book to add in the library
	 */
	
	void addBook(Libro book);
	
	/**
	 * 
	 * @param title of the book
	 * @param author of the book
	 * @param fields are the new fields of the book
	 * @throws MissingBookException if book is not in the library
	 */
	void modifyBook (Libro book, String... fields);

	/**
	 * 
	 * @param title of book
	 * @param author of book
	 * @return book searched by author and title
	 * @throws MissingBookException if book is not in the library
	 */
	Libro searchBook (String title, String author) throws MissingBookException;
	
	/**
	 * 
	 * @return booklist of the library
	 */
	List<Libro> bookList ();
	
	
	void setList(List<Libro> list);
}
