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
	
	private final IFidelityCards cards = new FidelityCards();
	
	public void addPerson(final JTextField[] fields) throws
			UserAlreadyExisting, MissingDataException, WrongDataException {

		checkEmpty(fields);
		checkData(fields);
		
		final User user = new User(fields[0].getText(), fields[1].getText(), fields[2].getText());
		
		cards.addPerson(user);
		
	}

	
	public void removePerson(final JTextField id) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		
		cards.removePerson(Integer.parseInt(id.getText()));
		
	}

	public void addPoints(final JTextField[] fields,final double price) throws NullPointerException, IllegalArgumentException, MissingUserException{
		
		final Integer copies = Integer.parseInt(fields[2].getText());
		final int tot = (int) ((copies * price) / 10);
		
		cards.addPoints(this.searchID(fields[3]), tot);
	}
	
	public User searchID(final JTextField fields) throws NullPointerException,
			IllegalArgumentException, MissingUserException {

		return cards.searchID(Integer.parseInt(fields.getText()));
	}

	
	public User searchName(final JTextField name,final JTextField surname) throws NullPointerException,
			IllegalArgumentException, MissingUserException {
		return cards.searchName(name.getText(), surname.getText());
	}

	public Map<Integer, User> getMap(){
		return cards.getMap();
	}
	
	public int getCurrent(){
		return cards.getCurrent();
	}
	
	
	public void loadMemory(final Map<Integer, User> map){
		cards.loadMemory(map);
	}
	
	private void checkData(final JTextField[] fields) throws WrongDataException{
		

		if (fields[2].getText().length() != 0){
			if (!fields[2].getText().contains("@")){
				throw new WrongDataException();
			}			
		}

		
	}
	
	private void checkEmpty(final JTextField[] fields) throws MissingDataException{
		
		for (int i = 0; i < fields.length; i++){
			if (fields[i].getText().length() == 0){
				throw new MissingDataException();
			}
		}
		
	}
	public void modifyUser(final User b,final JTextField[] jfields) throws WrongDataException {
		
			checkData(jfields);		
			String[] datas = new String[jfields.length];		
			for (int i = 0; i < jfields.length; i++){
				datas[i] = jfields[i].getText();
			}	
		
			
			cards.modifyPerson(b, datas);
			
		}
		
	}
	

