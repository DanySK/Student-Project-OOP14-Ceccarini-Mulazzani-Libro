package model;

import java.util.List;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public class Earnings implements IEarnings{

	public int bookSold (final List <Libro> list) {
		int sum = 0;
		for (final Libro b:list) {
			sum += b.getNSales();
		}
		return sum;
	}
	
	public int bookInStore (final List <Libro> list) {
		int sum = 0;
		for (final Libro b:list) {
			sum += b.getNCopy();
		}
		return sum;
	}
	
	public double totSell (final List <Libro> list) {
		double tot = 0;
		for (final Libro b:list) {
			tot += b.getNSales()*b.getPrice();
		}
		return tot;
	}
	
	public double totSpent(final List <Libro> list) {
		double tot = 0;
		for (final Libro b:list) {
			tot += (b.getNCopy()+b.getNSales())*(b.getPrice() * 0.76);
			
		}
		return tot;
	}
	
	public double totEarnings (final List <Libro> list) {
		return totSell(list)-totSpent(list);
	}
}
