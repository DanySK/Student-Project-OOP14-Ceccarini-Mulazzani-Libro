package controller;

import model.Earnings;
import model.IEarnings;

public class EarningsController implements IEarnings{
	
	private Earnings earnings = new Earnings ();
	
	public EarningsController () {
		
	}
	
	public int bookSold () {
		return earnings.bookSold();
	}
	
	public int bookInStore () {
		return earnings.bookInStore();
	}
	
	public double totSell () {
		return earnings.totSell();
	}
	
	public double totSpent() {
		return earnings.totSpent();
	}
	
	public double totEarnings () {
		return earnings.totSell() - earnings.totSpent();
	}
}
