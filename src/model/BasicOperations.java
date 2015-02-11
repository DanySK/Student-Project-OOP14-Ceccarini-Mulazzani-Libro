package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.MissingBookException;

public class BasicOperations implements IBasicOp {

	protected List<Libro> libreria = new ArrayList<Libro>();
	
	public BasicOperations () {
		
	}
	
	public void addBook(Libro book) {
		if (!this.libreria.contains(book)) {
			this.libreria.add(book);
		}else {
			this.libreria.forEach(b -> {
				if (b.equals(book)) {
					b.addCopy(book.getNCopy());
				}
			});
		}
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
	public List<Libro> bookList() {
		return new ArrayList<Libro>(libreria);	
	}

	@Override
	public void setList(List<Libro> list) {
		this.libreria = list;
	}
	
	

}
