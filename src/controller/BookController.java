package controller;

import javax.swing.JTextField;

import model.BookManagement;
import model.IBookManagement;
import model.Libro;

public class BookController {
	
	private String[] strings;
	private Libro book;
	private IBookManagement model = new BookManagement();
	
	
	public BookController(){
		
	}
	
	
	public void setFields(JTextField[] fields){
		
		strings = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++){
			
			strings[i] = fields[i].getText();
		}
	
		setLibro(strings);
		
	}
	
	private void setLibro(String[] strings){

		this.book = new Libro(strings);	
	}
	
	
	public void addBook(){
		
		
	}
	
	
	
	
	
	

	

}
