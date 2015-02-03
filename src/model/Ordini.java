package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.MissingBookException;

public class Ordini extends BookManagement implements IOrdini {
	
	private HashSet <Libro> ordini = new HashSet <>(); 
	private IBookManagement lista = new BookManagement ();
	
	public Ordini () {
		
	}

	@Override
	public void addBook(Libro book) {
		super.addBook(book);
	}

	@Override
	public void modifyBook(String title, String author, String[] fields)
			throws MissingBookException {
		super.modifyBook(title, author, fields);
		
	}

	@Override
	public Libro searchBook(String title, String author)
			throws MissingBookException {
		super.searchBook(title, author);
		return null;
	}

	@Override
	public Set<Libro> bookList() {
		return super.bookList();
	}

	public void evasioneOrdini() {
		for (Libro b:this.ordini) {
			System.out.println ("evasione");
			lista.addBook(b);
		}
		System.out.println ("clear "+ordini.size());
		this.ordini.clear();
		System.out.println ("clear "+ordini.size());
	}

}
