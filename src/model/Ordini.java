package model;

public class Ordini extends BasicOperations implements IOrdini {
	
	public void remove (final Libro book) {
		super.libreria.remove(book);
	}

	public void evasioneOrdini() {
		super.libreria.clear();
	}

}
