package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.MissingBookException;

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
					b.addCopy();
				}
			});
		}
	}

	public void sellBook(Libro book) throws MissingBookException {
		if (libreria.contains(book)) {
			libreria.forEach(b -> {
				if (b.equals(book)) {
					b.removeCopy();
				}
				if (b.getNCopy() == 0) {
					libreria.remove(book);
				}
			});
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
