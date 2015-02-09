package cartasoci;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;

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
	public User searchName(String name) throws MissingUserException {
		for (User u:cards.values()) {
			if (u.getName().equals(name)) {
				return u;
			}
		}
		throw new MissingUserException();
	}

	@Override
	public void addPerson(User user) throws NullPointerException, UserAlreadyExisting {
		containsUser(user);
		cards.put(getNextId(), user);
		
		
	}
	
	public int getNextId(){
		this.next++;
		return this.next;
	}
	
	public Map<Integer, User> getMap(){
		
		return new HashMap<>(cards);
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
	
	
	
	
	

}
