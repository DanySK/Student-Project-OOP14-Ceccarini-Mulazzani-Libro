package controller;

import java.util.Calendar;
import java.util.Set;

import javax.swing.JTextField;

import exceptions.MissingBookException;
import exceptions.MissingDataException;
import exceptions.WrongDataException;
import model.BookManagement;
import model.IBookManagement;
import model.IOrdini;
import model.Libro;
import model.Ordini;

public class BookController {
	
	private String[] strings;
	private Libro book;
	private IBookManagement model = new BookManagement();
	private IOrdini ordini = new Ordini();
	private String[] toSearch = new String[2];
	
	public BookController(){
		
	}
	
	public void banana(){
		
		System.out.println("banana");
	}
	
	
	public void setFields(JTextField[] fields) throws MissingDataException, WrongDataException{
		
		checkData(fields);
		strings = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++){
			
			strings[i] = fields[i].getText();
		}
		setLibro(strings);	
	}
	
	private String toSearch(JTextField field){
		
		return field.getText();
		
	}
	
	
	private void setLibro(String[] strings){

		this.book = new Libro(strings);	
	}
	
	
	public void addBook(){
		
		model.addBook(book);
	}
	
	
	public void modifyBook() throws MissingBookException{
		
		model.modifyBook(toSearch[0], toSearch[1], strings);
		
	}
	
	public void toSearch(JTextField[] fields){
		
		for (int i = 0; i < fields.length; i++){
			toSearch[i] = fields[i].getText();
		}
	}
	
	public void sellBook() throws MissingBookException{
		
		model.sellBook(book);
	}
	
	
	public Set<Libro> searchTitle(JTextField field) throws MissingBookException{
		
		
		return model.searchBookTitle(toSearch(field));
		
	}
	
	public Set<Libro> searchAuthor(JTextField field) throws MissingBookException {
		
		return model.searchBookAuthor(toSearch(field));
	}
	
	public Libro searchBook(JTextField[] fields) throws MissingBookException{
		
		return model.searchBook(fields[0].getText(), fields[1].getText());
	}
	
	public Set<Libro> bookList(){
		return model.bookList();
	}
	
	private void checkData(JTextField[] fields) throws MissingDataException, WrongDataException{
		
		for (int i = 0; i < fields.length; i++){
			if (fields[i].getText().length() == 0){
				throw new MissingDataException();
			}
		}
		
		if (fields[4].getText().length() != 13 || Integer.parseInt(fields[2].getText()) > Calendar.YEAR ||
				Integer.parseInt(fields[2].getText()) <= 0 || Double.parseDouble(fields[5].getText()) < 0 ||
				Integer.parseInt(fields[6].getText())< 0){
			throw new WrongDataException();
		}
		
		
		
	}
	

}
