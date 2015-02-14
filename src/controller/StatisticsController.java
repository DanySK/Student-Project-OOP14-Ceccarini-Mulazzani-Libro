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
	
	private Statistics statistics = new Statistics ();
	
	public StatisticsController () {
		
	}
	
	public List<Libro> mostPopularBook (List <Libro> list) {
		return statistics.mostPopularBook(list);
	}
	
	public List<Libro> lessPopularBook (List <Libro> list) {
		return statistics.lessPopularBook(list);
	}
	
	public List <Pair <String,Integer>> mostActiveAuthor (List <Libro> list) {
		return statistics.mostActiveAuthor(list);
	}
	
	public List <Pair <String,Integer>> lessActiveAuthor (List <Libro> list) {
		return statistics.lessActiveAuthor(list);
	}

}
