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

		checkEmpty(fields);
		checkData(fields);
		
		User user = new User(fields[0].getText(), fields[1].getText(), fields[2].getText());
		
		cards.addPerson(user);
		
	}

	
	public void removePerson(JTextField id) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		
		cards.removePerson(Integer.parseInt(id.getText()));
		
	}

	public void addPoints(JTextField[] fields, double price) throws NullPointerException, IllegalArgumentException, MissingUserException{
		
		Integer copies = Integer.parseInt(fields[2].getText());
		int tot = (int) ((copies * price) / 10);
		
		cards.addPoints(this.searchID(fields[3]), tot);
	}
	
	public User searchID(JTextField fields) throws NullPointerException,
			IllegalArgumentException, MissingUserException {

		return cards.searchID(Integer.parseInt(fields.getText()));
	}

	
	public User searchName(JTextField name, JTextField surname) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		return cards.searchName(name.getText(), surname.getText());
	}

	public Map<Integer, User> getMap(){
		return cards.getMap();
	}
	
	
	public void loadMemory(Map<Integer, User> map){
		cards.loadMemory(map);
	}
	
	private void checkData(JTextField[] fields) throws WrongDataException{
		

		if (fields[2].getText().length() != 0){
			if (!fields[2].getText().contains("@")){
				throw new WrongDataException();
			}			
		}

		
	}
	
	private void checkEmpty(JTextField[] fields) throws MissingDataException{
		
		for (int i = 0; i < fields.length; i++){
			if (fields[i].getText().length() == 0){
				throw new MissingDataException();
			}
		}
		
	}
	public void modifyUser(User b, JTextField[] jfields) throws WrongDataException {
		
			checkData(jfields);		
			String[] datas = new String[jfields.length];		
			for (int i = 0; i < jfields.length; i++){
				datas[i] = jfields[i].getText();
			}	
		
			
			cards.modifyPerson(b, datas);
			
		}
		
	}
	

