package controller;

import javax.swing.JTextField;

import model.Libro;

public class BookController {
	
	private String[] strings;
	//private Libro book = new Libro();
	
	
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
		
		
		
		
		
	}
	
	
	
	
	

	

}
