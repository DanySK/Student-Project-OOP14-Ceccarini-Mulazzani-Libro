package model;

import java.util.List;

import utilities.Pair;
/**
 * 
 * @author Chiara Ceccarini
 *
 */

public interface IStatistics {
	
	/**
	 * 
	 * @return a list of most popular book
	 */
	public List<Libro> mostPopularBook ();
	
	/**
	 * 
	 * @return a list of less popular book
	 */
	public List<Libro> lessPopularBook ();
	
	/**
	 * 
	 * @return a list of most active author
	 */
	public List <Pair <String,Integer>> mostActiveAuthor ();
	
	/**
	 * 
	 * @return a list of less active author
	 */
	public List <Pair <String,Integer>> lessActiveAuthor ();
}
