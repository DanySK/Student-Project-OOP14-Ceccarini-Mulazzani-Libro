package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceptions.MissingBookException;
import exceptions.NotEnoughBookException;

public class Testordini {

	@Test
	public void test() {
		//creo la lista degli ordini
		IOrdini ord = new Ordini ();
		//creo la libreria
		IBookManagement lib = new BookManagement ();
		String fields [] = {"Titolo", "Autore", "1994", "Editore", "324", "32.5", "2" }  ;
		//creo un nuovo libro
		Libro book = new Libro (fields);
		List <Libro> list = new ArrayList <>();
		//inserisco il libro nella lista di prova
		list.add(book);
		//inserisco il libro negli ordini
		ord.addBook(book);
		 
		//controllo che nella lista degli ordini sia presente solo il libro appena inserito
		assertTrue(ord.bookList().equals(list));
		//controllo quindi che la sua size sia 1
		assertTrue(ord.bookList().size() == 1);
		//controllo che nella libreria inizialmente non ci sia alcun libro
		assertTrue(lib.bookList().size() == 0);
		//controllo che il libro non sia presente nella libreria
		assertFalse(lib.bookList().equals(list));
		
		//aggiungo il libro alla libreria
		lib.addBook(book);
		//se il libro è presente, ne vendo due copie
		try {
			lib.sellBook(book, 2);
		} catch (MissingBookException | NotEnoughBookException e) {
			e.printStackTrace();
		} 
		//controllo che nella libreria rimanga sempre quel libro (cambieranno le copie presenti)
		assertTrue(lib.bookList().equals(list));
		
		//evado gli ordini
		ord.evasioneOrdini();
		//controllo che non ci siano più ordini
		assertTrue(ord.bookList().isEmpty());
		//controllo che non ci sia più il libro
		assertFalse(ord.bookList().equals(list));
		

	}

}
