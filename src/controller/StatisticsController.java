package controller;

import java.util.List;

import utilities.Pair;
import model.IStatistics;
import model.Libro;
import model.Statistics;

public class StatisticsController implements IStatistics{
	
	private Statistics statistics = new Statistics ();
	
	public StatisticsController () {
		
	}
	
	public List<Libro> mostPopularBook () {
		return statistics.mostPopularBook();
	}
	
	public List<Libro> lessPopularBook () {
		return statistics.lessPopularBook();
	}
	
	public List <Pair <String,Integer>> mostActiveAuthor () {
		return statistics.mostActiveAuthor();
	}
	
	public List <Pair <String,Integer>> lessActiveAuthor () {
		return statistics.lessActiveAuthor();
	}

}
