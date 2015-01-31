package model;

public class Libro {
	
	private String title;
	private String author;
	private int year;
	private String editor;
	private String isbn;
	private double price;
	private int sold;
	
	public Libro (String title, String author, int year, String editor, String isbn, double price) {
		if (checkData(title, author, year, editor, isbn, price)) {
			this.title = title;
			this.author = author;
			this.year = year;
			this.editor = editor;
			this.isbn = isbn;
			this.price = price;
			this.sold = 0;
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
	
	public boolean checkData (String title, String author, int year, String editor, String isbn, double price) {
		if (title == null || author == null || year == 0 || editor == null || isbn == null || price == 0) {
			
		}
		return true;
		
	}

}
