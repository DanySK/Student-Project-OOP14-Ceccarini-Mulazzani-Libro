package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Statistics {
	
	private IBookManagement elenco = new BookManagement ();
	private List <Libro> library = new ArrayList <>();  

	public Statistics () {
		library.addAll(elenco.bookList());
	}
	
	public List<Libro> mostPopularBook () {
		library.sort((b1,b2)->b2.getNSales() - b1.getNSales());
		return library;
	}
	
	public List<Libro> lessPopularBook () {
		library.sort((b1,b2)->b1.getNSales() - b2.getNSales());
		return library;
	}
	
	public Map <String, Integer> mostPopularAuthor () {
		final Map <String, Integer> authors = new TreeMap <>();
		
		return authors;
	}

}
