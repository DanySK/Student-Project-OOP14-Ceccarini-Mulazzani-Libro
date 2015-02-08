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
	
	//private IBookManagement elenco = new BookManagement ();
	//private List <Libro> library = new ArrayList <>();  

	public Statistics () {
	}
	
	public List<Libro> mostPopularBook (List <Libro> list) {
		list.sort((b1,b2)->b2.getNSales() - b1.getNSales());
		return list;
	}
	
	public List<Libro> lessPopularBook (List <Libro> list) {
		list.sort((b1,b2)->b1.getNSales() - b2.getNSales());
		return list;
	}
	
	public List <Pair <String,Integer>> mostActiveAuthor (List <Libro> list) {
		final List <Pair<String, Integer>> lista = createList(list);
		
		Collections.sort(lista, (p1,p2) -> p2.getSecond()-p1.getSecond());
		
		return lista;
	}
	
	public List <Pair <String,Integer>> lessActiveAuthor (List <Libro> list) {
		final List <Pair<String, Integer>> lista = createList(list);
		
		Collections.sort(lista, (p1,p2) -> p1.getSecond()-p2.getSecond());
		
		return lista;
	}
	
	private List <Pair <String,Integer>> createList (List <Libro> list) {
		final List <Pair<String, Integer>> library = new ArrayList <>();
		boolean find = false;
		int i = 0;
		for (Libro b:list) {
			for (Pair<String, Integer> l:library) {
				if (l.getFirst().equals(b.getAuthor())) {
					find = true;
					i = l.getSecond();
					l.setSecond(i++);
				}
			}
			if (!find) {
				library.add(new Pair <String,Integer> (b.getAuthor(),1));
			}
		}
		return library;
		
	}

}
