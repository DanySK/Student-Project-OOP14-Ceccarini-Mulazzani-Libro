package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utilities.Pair;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public class Statistics implements IStatistics{
	
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
	
	public List <Pair <String,Integer>> mostActiveAuthor () {
		final List <Pair<String, Integer>> lista = createList();
		
		Collections.sort(lista, (p1,p2) -> p2.getSecond()-p1.getSecond());
		
		return lista;
	}
	
	public List <Pair <String,Integer>> lessActiveAuthor () {
		final List <Pair<String, Integer>> lista = createList();
		
		Collections.sort(lista, (p1,p2) -> p1.getSecond()-p2.getSecond());
		
		return lista;
	}
	
	private List <Pair <String,Integer>> createList () {
		final List <Pair<String, Integer>> lista = new ArrayList <>();
		boolean find = false;
		int i = 0;
		for (Libro b:library) {
			for (Pair<String, Integer> l:lista) {
				if (l.getFirst().equals(b.getAuthor())) {
					find = true;
					i = l.getSecond();
					l.setSecond(i++);
				}
			}
			if (!find) {
				lista.add(new Pair <String,Integer> (b.getAuthor(),1));
			}
		}
		return lista;
		
	}

}
