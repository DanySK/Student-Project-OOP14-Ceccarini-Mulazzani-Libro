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
	
	void modifyBook (String title, String author, String[] fields) throws MissingBookException;
	
	void sellBook(Libro book) throws MissingBookException;
	
	Libro searchBook (String title, String author) throws MissingBookException;
	
	Set <Libro> searchBookTitle(String title) throws MissingBookException;
	
	Set <Libro> searchBookAuthor (String author) throws MissingBookException;
	
	Set <Libro> bookList ();
	

}
