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
public class BookController implements IBookController {
	
	private String[] strings = null;
	private Libro book;
	private final IBookManagement magazzino = new BookManagement();
	private final IOrdini ordini = new Ordini();
	private TipoController type = TipoController.MAGAZZINO;
	
	/**
	 * 
	 * @param ntype is the type to set 
	 */
	public void setType(final TipoController ntype) {
		this.type = ntype;
	}
	
	/**
	 * 
	 * @param fields to set
	 * @throws MissingDataException if some data is missing
	 * @throws WrongDataException if the data is wrong
	 */
	public void setFields(final JTextField... fields) throws MissingDataException, WrongDataException {	
		checkData(fields);
		strings = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++) {
			strings[i] = fields[i].getText();
		}
		setLibro(strings);	
	}
	
	/**
	 * 
	 * @param field
	 * @return the text of the field
	 */
	private String toSearch(final JTextField field) {
		return field.getText();
	}
	
	/**
	 * 
	 * @param nstrings of the fields of the book
	 */
	private void setLibro(final String... nstrings) {
		this.book = new Libro(nstrings);	
	}
	
	/**
	 * 
	 */
	public void addBook() {
		if (type.equals(TipoController.MAGAZZINO)) {
			System.out.println("Magaz");
			magazzino.addBook(book);
		} else {
			System.out.println("Ordz");
			ordini.addBook(book);

		}
	}
	
	/**
	 * 
	 * @param b the book to modify
	 * @param fields to modify
	 * @throws WrongDataException if the data is wrong
	 */
	public void modifyBook(final Libro b, final  JTextField... fields) throws WrongDataException {
		checkWrongs(fields);		
		String[] datas = new String[fields.length];		
		for (int i = 0; i < fields.length; i++) {
			datas[i] = fields[i].getText();
		}	
		
		if (type.equals(TipoController.MAGAZZINO)) {
			magazzino.modifyBook(b, datas);

		} else {
			ordini.modifyBook(b, datas);
		}
	}
	
	/**
	 * 
	 * @param nbook to sell
	 * @param nCopy of book to sell
	 * 
	 * @throws MissingBookException id the book is missing
	 * @throws NotEnoughBookException if there aren't enough copy of the book 
	 */
	public void sellBook(final Libro nbook, final String nCopy) throws MissingBookException, NotEnoughBookException {
		magazzino.sellBook(nbook, Integer.parseInt(nCopy));
	}
	
	/**
	 * 
	 * @param field of the title of the book to search
	 * @return the book with that title
	 * 
	 * @throws MissingBookException if the title is not in the library
	 */
	public List<Libro> searchTitle(final JTextField field) throws MissingBookException {
		return magazzino.searchBookTitle(toSearch(field));
	}
	
	/**
	 * 
	 * @param field of the author of the book to search
	 * @return the book with that title
	 * 
	 * @throws MissingBookException if the author is not in the library
	 */
	public List<Libro> searchAuthor(final JTextField field) throws MissingBookException {
		return magazzino.searchBookAuthor(toSearch(field));
	}
	
	/**
	 * 
	 * @param fields of the book to search
	 * @return the book with that title
	 * 
	 * @throws MissingBookException if the book is not in the library
	 */
	public Libro searchBook(final JTextField... fields) throws MissingBookException {
		if (type.equals(TipoController.MAGAZZINO)) {
			return magazzino.searchBook(fields[0].getText(), fields[1].getText());
		} else {
			return ordini.searchBook(fields[0].getText(), fields[1].getText());
		}
		
	}
	
	/**
	 * 
	 * @return the books in the library
	 */
	public List<Libro> bookList() {
		if (type.equals(TipoController.MAGAZZINO)) {
			return magazzino.bookList();
		} else {
			return ordini.bookList();
		}
		
	}
	
	/**
	 * 
	 * @param lib to remove
	 */
	public void remove(final Libro lib) {
		ordini.remove(lib);
	}
	
	/**
	 * 
	 * @throws MissingBookException if the book is not present
	 */
	public void evasioneOrdini() throws MissingBookException {
		if (ordini.bookList().isEmpty()) {
			throw new MissingBookException();
		}
		for (final Libro b:ordini.bookList()) {
			magazzino.addBook(b);
		}
		ordini.evasioneOrdini();
	}
	
	private void checkData(final JTextField... fields) throws MissingDataException, WrongDataException {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getText().length() == 0) {
				throw new MissingDataException();
			}
		}
		
		if (fields[4].getText().length() != 13 || Integer.parseInt(fields[2].getText()) > Calendar.getInstance().get(Calendar.YEAR)
				|| Integer.parseInt(fields[2].getText()) <= 0 || Double.parseDouble(fields[5].getText()) < 0
				|| Integer.parseInt(fields[6].getText()) < 0) {
			System.out.println(Calendar.YEAR);
			throw new WrongDataException();
		}
	}
	
	
	private void checkWrongs(final JTextField... fields) throws WrongDataException {
		
		if (fields[2].getText().length() != 0) {
			if (Integer.parseInt(fields[2].getText()) > Calendar.getInstance().get(Calendar.YEAR)
					|| Integer.parseInt(fields[2].getText()) <= 0) {
				throw new WrongDataException();
			}
		}
		
		if (fields[5].getText().length() != 0) {
			if (Double.parseDouble(fields[5].getText()) < 0) {
				throw new WrongDataException();
			}
		}
		
		if (fields[6].getText().length() != 0) {
			if (Integer.parseInt(fields[6].getText()) < 0) {
				throw new WrongDataException();
			}
		}
		
		if (fields[7].getText().length() != 0) {
			if (Integer.parseInt(fields[7].getText()) < 0) {
				throw new WrongDataException();
			}
		}
		
		
		if (fields[4].getText().length() != 13 && fields[4].getText().length() != 0) {
			throw new WrongDataException();
		}
	}
	
	/**
	 * 
	 * @param list of books
	 */
	public void loadMemory(final List<Libro> list) {
		
		if (type.equals(TipoController.MAGAZZINO)) {
			this.magazzino.setList(list);
		} else {
			this.ordini.setList(list);
		}
		
	}
	
}
