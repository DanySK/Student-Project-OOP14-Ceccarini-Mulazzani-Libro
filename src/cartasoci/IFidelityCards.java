package cartasoci;

import java.util.Map;

import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;

public interface IFidelityCards {
	
	/**
	 * 
	 * @param user
	 * @throws NullPointerException
	 * @throws UserAlreadyExisting
	 */
	
	public void addPerson(User user) throws NullPointerException, UserAlreadyExisting;
	
	/**
	 * 
	 * @param id
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 * @throws MissingUserException 
	 */
	
	public void removePerson(Integer id) throws NullPointerException, IllegalArgumentException, MissingUserException;
	
	/**
	 * 
	 * @param user
	 * @param fields
	 */
	
	public void modifyPerson (User user, String[] fields);
	
	/**
	 * 
	 * @param id is the Identifier to search
	 * @return the complete User
	 * @throws NullPointerException if id is Null
	 * @throws IllegalArgumentException if the id is not in the list
	 * @throws MissingUserException 
	 */
	
	
	public User searchID(Integer id) throws NullPointerException, IllegalArgumentException, MissingUserException;
	
	
	/**
	 * 
	 * @param name is the name to Search
	 * @return the complete User
	 * @throws NullPointerException if name is Null
	 * @throws IllegalArgumentException if the person is not in the list
	 * @throws MissingUserException 
	 */
	public User searchName(String name, String surname) throws NullPointerException, IllegalArgumentException, MissingUserException;
	
	/**
	 * 
	 * @return nextId
	 */
	
	public int getNextId();

	public Map<Integer, User> getMap();

	public void loadMemory(Map<Integer, User> map);
}
