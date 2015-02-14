package controller;

import java.util.List;

import utilities.Pair;
import model.IStatistics;
import model.Libro;
import model.Statistics;

/**
 * 
 * @author Chiara Ceccarini
 *
 */
public class StatisticsController implements IStatistics{
	
	final private Statistics statistics = new Statistics ();
	
	public List<Libro> mostPopularBook (final List <Libro> list) {
		return statistics.mostPopularBook(list);
	}
	
	public List<Libro> lessPopularBook (final List <Libro> list) {
		return statistics.lessPopularBook(list);
	}
	
	public List <Pair <String,Integer>> mostActiveAuthor (final List <Libro> list) {
		return statistics.mostActiveAuthor(list);
	}
	
	public List <Pair <String,Integer>> lessActiveAuthor (final List <Libro> list) {
		return statistics.lessActiveAuthor(list);
	}

}
