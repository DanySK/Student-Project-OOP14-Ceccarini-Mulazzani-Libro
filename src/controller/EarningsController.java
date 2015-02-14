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
public class EarningsController implements IEarnings{
	
	final private Earnings earnings = new Earnings ();
	
	public int bookSold (final List <Libro> list) {
		return earnings.bookSold(list);
	}
	
	public int bookInStore (final List <Libro> list) {
		return earnings.bookInStore(list);
	}
	
	public double totSell (final List <Libro> list) {
		return earnings.totSell(list);
	}
	
	public double totSpent(final List <Libro> list) {
		return earnings.totSpent(list);
	}
	
	public double totEarnings (final List <Libro> list) {
		return earnings.totSell(list) - earnings.totSpent(list);
	}
	
	
}
