package cartasoci;

public interface IFidelityCards {
	
	
	
	public void addPerson(Integer id, User user) throws NullPointerException;
	
	//TODO!!!
	
	public void removePerson() throws NullPointerException, IllegalArgumentException;
	
	/**
	 * 
	 * @param id is the Identifier to search
	 * @return the complete User
	 * @throws NullPointerException if id is Null
	 * @throws IllegalArgumentException if the id is not in the list
	 */
	
	
	public User searchID(Integer id) throws NullPointerException, IllegalArgumentException;
	
	
	/**
	 * 
	 * @param name is the name to Search
	 * @return the complete User
	 * @throws NullPointerException if name is Null
	 * @throws IllegalArgumentException if the person is not in the list
	 */
	public User searchName(String name) throws NullPointerException, IllegalArgumentException;
	
	public int getNextId();


}
