package model;

public class Ordini extends BasicOperations implements IOrdini {

	public Ordini () {
		
	}
	
	public void remove (Ordini o) {
		super.libreria.remove(o);
	}

	public void evasioneOrdini() {
		super.libreria.clear();
	}

}
