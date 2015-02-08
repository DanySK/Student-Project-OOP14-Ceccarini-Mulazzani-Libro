package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.MissingBookException;

public class BasicOperations implements IBasicOp {

	protected Set<Libro> libreria = new HashSet<Libro>();
	
	public BasicOperations () {
		
	}
	
	public void addBook(Libro book) {
		if (!this.libreria.contains(book)) {
			this.libreria.add(book);
		} 
		this.libreria.forEach(b -> {
			if (b.equals(book)) {
				b.addCopy(book.getNCopy());
			}
		});
	}


	public void modifyBook (Libro book, String[] fields){
		//final Libro book = searchBook(title, author);
		for (int i=0; i <fields.length; i++) {
			if (!fields[i].isEmpty()) {
				switch (i) {
					case 0: 
						book.setTitle(fields[i]); 
						break;
					case 1: 
						book.setAuthor(fields[i]); 
						break;
					case 2: 
						book.setYear(Integer.parseInt(fields[i])); 
						break;
					case 3: 
						book.setEditor(fields[i]); 
						break;
					case 4: 
						book.setISBN(fields[i]); 
						break;
					case 5: 
						book.setPrice(Double.parseDouble(fields[i])); 
						break;
					case 6: 
						book.setNCopy(Integer.parseInt(fields[i])); 
						break;
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
