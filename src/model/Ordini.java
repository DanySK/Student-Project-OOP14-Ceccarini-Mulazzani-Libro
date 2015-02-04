package model;

public class Ordini extends BasicOperations implements IOrdini {

	public Ordini () {
		
	}
	
	public void remove (Libro book) {
		super.libreria.remove(book);
	}

	public void evasioneOrdini() {
		super.libreria.clear();
	}

}
