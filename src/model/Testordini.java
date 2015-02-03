package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testordini {

	@Test
	public void test() {
		IOrdini ord = new Ordini ();
		 String fields [] = {"Titolo", "Autore", "1994", "Editore", "324", "32.5", "2" }  ;
		 Libro book = new Libro (fields);
		 ord.addBook(book);
		 //ord.bookList();
		 assertTrue(ord.equals(book));
	}

}
