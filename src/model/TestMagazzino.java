package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceptions.MissingBookException;
import exceptions.NotEnoughBookException;

public class TestMagazzino {

	@Test
	public void test() {
		//creo la libreria
		IBookManagement lib = new BookManagement ();
		String fields [] = {"Titolo", "Autore", "1994", "Editore", "324", "32.5", "2" };
		String fields2 [] = {"", "", "1995", "", "", "14.7", "3" };
		//creo un nuovo libro
		Libro book = new Libro (fields);
		Libro bprova = new Libro (fields);
		List <Libro> list = new ArrayList <>();
		
		//inserisco il libro nella lista di prova
		list.add(book);
		
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
		//controllo che nella libreria rimanga sempre solo quel libro (cambieranno le copie presenti)
		assertTrue(lib.bookList().equals(list));
		assertTrue (lib.bookList().size() == 1);
		
		//modifico i campi del libro all'interno della libreria
		lib.modifyBook(book, fields2);
		//ho modificato l'anno, che è quindi diverso dal libro con i fields iniziali
		assertFalse (lib.bookList().get(0).getYear() == bprova.getYear());
		//cambiando il libro all'interno di lib cambio anche il libro di partenza
		assertTrue (lib.bookList().get(0).getYear() == book.getYear());
		
	}

}