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
/**
 * @author Chiara Ceccarini
 * @author Alberto Mulazzani
 *
 */
public class BookController implements IBookController{
	
	private String[] strings = null;
	private Libro book;
	private final IBookManagement magazzino = new BookManagement();
	private final IOrdini ordini = new Ordini();
	private TipoController type = TipoController.MAGAZZINO;
	
	/**
	 * 
	 * @param type
	 */
	public void setType(final TipoController type){
		this.type = type;
	}
	
	/**
	 * 
	 * @param fields
	 * @throws MissingDataException
	 * @throws WrongDataException
	 */
	public void setFields(final JTextField... fields) throws MissingDataException, WrongDataException{	
		checkData(fields);
		strings = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++){
			strings[i] = fields[i].getText();
		}
		setLibro(strings);	
	}
	
	/**
	 * 
	 * @param field
	 * @return
	 */
	private String toSearch(final JTextField field){
		return field.getText();
	}
	
	/**
	 * 
	 * @param strings
	 */
	private void setLibro(final String... strings){
		this.book = new Libro(strings);	
	}
	
	/**
	 * 
	 */
	public void addBook(){
		if (type.equals(TipoController.MAGAZZINO)){
			System.out.println("Magaz");
			magazzino.addBook(book);
		} else {
			System.out.println("Ordz");
			ordini.addBook(book);

		}
	}
	
	/**
	 * 
	 * @param b
	 * @param fields
	 * @throws WrongDataException
	 */
	public void modifyBook(final Libro b,final  JTextField... fields) throws WrongDataException{
		checkWrongs(fields);		
		String[] datas = new String[fields.length];		
		for (int i = 0; i < fields.length; i++){
			datas[i] = fields[i].getText();
		}	
		
		if (type.equals(TipoController.MAGAZZINO)) {
			magazzino.modifyBook(b, datas);

		} else {
			ordini.modifyBook(b, datas);
		}
	}
	
	public void sellBook(final Libro book ,final String nCopy) throws MissingBookException, NotEnoughBookException {
		magazzino.sellBook(book, Integer.parseInt(nCopy));
	}
	
	
	public List<Libro> searchTitle(final JTextField field) throws MissingBookException{
		return magazzino.searchBookTitle(toSearch(field));
	}
	
	public List<Libro> searchAuthor(final JTextField field) throws MissingBookException {
		return magazzino.searchBookAuthor(toSearch(field));
	}
	
	public Libro searchBook(final JTextField... fields) throws MissingBookException{
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
	
	public void remove (final Libro lib) {
		ordini.remove(lib);
	}
	
	public void evasioneOrdini () throws MissingBookException {
		if (ordini.bookList().isEmpty()) {
			throw new MissingBookException();
		}
		for (final Libro b:ordini.bookList()) {
			magazzino.addBook(b);
		}
		ordini.evasioneOrdini();
	}
	
	private void checkData(final JTextField... fields) throws MissingDataException, WrongDataException{
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
	
	
	private void checkWrongs(final JTextField... fields) throws WrongDataException{
		
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
	
}
