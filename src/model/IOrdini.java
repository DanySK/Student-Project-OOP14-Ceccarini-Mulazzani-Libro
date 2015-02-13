package model;

/**
 * 
 * @author Chiara Ceccarini
 *
 */
public interface IOrdini extends IBasicOp{
	
	/**
	 * 
	 * @param book to remove
	 */
	void remove (Libro book);
	
	/**
	 * evade gli ordini
	 */
	void evasioneOrdini ();

}
