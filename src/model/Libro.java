package model;

/**
 * 
 * @author Chiara Ceccarini
 *
 */

public class Libro {
	
	private String title;
	private String author;
	private int year;
	private String editor;
	private String isbn;
	private double price;
	private int sold;
	private int copy;
	
	public Libro (String []fields) {
		if (checkData(fields)) {
			this.sold = 0;
			for (int i=0; i<fields.length; i++) {
				if (!fields[i].isEmpty()) {
					switch (i) {
						case 0: this.title = fields [i];
						case 1: this.author = fields [i];
						case 2: this.year = Integer.parseInt(fields[i]);
						case 3: this.editor = fields [i];
						case 4: this.isbn = fields [i];
						case 5: this.price = Integer.parseInt(fields[i]);
						case 6: this.copy = Integer.parseInt(fields[i]);
					}
					
				}
			}
		}
	}

	public String getTitle () {
		return this.title;
	}
	
	public String getAuthor () {
		return this.author;
	}
	
	public int getYear () {
		return this.year;
	}
	
	public String getEditor () {
		return this.editor;
	}
	
	public String getISBN () {
		return this.isbn;
	}
	
	public double getPrice () {
		return this.price;
	}
	
	public int getNSales () {
		return this.sold;
	}
	
	public int getNCopy () {
		return this.copy;
	}
	
	public void setTitle(String title){
		this.title = title;	
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setEditor(String editor){
		this.editor = editor;
	}
	
	public void setISBN(String isbn){
		this.isbn = isbn;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setNCopy(int copy){
		this.copy = copy;
	}
	
	public void addCopy (int copy) {
		this.copy += copy;
	}
	
	public void removeCopy () {
		this.copy--;
	}
	
	public boolean checkData (String []fields) {
		
		return true;
		
	}

}
