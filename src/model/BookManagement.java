package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import exceptions.MissingBookException;
import exceptions.NotEnoughBookException;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public class BookManagement extends BasicOperations implements IBookManagement, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2040899298874774142L;
	private HashSet <Libro> libreria = new HashSet <>();

	public BookManagement() {

	}

	public void sellBook(Libro book, int nCopy) throws MissingBookException, NotEnoughBookException {
		
		if (!this.libreria.contains(book)){
			throw new MissingBookException();
		}
		
		for (Libro b: this.libreria){
			if (b.equals(book)){
				if (b.getNCopy() < nCopy){
					throw new NotEnoughBookException();
				}else {
					b.removeCopy(nCopy);
				}	
			}
		}
	}
	

	@Override
	public Set <Libro> searchBookTitle(String title) throws MissingBookException {
		final HashSet <Libro> books = new HashSet <> ();
		for (Libro b:this.libreria) {
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
		for (Libro b:this.libreria) {
			if (b.getAuthor().equals(author)) {
				books.add(b);
			}
		}
		if (books.isEmpty()) {
			throw new MissingBookException();
		}
		
		return books;
	}
}
