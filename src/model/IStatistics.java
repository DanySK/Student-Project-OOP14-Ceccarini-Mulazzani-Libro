package model;

import java.util.List;

import utilities.Pair;

public interface IStatistics {
	
	List<Libro> mostPopularBook ();
	
	List<Libro> lessPopularBook ();
	
	List <Pair <String,Integer>> mostActiveAuthor ();
	
	List <Pair <String,Integer>> lessActiveAuthor ();
}
