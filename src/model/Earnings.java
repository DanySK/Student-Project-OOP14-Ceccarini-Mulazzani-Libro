package model;

import java.util.ArrayList;
import java.util.List;

public class Earnings implements IEarnings{
	private IBookManagement elenco = new BookManagement ();
	private List <Libro> library = new ArrayList <>();  

	public Earnings () {
		library.addAll(elenco.bookList());
	}
	
	public int bookSold () {
		int sum = 0;
		for (Libro b:library) {
			sum += b.getNSales();
		}
		return sum;
	}
	
	public int bookInStore () {
		int sum = 0;
		for (Libro b:library) {
			sum += b.getNCopy();
		}
		return sum;
	}
	
	public double totSell () {
		double tot = 0;
		for (Libro b:library) {
			tot += b.getNSales()*b.getPrice();
		}
		return tot;
	}
	
	public double totSpent() {
		double tot = 0;
		for (Libro b:library) {
			tot += (b.getNCopy()+b.getNSales())*b.getPrice()*(70/100);
		}
		return tot;
	}
	
	public double totEarnings () {
		return totSell()-totSpent();
	}
}
