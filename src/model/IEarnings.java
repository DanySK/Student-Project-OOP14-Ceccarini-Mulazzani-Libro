package model;

import java.util.List;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public interface IEarnings {

	/**
	 * 
	 * @return the number of book sold
	 */
	int bookSold (List <Libro> list);
	
	/**
	 * 
	 * @return number of book in store
	 */
	int bookInStore (List <Libro> list);
	
	/**
	 * 
	 * @return tot sold
	 */
	double totSell (List <Libro> list);
	
	/**
	 * 
	 * @return tot Spent
	 */
	double totSpent(List <Libro> list);
	
	/**
	 * 
	 * @return tot earnings
	 */
	double totEarnings (List <Libro> list);
	
}
