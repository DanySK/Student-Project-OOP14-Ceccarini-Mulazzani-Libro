package model;

import java.util.HashSet;

import java.util.Set;

import exceptions.MissingBookException;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public class BookManagement implements IBookManagement{
	
	private HashSet <Libro> libreria = new HashSet <>(); 

	public BookManagement() {

	}

	public void addBook(Libro book) {
		if (!libreria.contains(book)) {
			libreria.add(book);
		} else {
			libreria.forEach(b -> {
				if (b.equals(book)) {
					b.addCopy(book.getNCopy());
				}
			});
		}
	}

	public void sellBook(Libro book) throws MissingBookException {
		if (libreria.contains(book)) {
			for (Libro b:libreria) {
				if (b.equals(book) && b.getNCopy() > 0) {
					b.removeCopy();
				} else {
					throw new MissingBookException();
				}
			}
		} else {
			throw new MissingBookException();
		}
		
	}

	public Libro searchBook(String title) throws MissingBookException {
		for (Libro b:libreria) {
			if (b.getTitle().equals(title)) {
				return b;
			}
		}
		throw new MissingBookException();
	}
	
	public Set <Libro> bookList () {
		return libreria;
		
	}
}
