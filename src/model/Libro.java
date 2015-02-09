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
					switch (i) {

						case 0: this.title = fields[i]; break;
						case 1: this.author = fields[i]; break;
						case 2: this.year = Integer.parseInt(fields[i]); break;
						case 3: this.editor = fields[i]; break;
						case 4: this.isbn = fields[i]; break;
						case 5: this.price = Double.parseDouble(fields[i]); break;
						case 6: this.copy = Integer.parseInt(fields[i]); break;
						
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
	
	public void removeCopy (int copy) {
		this.copy -= copy;
		this.sold += copy;
	}
	
	public boolean checkData (String []fields) {
		
		return true;
		
	}
	
	public String[] getFields(){
		String[] str = new String[8];
		str[0] = this.title;
		str[1] = this.author;
		str[2] = "" + this.year;
		str[3] = this.editor;
		str[4] = this.isbn;
		str[5] = "" + this.price;
		str[6] = "" + this.copy;
		str[7] = "" + this.sold;		
		return str;
	}

}
