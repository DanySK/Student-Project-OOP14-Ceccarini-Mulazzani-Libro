package controller;

import java.util.List;

import javax.swing.JTextField;

import model.Libro;
import utilities.ControllerUtilities.TipoController;
import exceptions.MissingBookException;
import exceptions.MissingDataException;
import exceptions.NotEnoughBookException;
import exceptions.WrongDataException;

public interface IBookController {

	
	void addBook();
	
	void setType(final TipoController type);
	
	void setFields(final JTextField[] fields) throws MissingDataException, WrongDataException;

	void modifyBook(final Libro b,final  JTextField[] fields) throws WrongDataException;
	
	void sellBook(final Libro book ,final String nCopy) throws MissingBookException, NotEnoughBookException;
	
	List<Libro> searchTitle(final JTextField field) throws MissingBookException;
	
	List<Libro> searchAuthor(final JTextField field) throws MissingBookException;
	
	Libro searchBook(final JTextField[] fields) throws MissingBookException;
	
	List<Libro> bookList();
	
	void remove(final Libro lib);
	
	void evasioneOrdini() throws MissingBookException;
	
	
	void loadMemory(final List<Libro> list);

	
}
