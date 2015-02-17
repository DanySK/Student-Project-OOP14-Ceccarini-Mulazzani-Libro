package model;

/**
 * 
 * @author Chiara Ceccarini
 *
 */
public interface ILibro {

	/**
	 * 
	 * @param ncopy is the number of copies to add
	 */
	void addCopy(final int ncopy);
	
	/**
	 * 
	 * @param ncopy is the number of copies to sell
	 */
	void removeCopy(final int ncopy);
	
	/**
	 * 
	 * @return the fields of the book
	 */
	String[] getFields();
	
}
