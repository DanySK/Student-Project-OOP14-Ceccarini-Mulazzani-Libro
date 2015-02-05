package model;

import java.util.Set;

import exceptions.MissingBookException;


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
	public void modifyBook (String title, String author, String[] fields) throws MissingBookException;

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
	public Set <Libro> bookList ();
}
