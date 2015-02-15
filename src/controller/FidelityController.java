package controller;

import java.util.Map;

import javax.swing.JTextField;

import cartasoci.FidelityCards;
import cartasoci.IFidelityCards;
import cartasoci.User;
import exceptions.MissingDataException;
import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;
import exceptions.WrongDataException;

/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class FidelityController implements IFidelityController {
	
	private final IFidelityCards cards = new FidelityCards();
	
	/**
	 * 
	 * @param fields of the user to add
	 * @throws UserAlreadyExisting if the user is already in the map
	 * @throws MissingDataException if some data is missing
	 * @throws WrongDataException if some data is wrong
	 */
	public void addPerson(final JTextField... fields) throws
			UserAlreadyExisting, MissingDataException, WrongDataException {

		checkEmpty(fields);
		checkData(fields);
		
		final User user = new User(fields[0].getText(), fields[1].getText(), fields[2].getText());
		cards.addPerson(user);	
	}

	/**
	 * 
	 * @param id of the user to remove
	 * @throws NullPointerException if fields are null
	 * @throws IllegalArgumentException if there are illegal argument
	 * @throws MissingUserException if the user is not in the map
	 */
	public void removePerson(final JTextField id) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		
		cards.removePerson(Integer.parseInt(id.getText()));
	}

	/**
	 * 
	 * @param fields of the user
	 * @param price of the book sold
	 * @throws NullPointerException if fields are null
	 * @throws IllegalArgumentException if there are illegal argument
	 * @throws MissingUserException if the user is not in the map
	 */
	public void addPoints(final JTextField[] fields, final double price) throws NullPointerException, 
		IllegalArgumentException, MissingUserException {
		
		final Integer copies = Integer.parseInt(fields[2].getText());
		final int tot = (int) ((copies * price) / 10);
		
		cards.addPoints(this.searchID(fields[3]), tot);
	}
	
	/**
	 * 
	 * @param fields id to search
	 * @return the user
	 * @throws NullPointerException if fields are null
	 * @throws IllegalArgumentException if there are illegal argument
	 * @throws MissingUserException if the user is not in the map
	 */
	public User searchID(final JTextField fields) throws NullPointerException,
			IllegalArgumentException, MissingUserException {

		return cards.searchID(Integer.parseInt(fields.getText()));
	}

	/**
	 * 
	 * @param name of user
	 * @param surname of user
	 * @return the user
	 * @throws NullPointerException if fields are null
	 * @throws IllegalArgumentException 
	 * @throws MissingUserException if the user is not in the map
	 */
	public User searchName(final JTextField name, final JTextField surname) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		return cards.searchName(name.getText(), surname.getText());
	}

	/**
	 * 
	 * @return the map with id and user
	 */
	public Map<Integer, User> getMap() {
		return cards.getMap();
	}
	
	/**
	 * 
	 * @return the current id
	 */
	public int getCurrent() {
		return cards.getCurrent();
	}
	
	/**
	 * 
	 * @param map to load
	 */
	public void loadMemory(final Map<Integer, User> map) {
		cards.loadMemory(map);
	}
	
	private void checkData(final JTextField... fields) throws WrongDataException {

		if (fields[2].getText().length() != 0) {
			if (!fields[2].getText().contains("@")) {
				throw new WrongDataException();
			}			
		}

		
	}
	
	private void checkEmpty(final JTextField... fields) throws MissingDataException { 
		
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getText().length() == 0) {
				throw new MissingDataException();
			}
		}
		
	}
	
	/**
	 * 
	 * @param b user to modify
	 * @param jfields the fields to modify
	 * @throws WrongDataException if some data is wrong
	 */
	public void modifyUser(final User b, final JTextField... jfields) throws WrongDataException {
		
			checkData(jfields);		
			String[] datas = new String[jfields.length];		
			for (int i = 0; i < jfields.length; i++) {
				datas[i] = jfields[i].getText();
			}	
		
			cards.modifyPerson(b, datas);
		}	
	}
	

