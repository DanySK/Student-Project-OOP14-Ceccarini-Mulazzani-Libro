package model;

import java.util.Set;

import exceptions.MissingBookException;

public interface IBasicOp {
	
	void addBook(Libro book);
	
	void modifyBook (String title, String author, String[] fields) throws MissingBookException;

	Libro searchBook (String title, String author) throws MissingBookException;
	
	Set <Libro> bookList ();
}
