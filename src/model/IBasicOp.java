package model;

import java.util.List;
import java.util.Set;

import exceptions.MissingBookException;
/**
 * 
 * @author Chiara Ceccarini
 *
 */

public interface IBasicOp {
	
	/**
	 * 
	 * @param book
	 */
	
	public void addBook(Libro book);
	
	/**
	 * 
	 * @param title
	 * @param author
	 * @param fields
	 * @throws MissingBookException
	 */
	public void modifyBook (Libro book, String[] fields);

	/**
	 * 
	 * @param title
	 * @param author
	 * @return book searched by author and title
	 * @throws MissingBookException
	 */
	public Libro searchBook (String title, String author) throws MissingBookException;
	
	/**
	 * 
	 * @return booklist
	 */
	public List<Libro> bookList ();
}
