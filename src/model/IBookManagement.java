package model;

import java.util.Set;

import exceptions.MissingBookException;
import exceptions.NotEnoughBookException;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public interface IBookManagement extends IBasicOp{
	
	//void addBook(Libro book);
	
	//void modifyBook (String title, String author, String[] fields) throws MissingBookException;
	
	void sellBook(Libro book, int nCopy) throws MissingBookException, NotEnoughBookException;
	
	//Libro searchBook (String title, String author) throws MissingBookException;
	
	Set <Libro> searchBookTitle(String title) throws MissingBookException;
	
	Set <Libro> searchBookAuthor (String author) throws MissingBookException;
	
	//Set <Libro> bookList ();
	

}
