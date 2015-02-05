package model;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import exceptions.MissingBookException;
import exceptions.NotEnoughBookException;

public class Testordini {

	@Test
	public void test() {
		IOrdini ord = new Ordini ();

		IBookManagement lib = new BookManagement ();
		String fields [] = {"Titolo", "Autore", "1994", "Editore", "324", "32.5", "2" }  ;
		Libro book = new Libro (fields);
		HashSet <Libro> set = new HashSet <>();
		 
		set.add(book);
		ord.addBook(book);
		 
		assertTrue(ord.bookList().equals(set));
		assertTrue(ord.bookList().size() == 1);
		assertTrue(lib.bookList().size() == 0);
		assertFalse(lib.bookList().equals(set));
		
		lib.addBook(book);
		try {
			lib.sellBook(book, 2);
		} catch (MissingBookException e) {
			e.printStackTrace();
		} catch (NotEnoughBookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(lib.bookList().equals(set));
		
		ord.evasioneOrdini();
		//assertTrue(ord.bookList().isEmpty());
		assertEquals(ord.bookList().size(), 0);
		//assertFalse(ord.bookList().equals(set));
		

	}

}
