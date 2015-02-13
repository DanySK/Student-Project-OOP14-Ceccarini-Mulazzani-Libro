package cartasoci;

import java.util.Map;

import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;

public interface IFidelityCards {
	
	/**
	 * Is the method that adds a new person in the map.
	 * 
	 * @param user is the User to add
	 * @throws NullPointerException
	 * @throws UserAlreadyExisting when the user is already in the map
	 */
	
	public void addPerson(User user) throws NullPointerException, UserAlreadyExisting;
	
	/**
	 *Removes a person from the map
	 * 
	 * @param id is the ID of the User to remove
	 * @throws NullPointerException when id is NULL
	 * @throws IllegalArgumentException when ID is not an Integer
	 * @throws MissingUserException when the ID is not present
	 */
	
	public void removePerson(Integer id) throws NullPointerException, IllegalArgumentException, MissingUserException;
	
	/**
	 * Modifies the user with a given array of Strings
	 * 
	 * @param user is the User to modify
	 * @param fields are the new fields of the User
	 */
	
	public void modifyPerson (User user, String[] fields);
	
	/**
	 * Searches the User using the ID
	 * 
	 * @param id is the Identifier to search
	 * @return the complete User
	 * @throws NullPointerException if id is Null
	 * @throws IllegalArgumentException if the id is not in the list
	 * @throws MissingUserException 
	 */
	
	
	public User searchID(Integer id) throws NullPointerException, IllegalArgumentException, MissingUserException;
	
	
	/**
	 * Searches the user using name and surname.
	 * 
	 * @param name is the name to Search
	 * @return the complete User
	 * @throws NullPointerException if name is Null
	 * @throws IllegalArgumentException if the person is not in the list
	 * @throws MissingUserException 
	 */
	public User searchName(String name, String surname) throws NullPointerException, IllegalArgumentException, MissingUserException;
		
	/**
	 * This is an utility method to save the datas.
	 * 
	 * @return the map, used to save
	 */
	public Map<Integer, User> getMap();
	
	/**
	 * This is an utility method to load the datas.
	 * 
	 * @param map is the map to load
	 */

	public void loadMemory(Map<Integer, User> map);
	
	
	/**
	 * Is a method that add points to the FidCard linked to the user
	 * 
	 * @param u is the user that will receive the points
	 * @param points are the points to add
	 */
	
	public void addPoints(User u, int points);
}
