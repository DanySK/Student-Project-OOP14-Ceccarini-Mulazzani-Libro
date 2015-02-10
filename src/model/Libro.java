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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + copy;
		result = prime * result + ((editor == null) ? 0 : editor.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sold;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (copy != other.copy)
			return false;
		if (editor == null) {
			if (other.editor != null)
				return false;
		} else if (!editor.equals(other.editor))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (sold != other.sold)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
