package cartasoci;

import java.util.HashMap;
import java.util.Map;

import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;

public class FidelityCards implements IFidelityCards{
	
	private Map<Integer , User> cards = new HashMap<>();
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
		if (cards.containsValue(user.getName())) {
			cards.put(getNextId(), user);
		} else {
			throw new UserAlreadyExisting();
		}
		
	}
	
	public int getNextId(){		
		return this.next;
	}
	
	
	

}
