package controller;

import java.util.Calendar;
import java.util.List;

import javax.swing.JTextField;

import model.BookManagement;
import model.IBookManagement;
import model.IOrdini;
import model.Libro;
import model.Ordini;
import utilities.ControllerUtilities.TipoController;
import exceptions.MissingBookException;
import exceptions.MissingDataException;
import exceptions.NotEnoughBookException;
import exceptions.WrongDataException;

public class BookController {
	
	private String[] strings;
	private Libro book;
	private IBookManagement magazzino = new BookManagement();
	private IOrdini ordini = new Ordini();
	private String[] toSearch = new String[2];
	private TipoController type = TipoController.MAGAZZINO;
	
	public BookController() {

		
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
			toSave();
		}
	}
	
	/*
	public void modifyBook() throws MissingBookException{	
		if (type.equals(TipoController.MAGAZZINO)) {
			magazzino.modifyBook(toSearch[0], toSearch[1], strings);
			toSave();
		} else {
			ordini.modifyBook(toSearch[0], toSearch[1], strings);
			toSave();
		}
		
	}*/
	
	
	public void modifyBook(Libro b,  JTextField[] fields) throws WrongDataException{
		checkWrongs(fields);
		
		
		String[] datas = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++){
			datas[i] = fields[i].getText();
		}
		
		
		if (type.equals(TipoController.MAGAZZINO)) {
			magazzino.modifyBook(b, datas);
			toSave();
		} else {
			ordini.modifyBook(b, datas);
			toSave();
		}
	}
	
	public void toSearch(JTextField[] fields){	
		for (int i = 0; i < fields.length; i++){
			toSearch[i] = fields[i].getText();
		}
	}
	
	public void sellBook(Libro book , String nCopy) throws MissingBookException, NotEnoughBookException {
		magazzino.sellBook(book,Integer.parseInt(nCopy));
		toSave();
	}
	
	
	public List<Libro> searchTitle(JTextField field) throws MissingBookException{
		return magazzino.searchBookTitle(toSearch(field));
	}
	
	public List<Libro> searchAuthor(JTextField field) throws MissingBookException {
		return magazzino.searchBookAuthor(toSearch(field));
	}
	
	public Libro searchBook(JTextField[] fields) throws MissingBookException{
		if (type.equals(TipoController.MAGAZZINO)) {
			return magazzino.searchBook(fields[0].getText(), fields[1].getText());
		} else {
			return ordini.searchBook(fields[0].getText(), fields[1].getText());
		}
		
	}
	
	public List<Libro> bookList(){
		if (type.equals(TipoController.MAGAZZINO)) {
			return magazzino.bookList();
		} else {
			return ordini.bookList();
		}
		
	}
	
	public void remove (Libro lib) {
		ordini.remove(lib);
		toSave();
	}
	
	public void evasioneOrdini () throws MissingBookException {
		if (ordini.bookList().isEmpty()) {
			throw new MissingBookException ();
		}
		for (Libro b:ordini.bookList()) {
			magazzino.addBook(b);
			//SaveClass.setLib(magazzino);
		}
		ordini.evasioneOrdini();
		toSave();
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
	
	
	private void checkWrongs(JTextField[] fields) throws WrongDataException{
		
		if (fields[2].getText().length() != 0){
			if (Integer.parseInt(fields[2].getText()) > Calendar.getInstance().get(Calendar.YEAR) || Integer.parseInt(fields[2].getText()) <= 0){
				throw new WrongDataException();
			}
		}
		
		if (fields[5].getText().length() != 0){
			if (Double.parseDouble(fields[5].getText()) < 0){
				throw new WrongDataException();
			}
		}
		
		if (fields[6].getText().length() != 0){
			if (Integer.parseInt(fields[6].getText()) < 0){
				throw new WrongDataException();
			}
		}
		
		if (fields[7].getText().length() != 0){
			if (Integer.parseInt(fields[7].getText()) < 0){
				throw new WrongDataException();
			}
		}
		
		
		if (fields[4].getText().length() != 13 && fields[4].getText().length() != 0){
			throw new WrongDataException();
		}
	}
	
	public void loadMemory(final List<Libro> list){
		
		if (type.equals(TipoController.MAGAZZINO)){
			this.magazzino.setList(list);
		}else{
			this.ordini.setList(list);
		}
		
	}
	
	private void toSave(){
	/*	if (type.equals(TipoController.MAGAZZINO)){
			SaveClass.setLib(magazzino);
		}else{
			SaveClass.setOrd(ordini);
		}*/
	}

}
