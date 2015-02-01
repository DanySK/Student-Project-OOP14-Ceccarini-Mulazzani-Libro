package model;

import java.util.Set;

import exceptions.MissingBookException;

public interface IBookManagement {
	
	void addBook(Libro book);
	
	void sellBook(Libro book) throws MissingBookException;
	
	Libro searchBook(String title) throws MissingBookException;
	
	Set <Libro> bookList ();
	

}
