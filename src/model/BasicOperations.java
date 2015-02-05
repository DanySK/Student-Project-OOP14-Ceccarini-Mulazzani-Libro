package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.MissingBookException;

public class BasicOperations implements IBasicOp{

	protected Set<Libro> libreria = new HashSet<Libro>();
	
	
	public void addBook(Libro book) {

		if (!this.libreria.contains(book)) {
			this.libreria.add(book);
		} else {
			this.libreria.forEach(b -> {
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

	@Override
	public Libro searchBook(String title, String author)
			throws MissingBookException {

		for (Libro b:this.libreria) {
			if (b.getTitle().equals(title) && b.getAuthor().equals(author)) {
				System.out.println(this.libreria.size());
				return b;
			}
		}
		throw new MissingBookException();	
	}

	@Override
	public Set<Libro> bookList() {
		return new HashSet<Libro>(libreria);	
	}

}
