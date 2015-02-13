package model;

import java.util.List;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public class Earnings implements IEarnings{

	public Earnings () {
		
	}
	
	public int bookSold (List <Libro> list) {
		int sum = 0;
		for (Libro b:list) {
			sum += b.getNSales();
		}
		return sum;
	}
	
	public int bookInStore (List <Libro> list) {
		int sum = 0;
		for (Libro b:list) {
			sum += b.getNCopy();
		}
		return sum;
	}
	
	public double totSell (List <Libro> list) {
		double tot = 0;
		for (Libro b:list) {
			tot += b.getNSales()*b.getPrice();
		}
		return tot;
	}
	
	public double totSpent(List <Libro> list) {
		double tot = 0;
		for (Libro b:list) {
			tot += ((b.getNCopy()+b.getNSales())*(b.getPrice() * 0.76));
			
		}
		return tot;
	}
	
	public double totEarnings (List <Libro> list) {
		return totSell(list)-totSpent(list);
	}
}
