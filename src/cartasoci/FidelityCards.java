package cartasoci;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;

/**
 * Basic model implementation of the Fidelity Cards
 * 
 * @author Alberto Mulazzani
 *
 */
public class FidelityCards implements IFidelityCards{
	
	private Map<Integer, User> cards = new HashMap<>();
	private int next;
	
	public FidelityCards(){
		this.next = 0;
	}
	
	
	public void removePerson(Integer id) throws MissingUserException{
		if (cards.containsKey(id)) {
			cards.remove(id);
		} else {
			throw new MissingUserException();
		}
	}

	@Override
	public User searchID(Integer id) throws MissingUserException {
		if (!cards.containsKey(id)){
			throw new MissingUserException();
		} else {
			return cards.get(id);
		}
		
	}

	@Override
	public User searchName(String name, String surname) throws MissingUserException {
		for (Entry<Integer, User> u:cards.entrySet()) {
			if (u.getValue().getName().equals(name) && u.getValue().getSurname().equals(surname)) {
				return u.getValue();
			}
		}
		throw new MissingUserException();
	}

	@Override
	public void addPerson(User user) throws NullPointerException, UserAlreadyExisting {
		containsUser(user);

		cards.put(getNextId(), user);
		user.setID(next);
		
	}
	@Override
	public void modifyPerson(User user, String[] fields) {
		for (int i=0; i <fields.length; i++) {
			if (!fields[i].isEmpty()) {
				switch (i) {
					case 0: 
						user.setName(fields[i]); 
						break;
					case 1: 
						user.setSurname(fields[i]); 
						break;
					case 2: 
						user.setEmail(fields[i]); 
						break;
				}
				
			}
		
		}

	}
	

	
	public Map<Integer, User> getMap(){
		return new HashMap<>(cards);
	}
	
	public void loadMemory(Map<Integer, User> map){
		this.cards = map;
		this.next = map.size();
	}
	
	public void addPoints(User u, int points){
		u.addPoints(points);
	}
	
	
	private void containsUser(User user) throws UserAlreadyExisting{
		for (Entry<Integer, User> e : cards.entrySet()){
			if (e.getValue().getName().equals(user.getName()) &&
					e.getValue().getSurname().equals(user.getSurname()) &&
							e.getValue().getEmail().equals(user.getEmail())){
				throw new UserAlreadyExisting();
			}
		}
	}
	
	private int getNextId(){
		this.next++;
		return this.next;
	}


	
}
