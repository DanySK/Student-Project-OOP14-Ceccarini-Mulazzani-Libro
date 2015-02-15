package controller;

import java.util.Map;

import javax.swing.JTextField;

import cartasoci.User;
import exceptions.MissingDataException;
import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;
import exceptions.WrongDataException;

public interface IFidelityController {
	
	void addPerson(final JTextField[] fields) throws
	UserAlreadyExisting, MissingDataException, WrongDataException;
	
	void removePerson(final JTextField id) throws NullPointerException,
	IllegalArgumentException, MissingUserException;

	void addPoints(final JTextField[] fields,final double price) throws NullPointerException, IllegalArgumentException, MissingUserException;

	User searchID(final JTextField fields) throws NullPointerException,
	IllegalArgumentException, MissingUserException;


	User searchName(final JTextField name,final JTextField surname) throws NullPointerException,
	IllegalArgumentException, MissingUserException;

	Map<Integer, User> getMap();

	int getCurrent();


	void loadMemory(final Map<Integer, User> map);

	void modifyUser(final User b,final JTextField[] jfields) throws WrongDataException;


}
