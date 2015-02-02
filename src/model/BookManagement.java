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
	
	public void modifyBook (String title, String author, String[] fields) throws MissingBookException {
		final Libro book = searchBook(title, author);
		for (int i=0; i<fields.length; i++) {
			if (!fields[i].isEmpty()) {
				switch (i) {
					case 0: book.setTitle(fields[i]);
					case 1: book.setAuthor(fields[i]);
					case 2: book.setYear(Integer.parseInt(fields[i]));
					case 3: book.setEditor(fields[i]);
					case 4: book.setISBN(fields[i]);
					case 5: book.setPrice(Double.parseDouble(fields[i]));
					case 6: book.setNCopy(Integer.parseInt(fields[i]));
				}
				
			}
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
	
	public Libro searchBook (String title, String author) throws MissingBookException {
		for (Libro b:libreria) {
			if (b.getTitle().equals(title) && b.getAuthor().equals(author)) {
				return b;
			}
		}
		throw new MissingBookException();	
	}
	

	@Override
	public Set <Libro> searchBookTitle(String title) throws MissingBookException {
		final HashSet <Libro> books = new HashSet <> ();
		for (Libro b:libreria) {
			if (b.getTitle().equals(title)) {
				books.add(b);
			}
		}
		if (books.isEmpty()) {
			throw new MissingBookException();
		}
		
		return books;
	}

	@Override
	public Set <Libro> searchBookAuthor(String author) throws MissingBookException {
		final HashSet <Libro> books = new HashSet <> ();
		for (Libro b:libreria) {
			if (b.getAuthor().equals(author)) {
				books.add(b);
			}
		}
		if (books.isEmpty()) {
			throw new MissingBookException();
		}
		
		return books;
	}
	
	public Set <Libro> bookList () {
		return libreria;		
	}
}
