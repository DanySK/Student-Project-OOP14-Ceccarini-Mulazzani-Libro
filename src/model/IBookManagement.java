package model;

import java.util.Set;


import exceptions.MissingBookException;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public interface IBookManagement {
	
	void addBook(Libro book);
	
	void modifyBook (String[] fields);
	
	void sellBook(Libro book) throws MissingBookException;
	
	Libro searchBookTitle(String title) throws MissingBookException;
	
	Libro searchBookAuthor (String author) throws MissingBookException;
	
	Set <Libro> bookList ();
	

}
