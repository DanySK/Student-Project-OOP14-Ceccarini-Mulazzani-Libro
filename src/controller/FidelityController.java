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

public class FidelityController {
	
	private IFidelityCards cards = new FidelityCards();
	
	public void addPerson(JTextField[] fields) throws
			UserAlreadyExisting, MissingDataException, WrongDataException {

		checkData(fields);
		
		User user = new User(fields[0].getText(), fields[1].getText(), fields[2].getText());
		
		cards.addPerson(user);
		
	}

	
	public void removePerson(Integer id) throws NullPointerException,
			IllegalArgumentException, MissingUserException {

		
	}

	
	public User searchID(Integer id) throws NullPointerException,
			IllegalArgumentException, MissingUserException {

		return null;
	}

	
	public User searchName(String name) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, User> getMap(){
		return cards.getMap();
		
	}
	
	public void loadMemory(Map<Integer, User> map){
		cards.loadMemory(map);
	}
	
	private void checkData(JTextField[] fields) throws MissingDataException, WrongDataException{
		
		for (int i = 0; i < fields.length; i++){
			if (fields[i].getText().length() == 0){
				throw new MissingDataException();
			}
		}
		
		if (!fields[2].getText().contains("@")){
			throw new WrongDataException();
		}
		
		
	}
	
	

}
