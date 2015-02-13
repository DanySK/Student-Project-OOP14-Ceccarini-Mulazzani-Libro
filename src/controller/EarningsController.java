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
	
	private Earnings earnings = new Earnings ();
	
	public EarningsController () {
		
	}
	
	public int bookSold (List <Libro> list) {
		return earnings.bookSold(list);
	}
	
	public int bookInStore (List <Libro> list) {
		return earnings.bookInStore(list);
	}
	
	public double totSell (List <Libro> list) {
		return earnings.totSell(list);
	}
	
	public double totSpent(List <Libro> list) {
		return earnings.totSpent(list);
	}
	
	public double totEarnings (List <Libro> list) {
		return earnings.totSell(list) - earnings.totSpent(list);
	}
	
	
}
