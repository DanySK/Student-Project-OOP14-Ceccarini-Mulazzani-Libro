package controller;

import java.util.Calendar;
import java.util.Set;

import javax.swing.JTextField;

import utilities.ControllerUtilities.TipoController;
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
	private IBookManagement magazzino = new BookManagement();
	private IOrdini ordini = new Ordini();
	private String[] toSearch = new String[2];
	private TipoController type = TipoController.MAGAZZINO;
	
	public BookController(){
		
	}
	
	public void setType(TipoController type){
		this.type = type;
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
		if (type.equals(TipoController.MAGAZZINO)){
			System.out.println("Magaz");
			magazzino.addBook(book);
		} else {
			System.out.println("Ordz");
			ordini.addBook(book);
		}
	}
	
	
	public void modifyBook() throws MissingBookException{	
		if (type.equals(TipoController.MAGAZZINO)) {
			magazzino.modifyBook(toSearch[0], toSearch[1], strings);
		} else {
			ordini.modifyBook(toSearch[0], toSearch[1], strings);
		}
		
	}
	
	public void toSearch(JTextField[] fields){	
		for (int i = 0; i < fields.length; i++){
			toSearch[i] = fields[i].getText();
		}
	}
	
	public void sellBook() throws MissingBookException{
		magazzino.sellBook(book);
	}
	
	
	public Set<Libro> searchTitle(JTextField field) throws MissingBookException{
		return magazzino.searchBookTitle(toSearch(field));
	}
	
	public Set<Libro> searchAuthor(JTextField field) throws MissingBookException {
		return magazzino.searchBookAuthor(toSearch(field));
	}
	
	public Libro searchBook(JTextField[] fields) throws MissingBookException{
		if (type.equals(TipoController.MAGAZZINO)) {
			return magazzino.searchBook(fields[0].getText(), fields[1].getText());
		} else {
			return ordini.searchBook(fields[0].getText(), fields[1].getText());
		}
		
	}
	
	public Set<Libro> bookList(){
		if (type.equals(TipoController.MAGAZZINO)) {
			return magazzino.bookList();
		} else {
			return ordini.bookList();
		}
		
	}
	
	public void remove () {
		ordini.remove(book);
	}
	
	public void evasioneOrdini () {
		for (Libro b:ordini.bookList()) {
			magazzino.addBook(b);
		}
		ordini.evasioneOrdini();
	}
	
	private void checkData(JTextField[] fields) throws MissingDataException, WrongDataException{
		for (int i = 0; i < fields.length; i++){
			if (fields[i].getText().length() == 0){
				throw new MissingDataException();
			}
		}
		
		if (fields[4].getText().length() != 13 || Integer.parseInt(fields[2].getText()) > Calendar.getInstance().get(Calendar.YEAR) ||
				Integer.parseInt(fields[2].getText()) <= 0 || Double.parseDouble(fields[5].getText()) < 0 ||
				Integer.parseInt(fields[6].getText())< 0){
			System.out.println(Calendar.YEAR);
			throw new WrongDataException();
		}	
		
	}
	
	
	public static void saveAll(){
		
	}
	

}
