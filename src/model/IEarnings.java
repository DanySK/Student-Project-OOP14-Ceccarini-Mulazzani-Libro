package model;

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
	int bookSold ();
	
	/**
	 * 
	 * @return number of book in store
	 */
	int bookInStore ();
	
	/**
	 * 
	 * @return tot sold
	 */
	double totSell ();
	
	/**
	 * 
	 * @return tot Spent
	 */
	double totSpent();
	
	/**
	 * 
	 * @return tot earnings
	 */
	double totEarnings ();
	
}
