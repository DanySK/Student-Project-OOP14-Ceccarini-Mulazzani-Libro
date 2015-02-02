package model;

import java.util.ArrayList;
import java.util.List;


public class Statistics {
	
	private IBookManagement elenco = new BookManagement ();
	private List <Libro> library = new ArrayList <>();  

	public Statistics () {
		library.addAll(elenco.bookList());
	}
	
	public List<Libro> mostPopular () {
		library.sort((b1,b2)->b2.getNSales() - b1.getNSales());
		return library;
	}
	
	public List<Libro> lessPopular () {
		library.sort((b1,b2)->b1.getNSales() - b2.getNSales());
		return library;
	}

}
