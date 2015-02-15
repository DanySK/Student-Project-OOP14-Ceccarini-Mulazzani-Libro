package controller;

import java.util.List;

import model.Earnings;
import model.IEarnings;
import model.Libro;

/**
 * 
 * @author Chiara Ceccarini
 *
 */
public class EarningsController implements IEarnings {
	
	private final Earnings earnings = new Earnings();
	
	/**
	 * 
	 * @param list of books 
	 * @return the books sold
	 */
	public int bookSold(final List <Libro> list) {
		return earnings.bookSold(list);
	}
	
	/**
	 * 
	 * @param list of books 
	 * @return the books in store
	 */
	public int bookInStore(final List <Libro> list) {
		return earnings.bookInStore(list);
	}
	
	/**
	 * 
	 * @param list of books 
	 * @return tot sell
	 */
	public double totSell(final List <Libro> list) {
		return earnings.totSell(list);
	}
	
	/**
	 * 
	 * @param list of books 
	 * @return tot spent
	 */
	public double totSpent(final List <Libro> list) {
		return earnings.totSpent(list);
	}
	
	/**
	 * 
	 * @param list of books 
	 * @return tot earnings
	 */
	public double totEarnings(final List <Libro> list) {
		return earnings.totSell(list) - earnings.totSpent(list);
	}
	
	
}
